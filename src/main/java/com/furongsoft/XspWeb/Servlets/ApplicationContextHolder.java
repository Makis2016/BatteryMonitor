package com.furongsoft.XspWeb.Servlets;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import com.furongsoft.XspWeb.Common.Tracker;

/**
 * 定义ApplicationContext存储器类型
 * 
 * @author Alex
 */
public class ApplicationContextHolder implements ApplicationContextAware
{
    private static ApplicationContext sApplicationContext;

    @Override
    public void setApplicationContext(ApplicationContext arg0)
        throws BeansException
    {
        sApplicationContext = arg0;
    }

    /**
     * @return ApplicationContext
     */
    public static ApplicationContext get()
    {
        return sApplicationContext;
    }

    /**
     * 获取已定义的Bean
     * 
     * @param name
     *            Bean名称
     * 
     * @return Bean对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name)
    {
        checkApplicationContext();

        try {
            return (T) sApplicationContext.getBean(name);
        }
        catch (Exception e) {
            throw new IllegalStateException(
                "Bean " + name + " not found in servlet-context.xml");
        }
    }

    /**
     * 获取已定义的Bean
     * 
     * @param name
     *            Bean名称
     * 
     * @return Bean对象
     */
    public static <T> T tryGetBean(String name)
    {
        try {
            return getBean(name);
        }
        catch (Exception e) {
            Tracker.e(e);
            return null;
        }
    }

    /**
     * 获取已定义的Bean
     * 
     * @param clazz
     *            Bean类型名称
     * 
     * @return Bean对象列表
     */
    public static <T> Map<String, T> getBean(Class<T> clazz)
    {
        checkApplicationContext();
        return (Map<String, T>) sApplicationContext.getBeansOfType(clazz);
    }

    /**
     * 获取资源
     * 
     * @param location
     *            资源路径
     * 
     * @return 资源对象
     */
    public static Resource getResource(String location)
    {
        checkApplicationContext();
        return sApplicationContext.getResource(location);
    }

    /**
     * 获取资源路径
     * 
     * @param location
     *            资源路径
     * 
     * @return 资源 路径
     */
    public static String getResourcePath(String location)
    {
        try {
            Resource resource = getResource(location);
            return ((resource != null) ? resource.getFile().getAbsolutePath() : null);
        }
        catch (IOException e) {
            return null;
        }
    }

    /**
     * 注册Bean对象
     * 
     * @param name
     *            Bean名称
     * @param beanDefinition
     *            Bean定义信息
     * 
     * @return Bean对象,失败返回null
     */
    public static
        Object registerBean(String name, BeanDefinition beanDefinition)
    {
        if (sApplicationContext.containsBean(name))
            return null;

        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) sApplicationContext;
        BeanDefinitionRegistry beanDefinitonRegistry = (BeanDefinitionRegistry) configurableApplicationContext
            .getBeanFactory();
        beanDefinitonRegistry.registerBeanDefinition(name, beanDefinition);

        return sApplicationContext.getBean(name);
    }

    private static void checkApplicationContext()
    {
        if (sApplicationContext == null)
            throw new IllegalStateException(
                "ApplicationContextHolder not found in servlet-context.xml");
    }
}
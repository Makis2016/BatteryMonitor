package com.furongsoft.XspWeb.Common;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

public class BaseBean implements ApplicationContextAware
{
    protected ApplicationContext mApplicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
        throws BeansException
    {
        mApplicationContext = applicationContext;
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
    protected <T> T getBean(String name)
    {
        checkApplicationContext();

        try {
            return (T) mApplicationContext.getBean(name);
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
    protected <T> T tryGetBean(String name)
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
    protected <T> Map<String, T> getBean(Class<T> clazz)
    {
        checkApplicationContext();
        return (Map<String, T>) mApplicationContext.getBeansOfType(clazz);
    }

    /**
     * 获取资源
     * 
     * @param location
     *            资源路径
     * 
     * @return 资源对象
     */
    protected Resource getResource(String location)
    {
        checkApplicationContext();
        return mApplicationContext.getResource(location);
    }

    /**
     * 注册Bean对象
     * 
     * @param name
     *            Bean名称
     * @param beanDefinitionBuilder
     *            Bean定义信息
     * 
     * @return Bean对象,失败返回null
     */
    protected Object registerBean(String name, BeanDefinition beanDefinition)
    {
        if (mApplicationContext.containsBean(name))
            return null;

        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) mApplicationContext;
        BeanDefinitionRegistry beanDefinitonRegistry = (BeanDefinitionRegistry) configurableApplicationContext
            .getBeanFactory();
        beanDefinitonRegistry.registerBeanDefinition(name, beanDefinition);

        return mApplicationContext.getBean(name);
    }

    private void checkApplicationContext()
    {
        if (mApplicationContext == null)
            throw new IllegalStateException(
                "ApplicationContextHolder not found in servlet-context.xml");
    }
}
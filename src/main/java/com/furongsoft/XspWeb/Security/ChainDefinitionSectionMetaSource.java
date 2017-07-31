package com.furongsoft.XspWeb.Security;

import java.text.MessageFormat;
import java.util.List;

import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.furongsoft.XspWeb.Common.Tracker;
import com.furongsoft.XspWeb.Security.Entities.PermissionEntity;
import com.furongsoft.XspWeb.Security.Services.SecurityService;
import com.furongsoft.XspWeb.Utils.StringUtils;

public class ChainDefinitionSectionMetaSource
    implements FactoryBean<Ini.Section>
{
    /**
     * 默认permission字符串
     */
    private static final String PREMISSION_STRING = "authc,perms[\"{0}\"]";

    @Autowired
    public SecurityService securityService;

    private String filterChainDefinitions;

    @Override
    public Section getObject() throws Exception
    {
        Ini ini = new Ini();
        ini.load(filterChainDefinitions);

        Ini.Section section = ini
            .getSection(IniFilterChainResolverFactory.URLS);
        if (CollectionUtils.isEmpty(section))
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME);

        List<PermissionEntity> list;

        try {
            list = securityService.getPermissions();
            if (list == null)
                return section;
        }
        catch (Exception e) {
            Tracker.e(e);
            return section;
        }

        for (PermissionEntity item : list) {
            if (StringUtils.isNullOrEmpty(item.getName()) || StringUtils
                .isNullOrEmpty(item.getPermission()))
                continue;

            section.put(
                item.getName(),
                MessageFormat.format(PREMISSION_STRING, item.getPermission()));
        }

        return section;
    }

    @Override
    public Class<?> getObjectType()
    {
        return Section.class;
    }

    @Override
    public boolean isSingleton()
    {
        return true;
    }

    public void setFilterChainDefinitions(String filterChainDefinitions)
    {
        this.filterChainDefinitions = filterChainDefinitions;
    }
}
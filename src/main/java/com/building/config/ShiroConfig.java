package com.building.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    // 权限管理，配置主要是Realm的管理认证
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getRealm());
        return securityManager;
    }

    //创建ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro内置过滤器实现拦截
        Map<String,String> filterMap=new LinkedHashMap<>();
        filterMap.put("/add","authc");
        filterMap.put("/update","authc");
        filterMap.put("/login","anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        shiroFilterFactoryBean.setLoginUrl("/login");
        return shiroFilterFactoryBean;
    }
    //创建DefaultWebSecurityManager
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") com.building.config.UserRealm userRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //关联Realm  并加密
        HashedCredentialsMatcher matcher=new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);
        userRealm.setCredentialsMatcher(matcher);
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //创建自定义Realm对象，
    @Bean(name = "userRealm")
    public com.building.config.UserRealm getRealm(){
        return new com.building.config.UserRealm();
    }
}

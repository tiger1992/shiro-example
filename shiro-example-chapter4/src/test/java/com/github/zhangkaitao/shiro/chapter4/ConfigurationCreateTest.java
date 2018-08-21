package com.github.zhangkaitao.shiro.chapter4;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-27
 * <p>Version: 1.0
 */
public class ConfigurationCreateTest {

    @Test
    public void test() {

        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-config.ini");

        SecurityManager securityManager = factory.getInstance();

        //将SecurityManager设置到SecurityUtils 方便全局使用
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        subject.login(token);
        
        System.out.println("subject.isAuthenticated() = " + subject.isAuthenticated());



    }
}

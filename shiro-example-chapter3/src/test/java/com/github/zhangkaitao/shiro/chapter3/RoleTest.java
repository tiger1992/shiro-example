package com.github.zhangkaitao.shiro.chapter3;

import java.util.Arrays;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-26
 * <p>Version: 1.0
 */
public class RoleTest extends BaseTest {

    @Test
    public void testHasRole() {
    	
    	Subject	subject = login("classpath:shiro-role.ini", "zhang", "123");
      
        //判断拥有角色：role1
        System.out.println("1、是否拥有此角色："+subject.hasRole("role2"));
        
        //判断拥有角色：role1 and role2
        System.out.println("2、是否拥有全部角色："+subject.hasAllRoles(Arrays.asList("role1", "role2")));
        
        //判断拥有角色：role1 and role2 and !role3
        boolean[] result = subject.hasRoles(Arrays.asList("role1", "role2", "role3"));
        System.out.println("result[0]:"+result[0]);
        System.out.println("result[1]:"+result[1]);
        System.out.println("result[2]:"+result[2]);
    }

    @Test(expected = UnauthorizedException.class)
    public void testCheckRole() {
    	Subject	subject = login("classpath:shiro-role.ini", "zhang", "123");
        //断言拥有角色：role1
        subject.checkRole("role1");
        //断言拥有角色：role1 and role3 失败抛出异常
        subject.checkRoles("role1", "role3");
    }

}

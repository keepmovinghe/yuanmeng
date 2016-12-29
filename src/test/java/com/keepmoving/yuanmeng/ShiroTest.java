package com.keepmoving.yuanmeng;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author chenxh
 * @date 2016年12月1日
 */
public class ShiroTest {

	@Test
	public void testHelloworld() {
		try {
			// 获取SecurityManager 工厂 使用Ini配置文件初始化SecurityManager
			Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro.ini");
			// 得到SecurityManager实例
			SecurityManager securityManager = factory.getInstance();
			// 将SecurityManager 绑定给SecurityUtils
			SecurityUtils.setSecurityManager(securityManager);
			// 得到Subject
			Subject subject = SecurityUtils.getSubject();
			// 创建用户名/密码身份验证token
			UsernamePasswordToken token = new UsernamePasswordToken("zhangg", "123");
			try {
				// 登录
				subject.login(token);
			} catch (AuthenticationException e) {
				e.printStackTrace();
				// 验证失败
			}
			// 断言用户已经登录
			Assert.assertEquals(true, subject.isAuthenticated());
			// 退出
			subject.logout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testJdbcRealm() {
		try {
			// 获取SecurityManager 工厂 使用Ini配置文件初始化SecurityManager
			Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro-jdbc-realm.ini");
			// 得到SecurityManager实例
			SecurityManager securityManager = factory.getInstance();
			// 将SecurityManager 绑定给SecurityUtils
			SecurityUtils.setSecurityManager(securityManager);
			// 得到Subject
			Subject subject = SecurityUtils.getSubject();
			// 创建用户名/密码身份验证token
			UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
			try {
				// 登录
				subject.login(token);
			} catch (AuthenticationException e) {
				e.printStackTrace();
				// 验证失败
			}catch(Exception e){
				e.printStackTrace();
			}
			// 断言用户已经登录
			Assert.assertEquals(true, subject.isAuthenticated());
			// 退出
			subject.logout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

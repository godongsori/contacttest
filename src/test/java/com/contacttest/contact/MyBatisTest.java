package com.contacttest.contact;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.contacttest.contact.domain.Users;
import com.contacttest.contact.service.UsersService;

public class MyBatisTest {

	@Test
	public void test() throws Exception {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/webapp/WEB-INF/mybatis/mybatis-context.xml");
		UsersService usersService = (UsersService)context.getBean("usersServiceImpl");
		
		//1. UsersService.insertUsers Test
		
		//Test Users instance 생성
		Users users = new Users();
		users.setEmail("dddd@hanmail.net");
		users.setPassword("1234");
		users.setName("정지영");
		
		assertNotNull(usersService.insertUsers(users));
	}

}

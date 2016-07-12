package com.ane56.dispatch.application;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ane56.dispatch.AbstractTest;
import com.ane56.dispatch.application.command.CreateUserCommand;
import com.ane56.dispatch.domain.user.User;

public class UserApplicationServiceTest extends AbstractTest {

	@Autowired
	private UserApplicationService userApplicationService;

//	static {
//
//		try {
//			String resource = "mybatis/mybatis-config.xml";
//			InputStream inputStream = Resources.getResourceAsStream(resource);
//
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			MybatisUserRepository repository = new MybatisUserRepository();
//			repository.setSqlSessionFactory(sqlSessionFactory);
//			
//			userApplicationService = new UserApplicationService(repository);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	@Test
	public void testAddUser() {
		userApplicationService.addUser(new CreateUserCommand("abc", "123456", "abc1234567"));
	}

	@Test
	public void testAllUsers() {
		
		List<User> users =  userApplicationService.allUsers();
		
		for( User user : users) {
			System.out.println(user.getId());
		}
		
		
	}

	@Test
	public void testAllUsersIntInt() {
		
	}

}
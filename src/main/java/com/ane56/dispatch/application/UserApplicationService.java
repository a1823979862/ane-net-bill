package com.ane56.dispatch.application;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ane56.db.mybatis.Pagination;
import com.ane56.dispatch.application.command.CreateUserCommand;
import com.ane56.dispatch.domain.user.User;
import com.ane56.dispatch.domain.user.UserRepository;
import com.ane56.dispatch.port.adapter.utils.IdUtils;

@Service
public class UserApplicationService {

	@Autowired
	private UserRepository userRepository;


	public void addUser(CreateUserCommand aCommand) {

		User user = new User();
		user.setId(IdUtils.id());
		user.setCreated(new Date());
		user.setStatus(true);
		user.setNikename(aCommand.getNikename());
		user.setUsername(aCommand.getUsername());
		user.setPassword(aCommand.getPassword());

		this.userRepository().add(user);
	}

	public List<User> allUsers() {
		return this.userRepository().allUsers();
	}

	public Pagination<User> allUsers(int start, int limit) {
		return this.userRepository().allUsers(start, limit);
	}

	private UserRepository userRepository() {
		return this.userRepository;
	}

}

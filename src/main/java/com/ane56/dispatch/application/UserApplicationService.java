package com.ane56.dispatch.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ane56.db.mybatis.Pagination;
import com.ane56.dispatch.application.command.user.CreateUserCommand;
import com.ane56.dispatch.application.command.user.UpdateUserCommand;
import com.ane56.dispatch.domain.user.User;
import com.ane56.dispatch.domain.user.UserRepository;

@Service
public class UserApplicationService {

	@Autowired
	private UserRepository userRepository;

	public void add(CreateUserCommand aCommand) {
		User user = new User(aCommand.getUsername(), aCommand.getPassword(), aCommand.getNikename());
		this.userRepository().add(user);
	}

	public void update(UpdateUserCommand aCommand) {
		User user = this.userRepository().findById(aCommand.getId());
		user.update(aCommand.getUsername(), aCommand.getPassword(), aCommand.getNikename());
		this.userRepository().save(user);
	}

	public void remove(long userId) {
		User user = this.userRepository().findById(userId);
		this.userRepository().remove(user);
	}

	public User getUser(long userId) {
		return this.userRepository().findById(userId);
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

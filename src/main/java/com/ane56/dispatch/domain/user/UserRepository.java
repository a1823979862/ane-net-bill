package com.ane56.dispatch.domain.user;

import java.util.List;

import com.ane56.db.mybatis.Pagination;

public interface UserRepository {

	void add(User user);

	void save(User user);

	void remove(User user);

	User findById(long userId);

	List<User> allUsers();

	Pagination<User> allUsers(int start, int limit);

}

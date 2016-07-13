package com.ane56.dispatch.port.adapter.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ane56.db.mybatis.MybatisRepository;
import com.ane56.db.mybatis.Pagination;
import com.ane56.db.mybatis.query.QueryBuilder;
import com.ane56.dispatch.domain.user.User;
import com.ane56.dispatch.domain.user.UserRepository;

//@Component
public class SpringMybatisUserRepository extends SpringMybatisRepositorySupport implements UserRepository {

	@Override
	public void add(User user) {
		this.repository().insert(user);
	}

	@Override
	public void save(User user) {
		this.repository().update(user);
	}

	@Override
	public void remove(User user) {
		this.repository().delete(user);
	}

	@Override
	public User findById(long userId) {
		User user = this.repository().queryBy(new QueryBuilder(User.class).eq("id", userId).build());
		return user;
	}

	@Override
	public List<User> allUsers() {
		return this.repository().query(new QueryBuilder(User.class).build());
	}

	@Override
	public Pagination<User> allUsers(int start, int limit) {
		return this.repository().query(new QueryBuilder(User.class).build(), start, limit);
	}

}

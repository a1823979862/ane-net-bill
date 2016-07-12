package com.ane56.dispatch.port.adapter.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ane56.db.mybatis.MybatisRepositorySupport;
import com.ane56.db.mybatis.Pagination;
import com.ane56.db.mybatis.query.QueryBuilder;
import com.ane56.dispatch.domain.user.User;
import com.ane56.dispatch.domain.user.UserRepository;

@Component
public class MybatisUserRepository extends MybatisRepositorySupport implements UserRepository {

	@Autowired
	public MybatisUserRepository(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}

	@Override
	public void add(User user) {
		insert(user);
	}

	@Override
	public void save(User user) {
		update(user);
	}

	@Override
	public void remove(User user) {
		delete(user);
	}

	@Override
	public User findById(long userId) {
		User user = queryBy(new QueryBuilder(User.class).eq("id", userId).build());
		return user;
	}

	@Override
	public List<User> allUsers() {
		return query(new QueryBuilder(User.class).build());
	}

	@Override
	public Pagination<User> allUsers(int start, int limit) {
		return query(new QueryBuilder(User.class).build(), start, limit);
	}

}

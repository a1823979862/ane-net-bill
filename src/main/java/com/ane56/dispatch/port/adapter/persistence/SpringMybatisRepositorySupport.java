package com.ane56.dispatch.port.adapter.persistence;

import org.springframework.beans.factory.annotation.Autowired;

import com.ane56.db.mybatis.MybatisRepository;

public class SpringMybatisRepositorySupport {

	@Autowired
	private MybatisRepository mybatisRepository;

	public void setMybatisRepository(MybatisRepository mybatisRepository) {
		this.mybatisRepository = mybatisRepository;
	}

	protected MybatisRepository repository() {
		return this.mybatisRepository;
	}

}

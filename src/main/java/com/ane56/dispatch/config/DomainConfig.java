package com.ane56.dispatch.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.ane56.db.mybatis.core.PaginationInterceptor;
import com.ane56.db.mybatis.core.SqlEntityInterceptor;
import com.ane56.db.mybatis.core.SqlQueryInterceptor;
import com.ane56.db.mybatis.dialect.MySQLDialect;

@Configuration
@ComponentScan(basePackages = { "com.ane56.dispatch.port.adapter.persistence" })
public class DomainConfig {

	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

		Resource[] resources = applicationContext.getResources("classpath:mybatis/*.xml");
		sqlSessionFactoryBean.setMapperLocations(resources);
		sqlSessionFactoryBean.setDataSource(dataSource);

		List<Interceptor> interceptors = new ArrayList<>();
		interceptors.add(new SqlEntityInterceptor());
		MySQLDialect dialect = new MySQLDialect();
		interceptors.add(new SqlQueryInterceptor(dialect));
		interceptors.add(new PaginationInterceptor(dialect));
		sqlSessionFactoryBean.setPlugins(interceptors.toArray(new Interceptor[0]));
		return sqlSessionFactoryBean;
	}

}

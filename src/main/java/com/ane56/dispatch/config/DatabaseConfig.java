package com.ane56.dispatch.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource({ "classpath:jdbc.properties" })
public class DatabaseConfig {

	@Autowired
	private Environment env;


	@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));

		int min = Integer.parseInt(env.getProperty("jdbc.min", "10"));
		int max = Integer.parseInt(env.getProperty("jdbc.max", "20"));

		dataSource.setInitialSize(min);
		dataSource.setMinIdle(min);
		dataSource.setMaxActive(max);
		dataSource.setTestOnBorrow(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setValidationQuery("SELECT 1");
		return dataSource;
	}

	
}

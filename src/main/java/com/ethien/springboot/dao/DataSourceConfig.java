package com.ethien.springboot.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Component
public class DataSourceConfig {

	@Bean
	public HikariDataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:hsqldb:mem:.");
		config.setUsername("sa");
		config.setPassword("");
		return new HikariDataSource(config);
	}
}

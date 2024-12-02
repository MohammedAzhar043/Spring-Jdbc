package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.Dao.StudentDaoImpl;

@Configuration
public class JavaConfig {

	@Bean
	public DriverManagerDataSource getDriverManagerDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {

		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDriverManagerDataSource());
		return template;
	}

	@Bean("studentdaoimpl")
	public StudentDaoImpl getstudentDaoImpl() {

		StudentDaoImpl student = new StudentDaoImpl();
		student.setTemplet(getJdbcTemplate());

		return student;
	}
}

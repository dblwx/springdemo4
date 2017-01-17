package com.lwx.spring.jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.DataSources;

public class JDBCTest {
	
	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate; 
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	}
	
	/**
	 * select delete update
	 */
	@Test
	public void testUpdate(){
		String sql = "update user set usercode = ? where id = ?";
		jdbcTemplate.update(sql, 13281061,1);
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class); 
		System.out.println(dataSource.getConnection());
	}

}

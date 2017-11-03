package com.thomaskopton.springmvc01config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan("com.thomaskopton.springmvc01")
public class RootApplicationContextConfig {
	
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();

		// returns the actual database, creating a db object omitted
		return  builder
				.setType(EmbeddedDatabaseType.HSQL)
				.addScript("db/sql/create-table.sql")
				.addScript("db/sql/insert-data.sql")
				.build();
	}
	
	@Bean
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource());
	}
}


package com.example.carsdatabaseapp;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DbConfig {

    DataSource dataSource;


    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate()
    {
        return new JdbcTemplate(dataSource);

    }
}

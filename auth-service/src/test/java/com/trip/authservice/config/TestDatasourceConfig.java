package com.trip.authservice.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@TestConfiguration
public class TestDatasourceConfig {

    @Bean
    public DataSource dataSource() {
        var hikariDataSource = (HikariDataSource) DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:testdb;MODE=MySQL")
                .username("SA")
                .password("")
                .build();

        return hikariDataSource;
    }
}

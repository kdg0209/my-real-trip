package com.trip.authservice.config;

import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class IntegrationTest {

    static MySQLContainer mySQLContainer;

    static {
        mySQLContainer = new MySQLContainer<>("mysql:8.0.30")
                .withDatabaseName("test")
                .withCommand("mysqld --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci");
        mySQLContainer.start();
    }

    @Autowired
    private DatabaseCleanup databaseCleanup;

    @AfterEach
    void after() {
        databaseCleanup.execute();
    }
}

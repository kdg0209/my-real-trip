package com.trip.authservice.config;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {TestDatasourceConfig.class})
public abstract class IntegrationTest {
}

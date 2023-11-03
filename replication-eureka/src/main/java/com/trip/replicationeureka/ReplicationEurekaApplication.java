package com.trip.replicationeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ReplicationEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReplicationEurekaApplication.class, args);
	}

}

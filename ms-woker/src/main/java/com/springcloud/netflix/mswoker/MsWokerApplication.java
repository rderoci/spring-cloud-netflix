package com.springcloud.netflix.mswoker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsWokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsWokerApplication.class, args);
	}

}

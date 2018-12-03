package com.brucejanet.activmq_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages={"com.brucejanet"})
public class ActivmqDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivmqDemoApplication.class, args);
	}
}

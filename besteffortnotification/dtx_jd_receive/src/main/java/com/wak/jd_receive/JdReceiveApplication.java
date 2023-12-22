package com.wak.jd_receive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.wak.jd_receive.mapper"})
@EnableDiscoveryClient
@EnableFeignClients
public class JdReceiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdReceiveApplication.class, args);
	}

}

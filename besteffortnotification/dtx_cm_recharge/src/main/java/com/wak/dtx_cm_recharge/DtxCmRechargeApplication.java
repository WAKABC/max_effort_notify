package com.wak.dtx_cm_recharge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.wak.dtx_cm_recharge.mapper"})
@EnableDiscoveryClient
public class DtxCmRechargeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DtxCmRechargeApplication.class, args);
	}

}

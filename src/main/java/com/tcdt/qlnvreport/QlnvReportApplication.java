package com.tcdt.qlnvreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = { "com.tcdt.qlnvreport.entities","com.tcdt.qlnvreport.table" })
public class QlnvReportApplication {
	public static void main(String[] args) {
		SpringApplication.run(QlnvReportApplication.class, args);
	}

}

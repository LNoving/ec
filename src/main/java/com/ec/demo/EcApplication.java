package com.ec.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 张昊
 */
@SpringBootApplication
public class EcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcApplication.class, args);
	}

}

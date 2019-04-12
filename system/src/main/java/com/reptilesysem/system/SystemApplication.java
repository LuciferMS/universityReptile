package com.reptilesysem.system;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SystemApplication {


	public static void main(String[] args) {
		SpringApplication.run(SystemApplication.class, args);
		log.info("============ the application has started ==========");
	}

}


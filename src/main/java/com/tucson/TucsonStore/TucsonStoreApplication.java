package com.tucson.TucsonStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TucsonStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TucsonStoreApplication.class, args);
	}

}

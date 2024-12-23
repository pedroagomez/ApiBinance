package com.binance.ScrapBin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScrapBinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrapBinApplication.class, args);
	}

}

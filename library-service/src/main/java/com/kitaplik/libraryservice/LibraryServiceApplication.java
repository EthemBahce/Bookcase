package com.kitaplik.libraryservice;

import com.kitaplik.libraryservice.client.RetreiveMessageErrorDecoder;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class LibraryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceApplication.class, args);
	}




//Feign Client Error Handling example how to trigger this class and method.
	/*
	@Bean
	public ErrorDecoder errorDecoder(){
		return new RetreiveMessageErrorDecoder();
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
	*/


}

package com.vivekchutke.microservices.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	
	// Running the Service through Zuul
	// http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR
	// http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/1000
	// http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/333
	
}

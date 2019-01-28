package com.wipro.Register;

import   org.springframework.boot.SpringApplication;
import   org.springframework.boot.autoconfigure.SpringBootApplication;
import   org.springframework.boot.autoconfigure.cloud.CloudAutoConfiguration;
import   org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import   org.springframework.cloud.netflix.hystrix.EnableHystrix;
import   org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import   org.springframework.cloud.netflix.ribbon.RibbonClient;
import   org.springframework.context.annotation.Bean;
import   org.springframework.web.client.RestTemplate;
import   com.netflix.client.config.IClientConfig;
import   com.netflix.loadbalancer.IRule;
import   com.netflix.loadbalancer.RandomRule;


@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@RibbonClient(name = "cloud-provider", configuration = CloudProviderConfiguration.class)
public class RegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
class CloudProviderConfiguration {
@Bean
public IRule ribbonRule(IClientConfig config) {
	return new RandomRule();
    }		       
}







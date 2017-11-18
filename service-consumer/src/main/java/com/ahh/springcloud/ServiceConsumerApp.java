package com.ahh.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/11/18.
 */

@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableScheduling
@EnableFeignClients
@SpringBootApplication
public class ServiceConsumerApp {

  @Bean
  @LoadBalanced
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    new SpringApplicationBuilder(ServiceConsumerApp.class).web(true).run(args);
  }
}
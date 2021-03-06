package com.ahh.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Administrator on 2017/11/18.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProviderApp {

  public static void main(String[] args) {
    new SpringApplicationBuilder(ServiceProviderApp.class).web(true).run(args);
  }
}
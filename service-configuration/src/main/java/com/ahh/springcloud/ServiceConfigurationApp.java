package com.ahh.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by Administrator on 2017/11/18.
 */

@EnableConfigServer
@SpringBootApplication
public class ServiceConfigurationApp {

  public static void main(String[] args) {
    new SpringApplicationBuilder(ServiceConfigurationApp.class).web(true).run(args);
  }
}
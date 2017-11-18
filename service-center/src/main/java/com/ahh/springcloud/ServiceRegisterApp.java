package com.ahh.springcloud;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Administrator on 2017/11/17.
 */
@EnableEurekaServer
@SpringBootApplication
public class ServiceRegisterApp {
  private static Logger logger = Logger.getLogger(ServiceRegisterApp.class);

  public static void main(String[] args) {
    new SpringApplicationBuilder(ServiceRegisterApp.class).web(true).run(args);

    logger.info("Service Register Application start Success.");
  }
}
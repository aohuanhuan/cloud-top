package com.ahh.springcloud.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/18.
 */
@RestController
public class ComputeServiceRest {

  private static Logger logger = Logger.getLogger(ComputeServiceRest.class);

  @Autowired
  private DiscoveryClient client;

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
    ServiceInstance instance = client.getLocalServiceInstance();
    Integer resp = a + b;
    logger.info(
        "/add, host:" + instance.getHost() + ", port:" + instance.getPort() + ", service_id:"
            + instance.getServiceId() + ", result:" + resp);
    return resp;
  }
}
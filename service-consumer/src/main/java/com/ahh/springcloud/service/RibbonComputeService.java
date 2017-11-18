package com.ahh.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.text.MessageFormat;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/11/18.
 */
@Service
public class RibbonComputeService {

  @Autowired
  private RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "addServiceFallback")
  public Integer addService(Integer a, Integer b) {
    String restUrl = "http://COMPUTE-SERVICE/add?a={0}&b={1}";
    restUrl = MessageFormat.format(restUrl, a, b);

    ResponseEntity<String> responseEntity = restTemplate.getForEntity(restUrl, String.class);
    String body = responseEntity.getBody();

    return NumberUtils.toInt(body);
  }

  /**
   * 当调用add服务断路时，调用此方法
   */
  private Integer addServiceFallback(Integer a, Integer b) {
    return -1;
  }
}
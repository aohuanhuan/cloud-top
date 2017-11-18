package com.ahh.springcloud.service;

import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/18.
 */
@Service
public class FetchConfigService {

  private static Logger logger = Logger.getLogger(FetchConfigService.class);

  @Value("${vs_addr}")
  private String vs_addr;

  @PostConstruct
  public void init() {
    logger.info("Get Param of [vs_addr] is: " + vs_addr);
  }
}
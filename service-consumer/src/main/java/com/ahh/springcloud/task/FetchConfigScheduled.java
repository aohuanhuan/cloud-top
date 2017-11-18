package com.ahh.springcloud.task;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/18.
 */
@Service
@RefreshScope
public class FetchConfigScheduled {

  private static Logger logger = Logger.getLogger(FetchConfigScheduled.class);

  @Value("${vs_addr}")
  private String vs_addr;

  @Scheduled(fixedRate = 5000)
  public void fetchConfigs() {
    logger.info("Get Param of [vs_addr] is: " + vs_addr);
  }
}

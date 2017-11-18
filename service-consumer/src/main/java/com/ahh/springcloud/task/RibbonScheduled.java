package com.ahh.springcloud.task;

import com.ahh.springcloud.constant.ConsumerConst;
import com.ahh.springcloud.service.RibbonComputeService;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/18.
 */
@Service
public class RibbonScheduled {

  private static Logger logger = Logger.getLogger(RibbonScheduled.class);

  @Autowired
  private RibbonComputeService ribbonComputeService;

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss.SSS");

  @Scheduled(fixedRate = 5000)
  public void invokeAddService() {
    Integer value = ribbonComputeService.addService(100, 150);

    String resp = MessageFormat
        .format(ConsumerConst.respTemplate, "Ribbon+Hystrix", dateFormat.format(new Date()), value);

    logger.info(resp);
  }
}
package com.ahh.springcloud.task;

import com.ahh.springcloud.constant.ConsumerConst;
import com.ahh.springcloud.service.FeignComputeService;
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
public class FeignScheduled {

  private static Logger logger = Logger.getLogger(RibbonScheduled.class);

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
      "yyyy-MM-dd HH:mm:ss.SSS");

  @Autowired
  private FeignComputeService feignComputeService;

  @Scheduled(fixedRate = 5000)
  public void invokeAddService() {
    Integer value = feignComputeService.add(500, 500);

    String resp = MessageFormat
        .format(ConsumerConst.respTemplate, "Feign+Hystrix", dateFormat.format(new Date()), value);

    logger.info(resp);
  }
}

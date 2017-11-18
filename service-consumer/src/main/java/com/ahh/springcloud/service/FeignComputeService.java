package com.ahh.springcloud.service;

import com.ahh.springcloud.fallback.FeignHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/11/18.
 */
@FeignClient(value = "compute-service", fallback = FeignHystrix.class)
public interface FeignComputeService {

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
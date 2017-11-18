package com.ahh.springcloud.fallback;

import com.ahh.springcloud.service.FeignComputeService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/18.
 */
@Service
public class FeignHystrix implements FeignComputeService {

  @Override
  public Integer add(Integer a, Integer b) {
    return -9999;
  }
}
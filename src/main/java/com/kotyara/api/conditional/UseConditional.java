package com.kotyara.api.conditional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@ConditionalOnProperty(
    name = "useMyBean",
    havingValue = "true"
)
@Slf4j
@Component
public class UseConditional {

  @PostConstruct
  public void init(){
    log.info("from conditional");
  }
}

package com.demo.wordhub;

import cn.dev33.satoken.SaManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@SpringBootApplication
@PropertySource(value = "classpath:application.yml", encoding = "UTF-8")
public class WordHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordHubApplication.class, args);
        log.info(SaManager.getConfig().toString());
    }

}

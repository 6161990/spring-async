package com.yoon.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync /** application 에 async 로 동작할 수 있는 설정*/
public class AsyncConfig {
}

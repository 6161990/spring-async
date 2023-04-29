package com.yoon.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Async("defaultTaskExecutor")
    public void sendEmail(){
        System.out.println("[sendEmail 1] :: "+ Thread.currentThread().getName());
    }

    @Async("messagingTaskExecutor")
    public void sendEmailWithCustomThreadPool(){
        System.out.println("[sendEmail messagingTaskExecutor 1] :: "+ Thread.currentThread().getName());
    }
}

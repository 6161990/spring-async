package com.yoon.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsyncService {

    private final EmailService emailService;

    public void asyncCall1(){
        /** 빈 주입 : 이 경우에만 각각의 스레드가 따로 운용된다. = 비동기
         * [asyncCall 1] :: http-nio-8080-exec-1
         * [sendEmail 1] :: defaultTaskExecutor-1
         * [sendEmail messagingTaskExecutor 1] :: messagingTaskExecutor-1
         * ==> 전부 다 다른 스레드가 처리
         * 스프링 컨테이터가 빈으로 등록된 @Async 를 보고 해당 빈을 한번 더 wrapping 해준다.
         * 래핑된 프록시 객체가 리턴되는 원리.
         * 그걸 subThread 에게 위임하는 것임.
         * */
        System.out.println("[asyncCall 1] :: "+ Thread.currentThread().getName() + " · ₊ ˚✿\uD80C\uDC83 ପ₍ᐢ๑• ֊ •๑ᐢ₎ଓ ⌒☆ jarry");
        emailService.sendEmail();
        emailService.sendEmailWithCustomThreadPool();
    }

    public void asyncCall2(){ /** 잘못된 비동기 프로그래밍 예시 1 _ 인스턴스 호출 = 동기. 빈이 아니기 때문에 래핑 과정 x */
        System.out.println("[asyncCall 2] :: "+ Thread.currentThread().getName());
        EmailService emailService1 = new EmailService();
        emailService1.sendEmail();
        emailService1.sendEmailWithCustomThreadPool();
    }

    public void asyncCall3(){/** 잘못된 비동기 프로그래밍 예시 2 _ 내부 메소드 호출 = 동기. 이미 해당 서비스 객체가 생성 된 이후의 내부 메소드 호출이라서. */
        System.out.println("[asyncCall 3] :: "+ Thread.currentThread().getName());
        sendEmail();
    }

    @Async
    public void sendEmail(){
        System.out.println("[sendEmail inner] :: "+ Thread.currentThread().getName());
    }
}

package com.yoon.demo.controller;

import com.yoon.demo.service.AsyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AsyncController {

    private AsyncService asyncService;

    @GetMapping("/1")
    public String asyncCall1(){
        asyncService.asyncCall1();
        return "1 success";
    }

    @GetMapping("/2")
    public String asyncCall2(){
        asyncService.asyncCall2();
        return "2 success";
    }

    @GetMapping("/3")
    public String asyncCall3(){
        asyncService.asyncCall3();
        return "3 success";
    }
}

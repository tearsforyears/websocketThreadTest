package com.fourspring.springtest.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async("pool")
    public void aynscTest(){
        System.out.println(Thread.currentThread().getName());
        // 相当于runnable接口的方法了
    }

    @Async("pool")
    public void aynscTest2(){
        System.out.println(Thread.currentThread().getName());
        // 相当于runnable接口的方法了
    }


    public void normalTest(){
        System.out.println(Thread.currentThread().getName());
        // 相当于runnable接口的方法了
    }
}

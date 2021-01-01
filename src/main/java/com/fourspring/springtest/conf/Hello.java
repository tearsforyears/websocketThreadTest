package com.fourspring.springtest.conf;

import org.springframework.stereotype.Component;


public class Hello {
    static {
        System.out.println("装载普通类成功");
    }
}
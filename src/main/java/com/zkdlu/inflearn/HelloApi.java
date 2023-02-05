package com.zkdlu.inflearn;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
class HelloApi implements ApplicationContextAware {

    private final HelloService helloService;
    private ApplicationContext applicationContext;

    public HelloApi(final HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    String hello(String name) {

        if (name == null || name.trim().length() == 0) throw new IllegalArgumentException();

        return helloService.sayHello(name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);
        this.applicationContext = applicationContext;
    }
}

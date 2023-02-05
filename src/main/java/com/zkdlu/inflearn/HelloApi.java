package com.zkdlu.inflearn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
class HelloApi {

    private final HelloService helloService;

    public HelloApi(final HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    String hello(String name) {

        if (name == null || name.trim().length() == 0) throw new IllegalArgumentException();

        return helloService.sayHello(name);
    }
}

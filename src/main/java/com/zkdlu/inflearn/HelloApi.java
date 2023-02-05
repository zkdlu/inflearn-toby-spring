package com.zkdlu.inflearn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RequestMapping
@RestController
class HelloApi {

    private final HelloService helloService;

    public HelloApi(final HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}

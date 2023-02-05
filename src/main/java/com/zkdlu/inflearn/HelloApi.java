package com.zkdlu.inflearn;

import java.util.Objects;

class HelloApi {

    private final HelloService helloService;

    public HelloApi(final HelloService helloService) {
        this.helloService = helloService;
    }

    String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}

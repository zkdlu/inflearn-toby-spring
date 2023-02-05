package com.zkdlu.inflearn;

import org.springframework.stereotype.Component;

@Component
class SimpleHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}

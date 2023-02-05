package com.zkdlu.inflearn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloApi {
    @GetMapping("/hello")
    String hello(String name) {
        return "Hello " + name;
    }
}

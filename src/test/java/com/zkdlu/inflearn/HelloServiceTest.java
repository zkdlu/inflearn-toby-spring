package com.zkdlu.inflearn;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest

{
    @Test
    void simpleHelloService() {
        HelloService sut = new SimpleHelloService();

        String result = sut.sayHello("Test");

        assertThat(result).isEqualTo("Hello Test");
    }

    @Test
    void helloDecorator() {
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String result = decorator.sayHello("Test");

        assertThat(result).isEqualTo("*Test*");
    }
}

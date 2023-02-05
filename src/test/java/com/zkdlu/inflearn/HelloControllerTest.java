package com.zkdlu.inflearn;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HelloControllerTest {

    @Test
    void helloController() {
        HelloApi sut = new HelloApi(name -> name);

        String result = sut.hello("Test");

        assertThat(result).isEqualTo("Test");
    }

    @Test
    void failsHelloController() {
        HelloApi sut = new HelloApi(name -> name);

        assertThatThrownBy(() -> sut.hello(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> sut.hello(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

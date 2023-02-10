package com.zkdlu.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {
    @Test
    void configuration() {
        Common common = new Common();
        Assertions.assertThat(common).isSameAs(common);

        MyConfig config = new MyConfig();

        Bean1 bean1 = config.bean1();
        Bean2 bean2 = config.bean2();

        Assertions.assertThat(bean1.common).isNotSameAs(bean2.common);
    }

    @Test
    void configuration_spring() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh();

        Bean1 bean1 = ac.getBean(Bean1.class);
        Bean2 bean2 = ac.getBean(Bean2.class);

        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    @Test
    void proxyCommonMethod() {
        MyConfigProxy configProxy = new MyConfigProxy();

        Bean1 bean1 = configProxy.bean1();
        Bean2 bean2 = configProxy.bean2();

        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    static class MyConfigProxy extends MyConfig {

        private Common common;

        @Override
        Common common() {
            if (this.common == null) common = super.common();

            return common;
        }
    }

    @Configuration
    static class MyConfig {
        @Bean
        Common common() {
            return new Common();
        }

        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }

        @Bean
        Bean2 bean2() {
            return new Bean2(common());
        }
    }

    static class Bean1 {
        private final Common common;

        Bean1(final Common common) {
            this.common = common;
        }
    }

    static class Bean2 {
        private final Common common;

        Bean2(final Common common) {
            this.common = common;
        }
    }

    static class Common {
    }
}

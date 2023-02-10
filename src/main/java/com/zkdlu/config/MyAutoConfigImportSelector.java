package com.zkdlu.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "com.zkdlu.config.autoconfig.DispatcherServletConfig",
                "com.zkdlu.config.autoconfig.TomcatWebServerConfig"
        };
    }
}

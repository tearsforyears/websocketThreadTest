package com.fourspring.springtest.annotation;

import com.fourspring.springtest.conf.SubTestConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({SubTestConfiguration.class})
public @interface EnableTestAutoConfiguration {
}

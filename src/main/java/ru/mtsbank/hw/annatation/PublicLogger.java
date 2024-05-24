package ru.mtsbank.hw.annatation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PublicLogger {
    String value();
    boolean entering() default false;
    boolean exiting() default false;
    String level() default "INFO";
}

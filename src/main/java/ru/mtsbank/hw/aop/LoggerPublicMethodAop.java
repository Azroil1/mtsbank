package ru.mtsbank.hw.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.mtsbank.hw.annatation.PublicLogger;

import java.lang.reflect.Method;

@Aspect
@Component
public class LoggerPublicMethodAop {

    Logger log = LoggerFactory.getLogger(LoggerPublicMethodAop.class);

    @Pointcut(value = "execution(public * *(..)) && @annotation(ru.mtsbank.hw.annatation.PublicLogger)")
    public void callPublicMethod() {}
    @Before(value = "callPublicMethod()")
    public void logBefore(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        PublicLogger publicLogger = method.getAnnotation(PublicLogger.class);
        if(publicLogger.entering()){
            log(publicLogger.level(), "Entering " + method.getName() + ". " + publicLogger.value());
        }
    }
    @After(value = "callPublicMethod()")
    public void logAfter(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        PublicLogger publicLogger = method.getAnnotation(PublicLogger.class);
        if(publicLogger.exiting()){
            log(publicLogger.level(), "Exiting " + method.getName() + ". " + publicLogger.value());
        }
    }

    private void log(String level, String message){
        switch(level.toUpperCase()){
            case "TRACE":
                log.trace(message);
                break;
            case "DEBUG":
                log.debug(message);
                break;
            case "WARN":
                log.warn(message);
                break;
            case "ERROR":
                log.error(message);
                break;
            default:
                log.info(message);
        }
    }
}

package com.gcu.util;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import com.gcu.util.Tracer; // Add explicit import for Tracer

@Configuration
@EnableAspectJAutoProxy
public class AopConfiguration {

    @Pointcut("execution(* com.gcu.controller..*(..)) || " +
              "execution(* com.gcu.business..*(..)) || " +
              "execution(* com.gcu.data..*(..))")
    public void monitor() {}

    @Bean
    public Tracer tracer() {
        return new Tracer(true);
    }

    @Bean
    public Advisor performanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("com.gcu.util.AopConfiguration.monitor()");
        return new DefaultPointcutAdvisor(pointcut, tracer());
    }
}

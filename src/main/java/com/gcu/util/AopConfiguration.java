package com.gcu.util;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfiguration {

    @Bean
    public Tracer tracer() {
        return new Tracer(true);
    }

    @Bean
    public Advisor performanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        // Use the pointcut expression directly instead of referencing the method
        pointcut.setExpression("execution(* com.gcu.controller..*(..)) || " +
                             "execution(* com.gcu.business..*(..)) || " +
                             "execution(* com.gcu.data..*(..))");
        return new DefaultPointcutAdvisor(pointcut, tracer());
    }
}

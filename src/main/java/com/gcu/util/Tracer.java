package com.gcu.util;

import java.util.Date;

import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AbstractMonitoringInterceptor;

public class Tracer extends AbstractMonitoringInterceptor {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(Tracer.class);

    public Tracer() {}

    public Tracer(boolean useDynamicLogger) {
        setUseDynamicLogger(useDynamicLogger);
    }

    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, org.apache.commons.logging.Log commonLog) throws Throwable {
        String name = createInvocationTraceName(invocation);
        long start = System.currentTimeMillis();
        logger.trace("GCU Method " + name + " execution started at: " + new Date());
        try {
            return invocation.proceed();
        } finally {
            long end = System.currentTimeMillis();
            long time = end - start;
            logger.trace("GCU Method " + name + " execution lasted: " + time + " ms");
            logger.trace("GCU Method " + name + " execution ended at: " + new Date());
            if (time > 10) {
                logger.warn("GCU Method execution longer than 10 ms!");
            }
        }
    }
}
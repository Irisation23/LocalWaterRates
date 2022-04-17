package com.nhnacademy.localwaterrates.aspect;

import com.nhnacademy.localwaterrates.repository.NormalBillRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggerAspect {
    private static final Log log = LogFactory.getLog(LoggerAspect.class);

    @Around("execution(* com.nhnacademy.localwaterrates.*.*.*(..))")
    public Object timeCheck(ProceedingJoinPoint pjp) throws Throwable{
        StopWatch stopWatch = new StopWatch(pjp.getSignature().getName());
        try{
            stopWatch.start(pjp.getSignature().getName());
            return pjp.proceed();
        }finally {
            stopWatch.stop();
            log.info("\n" + stopWatch.prettyPrint());
        }
    }

    @Before("execution(* com.nhnacademy.localwaterrates.repository.NormalBillRepository.findAllBills())")
    public void loadError(){
        try{
            NormalBillRepository.isFileLoaded();
        }catch (IllegalStateException e){
            throw new IllegalStateException();
        }
    }
}
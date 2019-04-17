package com.reptilesysem.system.core.util.log.aop;

import com.reptilesysem.system.core.util.log.service.ISearchHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;


@Slf4j
@Component
@Aspect
public class HistoryAspect {

    @Autowired
    private ISearchHistoryService searchHistoryService;

    @Pointcut("@annotation(com.reptilesysem.system.core.util.log.annotion.HistoryLog)")
    public void logPoint(){

    }

    @AfterReturning(pointcut = "logPoint()", returning = "returnVal")
    public Object log(JoinPoint joinPoint, Object returnVal){
//        Class<?> clazz = joinPoint.getSignature().getDeclaringType();
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        Class[] classes = new Class[args.length];
//        for (int i = 0; i < args.length; i++){
//            classes[i] = args[i].getClass();
//        }
//        try {
//            Method method = clazz.getDeclaredMethod(methodName, classes);
//            if (method.getAnnotation(GetMapping.class) != null){
//
//            }else if (method.getAnnotation(PostMapping.class) != null){
//                System.out.println("post");
//            }else if (method.getAnnotation(RequestMapping.class) != null){
//                System.out.println("requestMapping");
//            }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
        searchHistoryService.logHistory(joinPoint);
        return returnVal;
    }

}

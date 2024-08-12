package com.yupi.yuapiinterface.aop;

import com.yupi.yuapicommon.service.InnerUserInterfaceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 调用次数统计切面
 */
//@RestControllerAdvice
@Aspect
@Component
@Slf4j
public class InvokeCountAOP {

    @DubboReference
    private InnerUserInterfaceInfoService userInterfaceInfoService;

    /**
     * 执行拦截
     */
    @Around("execution(* com.yupi.yuapiinterface.controller.*.*(..))")
    public Object doInterceptor(ProceedingJoinPoint point) throws Throwable {
        System.out.println("判断调用次数");

        // 执行原方法
        Object result = point.proceed();

        // 执行后
//        userInterfaceInfoService.invokeCount();
        return result;
    }


//    @Resource
//    private UserInterfaceInfoService userInterfaceInfoService;

    // 伪代码
    // 定义切面触发的时机（什么时候执行方法）controller 接口的方法执行成功后，执行下述方法
//    public void doInvokeCount() {
//        // 调用方法
//        object.proceed();
//        // 调用成功后，次数 + 1
//        userInterfaceInfoService.invokeCount();
//    }
}

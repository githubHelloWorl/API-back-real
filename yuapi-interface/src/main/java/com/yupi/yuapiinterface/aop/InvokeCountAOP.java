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
    private InnerUserInterfaceInfoService interfaceInfoService;

    /**
     * 执行拦截
     */
    @Around("execution(* com.yupi.yuapiinterface.controller.*.*(..))")
    public Object doInterceptor(ProceedingJoinPoint point) throws Throwable {
        // 计时
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
        // 获取请求路径
//        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
//        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
//
//        HttpServletRequest request = httpServletRequest;
//
//        // 生成请求唯一 id
//        String requestId = UUID.randomUUID().toString();
//        String url = httpServletRequest.getRequestURI();
//        // 获取请求参数
//        Object[] args = point.getArgs();
//        String reqParam = "[" + StringUtils.join(args, ", ") + "]";
//        // 输出请求日志
//        log.info("request start，id: {}, path: {}, ip: {}, params: {}", requestId, url,
//                httpServletRequest.getRemoteHost(), reqParam);

        System.out.println("判断调用次数");
        // todo 执行前 - 是否还有调用次数
//        interfaceInfoService.invokeCount();

        // 执行原方法
        Object result = point.proceed();

        // 执行后


        // 输出响应日志
//        stopWatch.stop();
//        long totalTimeMillis = stopWatch.getTotalTimeMillis();
//        log.info("request end, id: {}, cost: {}ms", requestId, totalTimeMillis);
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

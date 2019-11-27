package com.yjjk.erp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yjjk.erp.constant.ErrorCodeEnum;
import com.yjjk.erp.service.ManagerService;
import com.yjjk.erp.utility.ResultUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class WeblogAspect
{
    static final Logger logger = LoggerFactory.getLogger(WeblogAspect.class);
    
    @Autowired
    protected ManagerService managerService;

    @Pointcut("execution(public * com.yjjk.erp.controller.*.*(..))")
    private void controllerAspect() {}

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint)
    {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        logger.info("[ip:{}] [url:{}] [method:({}) {}]", new Object[] { request.getRemoteAddr(), request.getRequestURI(), request
                .getMethod(), joinPoint.getSignature() });
        logger.info("args: " + Arrays.toString(joinPoint.getArgs()));
    }

//    @Around("controllerAspect()")
//    public synchronized Object loginCheck(ProceedingJoinPoint joinPoint)
//            throws Throwable
//    {
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = requestAttributes.getRequest();
//        String token = request.getParameter("token");
//        Signature signature = joinPoint.getSignature();
//        if ((!signature.getName().equals("loginManager")) && (!signature.getName().equals("outManager")))
//        {
//            if (token == null)
//            {
//                logger.error("登录失败  token为空");
//                return ResultUtil.returnError(ErrorCodeEnum.TOKEN_ERROR);
//            }
//            boolean check = this.managerService.checkToken(token, request.getRemoteAddr());
//            if (!check)
//            {
//                logger.error("登录失败  token = " + token);
//                return ResultUtil.returnError(ErrorCodeEnum.TOKEN_ERROR);
//            }
//        }
//        return joinPoint.proceed();
//    }
}

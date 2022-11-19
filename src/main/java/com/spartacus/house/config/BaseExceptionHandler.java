package com.spartacus.house.config;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.spartacus.house.exception.ServiceException;
import com.spartacus.house.result.GlobalResult;
import com.spartacus.house.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 *
 * @author ronger
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);

    @SuppressWarnings("Duplicates")
    @ExceptionHandler(Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println(isAjax(request));
        if (isAjax(request)) {
            GlobalResult<ResultCode> result = new GlobalResult<>();
            if (ex instanceof ServiceException) {
                //业务失败的异常，如“账号或密码错误”
                result.setCode(((ServiceException) ex).getCode());
                result.setMessage(ex.getMessage());
                logger.info(ex.getMessage());
            } else if (ex instanceof NoHandlerFoundException) {
                result.setCode(ResultCode.NOT_FOUND.getCode());
                result.setMessage(ResultCode.NOT_FOUND.getMessage());
            } else if (ex instanceof ServletException) {
                result.setCode(ResultCode.FAIL.getCode());
                result.setMessage(ex.getMessage());
            } else {
                //系统内部异常,不返回给客户端,内部记录错误日志
                result = new GlobalResult<>(ResultCode.INTERNAL_SERVER_ERROR);
                String message;
                if (handler instanceof HandlerMethod) {
                    HandlerMethod handlerMethod = (HandlerMethod) handler;
                    message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                            request.getRequestURI(),
                            handlerMethod.getBean().getClass().getName(),
                            handlerMethod.getMethod().getName(),
                            ex.getMessage());
                } else {
                    message = ex.getMessage();
                }
                logger.error(message, ex);
            }
            result.setSuccess(false);
            return result;
        } else {
                ModelAndView mv = new ModelAndView();
    ////            mv.setView(view);
                return mv;
        }
    }

    private boolean isAjax(HttpServletRequest request) {
        return true;
//        String requestedWith = request.getHeader("x-requested-with");
//        if (requestedWith != null && "XMLHttpRequest".equalsIgnoreCase(requestedWith)) {
//            return true;
//        }
//        String contentType = request.getContentType();
//        return StringUtils.isNotBlank(contentType) && contentType.contains("application/json");
    }
}

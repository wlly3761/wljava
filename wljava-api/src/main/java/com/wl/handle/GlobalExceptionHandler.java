package com.wl.handle;

import com.wl.beans.RespInfo;
import com.wl.exception.BusinessException;
import com.wl.exception.WLException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(WLException.class)
    public RespInfo<String> authExceptionHandler(HttpServletRequest request, WLException exception) {
        if (exception instanceof BusinessException){
            logger.error("request:" + request.getRequestURI());
            logger.error("exception:", exception);
            String message = exception.getMessage();
            return RespInfo.error(message);
        }
        logger.error("request:" + request.getRequestURI());
        logger.error("exception:", exception);
        String message = exception.getMessage();
        return RespInfo.error(message);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public RespInfo<String> allExceptionHandler(HttpServletRequest request, Exception exception) {
        logger.error("request:" + request.getRequestURI());
        logger.error("exception:", exception);
        String message = exception.getMessage();
        return RespInfo.error(message);
    }

}

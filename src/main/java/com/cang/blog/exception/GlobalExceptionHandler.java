package com.cang.blog.exception;

import com.cang.blog.bean.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 *
 * @author cang
 * @date 2017-10-08
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理应用自定义的异常
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(AppBaseException.class)
    @ResponseBody
    public ResultBean<?> handleAppBaseException(HttpServletRequest request, AppBaseException ex) {

        logger.info("AppBaseException Occured:: URL=" + request.getRequestURL());
        ex.printStackTrace();
        logger.error(ex.toString());

        ResultBean resultBean = new ResultBean();

        resultBean.setCode(ex.getCode());
        resultBean.setMsg(ex.getMessage());

        return resultBean;
    }

    /**
     * 处理其他异常
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean<?> handleOtherException(HttpServletRequest request, Exception ex) {

        logger.info("AppBaseException Occured:: URL=" + request.getRequestURL());
        ex.printStackTrace();
        logger.error(ex.toString());

        ResultBean resultBean = new ResultBean();
        resultBean.setCode(400);
        resultBean.setMsg(ex.getMessage());

        return resultBean;
    }
}

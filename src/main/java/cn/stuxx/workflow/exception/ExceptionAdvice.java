package cn.stuxx.workflow.exception;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 包名: com.nucxiao.emos.wx.config
 * 类名: ExceptionAdvice
 * 创建用户: 25789
 * 创建日期: 2022年01月26日 19:36
 * 项目名: emos-wx-api
 *
 * @author: 秦笑笑
 **/
@Api(tags = "通用异常处理")
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e){
        log.error("执行异常",e);
        if(e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exception= (MethodArgumentNotValidException) e;
            return exception.getBindingResult().getFieldError().getDefaultMessage();
        }
        else if(e instanceof EmosException){
            EmosException exception= (EmosException) e;
            return exception.getMsg();
        }
        // else if(e instanceof UnauthorizedException){
        //     return "你不具备相关权限";
        // }
        else{
            return "后端执行异常";
        }
    }
}
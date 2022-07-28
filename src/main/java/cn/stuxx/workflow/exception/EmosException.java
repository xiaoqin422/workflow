package cn.stuxx.workflow.exception;

import lombok.Data;

/**
 * 包名: com.nucxiao.emos.wx.exception
 * 类名: EmosException
 * 创建用户: 25789
 * 创建日期: 2022年01月19日 14:34
 * 项目名: emos-wx-api
 *
 * @author: 秦笑笑
 **/
@Data
public class EmosException extends RuntimeException{
    private static final long serialVersionUID = 2620987455230241828L;
    private String msg;
    private int code = 500;
    public EmosException(String msg){
        super(msg);
        this.msg = msg;
    }
    public EmosException(String msg, int code){
        super(msg);
        this.msg = msg;
        this.code = code;
    }
    public EmosException(String msg, Throwable e){
        super(msg,e);
        this.msg = msg;
    }
    public EmosException(String msg, int code, Throwable e){
        super(msg,e);
        this.msg = msg;
        this.code = code;
    }
}
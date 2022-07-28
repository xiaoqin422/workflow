package cn.stuxx.workflow.util;

import cn.hutool.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 包名: com.nucxiao.emos.wx.util
 * 类名: R
 * 创建用户: 25789
 * 创建日期: 2022年01月18日 17:49
 * 项目名: emos-wx-api
 *
 * @author: 秦笑笑
 **/
public class R extends HashMap<String,Object> {
    public R(){
        put("code", HttpStatus.HTTP_OK);
        put("msg","success");
    }
    public R put(String key,Object value){
        super.put(key,value);
        return this;
    }
    public static R ok(){
        return new R();
    }
    public static R ok(String msg){
        R r = new R();
        r.put("msg",msg);
        return r;
    }
    public static R ok(Map<String,Object> map){
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R error(int code, String msg){
        R r = new R();
        r.put("code",code);
        r.put("msg",msg);
        return r;
    }

    public static R error(String msg){
        return error(HttpStatus.HTTP_INTERNAL_ERROR,msg);
    }

    public static R error(){
        return error(HttpStatus.HTTP_INTERNAL_ERROR,"未知异常，请联系管理员");
    }
}
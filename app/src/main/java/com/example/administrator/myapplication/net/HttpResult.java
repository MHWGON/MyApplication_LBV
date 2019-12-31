package com.example.administrator.myapplication.net;

/**
 * Created by 梁俊廷 on 2019/12/26.
 */
//要点一 定义为泛型类
public class HttpResult<T> {
    private int code;
    private String message;
    private T data;

    public HttpResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

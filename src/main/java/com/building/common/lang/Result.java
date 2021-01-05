package com.building.common.lang;

public class Result {

    public static Integer SUCCESS_CODE = 200;
    public static Integer ERROR_CODE = 500;
    public Integer status = SUCCESS_CODE;
    public String msg = "操作成功";
    public Object data = null;

    //失败响应状态
    public static Result fail(Integer status,String msg) {
        return new Result(status,msg,null);
    }//三个参数
    public static Result fail(String msg){
        return new Result(ERROR_CODE,msg,null);
    }//一个参数
    public static Result fail(){
        return new Result(ERROR_CODE,"操作失败");
    }//没有参数

    //成功响应状态
    public static Result success(Integer status,String msg, Object data) {
        return new Result(status,msg,data);
    }//三个参数
    public static Result success(String msg, Object data) {
        return new Result(msg,data);
    }//两个参数
    public static Result success(Object data){
        return new Result(data);
    }//一个参数
    public static Result success(){
        return new Result();
    }//没有参数

    public Result(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }//三个参数构造
    public Result(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }//两个参数构造
    public Result(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }//两个参数构造
    public Result(Object data) {
        this.data = data;
    }//一个参数构造
    public Result() {
    }//空构造


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

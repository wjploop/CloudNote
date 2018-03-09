package com.loop.util;

import java.io.Serializable;

/**
 * author  loop
 * create  2018-01-22 20:58.
 */


public class NoteResult<T> implements Serializable {

    private static final long serialVersionUID = 812376774103405857L;

    private int state;  //0 success, other represent failed
    private T data;
    private String msg;


    public static final int SUCCESS=0;
    public static final int ERROR = 1;

    public NoteResult() {

    }

    public NoteResult(int state, Throwable e) {
        this.state=state;
        data=null;
        msg = e.getMessage();
    }

    public NoteResult(T data) {
        this.state = NoteResult.SUCCESS;
        this.data = data;
        msg = "";
    }

    public NoteResult(int state, T data, String msg) {
        this.state = state;
        this.data = data;
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "NoteResult{" +
                "state=" + state +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}

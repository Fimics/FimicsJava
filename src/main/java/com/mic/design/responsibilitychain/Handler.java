package com.mic.design.responsibilitychain;

/**
 * Created by lipengju on 2018/5/27.
 */
public abstract class Handler {

    private Handler nextHandler;

    //当前领导审批通过的最多天数
    public int maxDay;

    public Handler(int maxDay) {
        this.maxDay = maxDay;
    }


    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected void handleRequest(int day){
        if(day<=maxDay){
            replay(day);
        }else{
            if(nextHandler!=null){
                //审批权限不够，继续上报
               nextHandler.handleRequest(day);
            }else {
                System.out.println("没有更高的领导审批...");
            }
        }
    }

    protected abstract void replay(int day);
}

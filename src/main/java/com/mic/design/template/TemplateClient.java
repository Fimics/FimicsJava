package com.mic.design.template;

/**
 * Created by lipengju on 2018/5/26.
 * 模板方法
 */
public class TemplateClient {

    public static void main(String args[]){

        BossWork bossWork = new BossWork();
        bossWork.newDay();
        System.out.println("----------------------");
        StaffWork staffWork = new StaffWork();
        staffWork.newDay();

    }
}

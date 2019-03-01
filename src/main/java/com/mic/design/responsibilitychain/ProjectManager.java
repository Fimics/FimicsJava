package com.mic.design.responsibilitychain;

/**
 * Created by lipengju on 2018/5/27.
 */
public class ProjectManager extends Handler {


    public ProjectManager(int maxDay) {
        super(maxDay);
    }

    @Override
    protected void replay(int day) {
        System.out.println("项目经理处理...");
    }
}

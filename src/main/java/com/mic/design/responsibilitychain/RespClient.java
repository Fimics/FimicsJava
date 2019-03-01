package com.mic.design.responsibilitychain;

/**
 * Created by lipengju on 2018/5/27.
 */
public class RespClient {

    public static void main(String args []){
        ProjectManager projectManager = new ProjectManager(3);
        Handler bossHandler = new Boss(50);
        projectManager.setNextHandler(bossHandler);
        projectManager.handleRequest(20);
    }
}

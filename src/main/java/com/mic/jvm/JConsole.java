package com.mic.jvm;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class JConsole {

    public static void main(String args){

        ScheduledService scheduledService =new ScheduledService() {
            @Override
            protected Task createTask() {
                return null;
            }
        };
    }
}

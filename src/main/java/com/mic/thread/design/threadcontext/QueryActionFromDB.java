package com.mic.thread.design.threadcontext;

public class QueryActionFromDB {

    public void execute() {
        String name = "db";

        ActionContext.getActionContext().getContext().setName(name);
    }
}

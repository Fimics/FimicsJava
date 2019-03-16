package com.mic.thread.design.threadcontext;

public class ExecutionTask implements Runnable {

    private QueryActionFromDB queryAction = new QueryActionFromDB();
    private QueryActionFromHttp queryActionFromHttp = new QueryActionFromHttp();

    @Override
    public void run() {

        queryAction.execute();
        queryActionFromHttp.execute();

        Context context = ActionContext.getActionContext().getContext();
        System.out.println("threadName-> "+Thread.currentThread().getName()+"  name :"+context.getName()+"-- cardid--> "+context.getCardId());
    }
}

package com.mic.thread.design.threadcontext;

public class QueryActionFromHttp {


    public void execute() {

        String name =ActionContext.getActionContext().getContext().getName();
        String cartId = getCaerId(name);

        ActionContext.getActionContext().getContext().setCardId(cartId);
    }

    private String getCaerId(String name){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "1214214";
    }

}

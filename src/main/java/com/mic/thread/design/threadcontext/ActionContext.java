package com.mic.thread.design.threadcontext;

public class ActionContext {

    private static final ThreadLocal<Context> threadlocal = new ThreadLocal<Context>(){
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    private static class ContextHolder{
        private  static final ActionContext actionContext = new ActionContext();
    }

    public static ActionContext getActionContext(){
        return ContextHolder.actionContext;
    }

    public Context getContext(){
        return threadlocal.get();
    }
}

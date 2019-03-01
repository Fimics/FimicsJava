package com.mic.design.strategry;

/**
 * Created by lipengju on 2018/5/26.
 * 侧略模式
 */
public class StrategyClient {

    private IStrategy strategy;

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }


    public int calclatePrice(int km){
        return  strategy.calclterPrice(km);
    }

    public static void main(String args []){
        StrategyClient context = new StrategyClient();
        context.setStrategy(new TaxiStrategy());
        System.out.println(context.calclatePrice(5));
    }
}

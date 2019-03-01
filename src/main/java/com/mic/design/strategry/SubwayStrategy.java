package com.mic.design.strategry;

/**
 * Created by lipengju on 2018/5/26.
 */
public class SubwayStrategy implements IStrategy {

    public int calclterPrice(int km) {
        return (int) (0.2*km);
    }
}

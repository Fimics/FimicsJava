package com.mic.design.strategry;

/**
 * Created by lipengju on 2018/5/26.
 */
public class TaxiStrategy implements IStrategy {

    public int calclterPrice(int km) {
        return 2*km;
    }
}

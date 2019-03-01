package com.mic.design.observer;

/**
 * 创 建 人: lipengju
 * 创建日期: 2018/4/12 17:23
 * 文件描述：
 */


public interface Observerable {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notfiyOberver();
}

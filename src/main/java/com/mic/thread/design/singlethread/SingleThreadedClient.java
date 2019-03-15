package com.mic.thread.design.singlethread;

import java.util.Arrays;
import java.util.List;

public class SingleThreadedClient {

    public static void main(String[] args) {
        Gate gate = new Gate();

        User bj = new User("Baobao","Beijin",gate);
        User sh = new User("ShanglLao","ShangHai",gate);
        User gz = new User("GuangLao","GuangZhou",gate);

        List<User> users = Arrays.asList(bj,sh,gz);
        users.forEach(User::start);
    }
}

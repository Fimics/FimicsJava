package com.mic.thread.design.readwritelock;

import java.util.Arrays;
import java.util.List;

public class TestClient {

    public static void main(String[] args) {

        final ShareData shareData = new ShareData(10);

        List<String> list = Arrays.asList("r-0","r-1","w-0","w-1");

        list.stream().map(item->{
            String str []=item.split("-");
            if(str[0].equalsIgnoreCase("w")){
                return new WriteTask(shareData,"hjhfjkajhfdkjahfdkajfkdjafh");
            }else {
                return  new ReadTask(shareData);
            }
        }).forEach(thread -> thread.start());

    }
}

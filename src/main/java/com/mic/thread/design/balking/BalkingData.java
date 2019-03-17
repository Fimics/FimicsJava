package com.mic.thread.design.balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

@SuppressWarnings("unused")
public class BalkingData {

    private final String fileNma;
    private String content;
    private boolean changed;

    public BalkingData(String fileNma, boolean changed) {
        this.fileNma = fileNma;
        this.changed = changed;
    }


    public synchronized void change(String newContent){
        this.changed=true;
        this.content = newContent;
    }

    public synchronized void save(){
        if(!changed){
            return;
        }
        doSave();
        this.changed = false;
    }

    private void doSave() {
        System.out.println(Thread.currentThread().getName()+" calls do save content ="+content);

        try {
            Writer writer = new FileWriter(fileNma,true);
            writer.write(content);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

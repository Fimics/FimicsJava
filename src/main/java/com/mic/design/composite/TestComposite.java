package com.mic.design.composite;

/**
 * Created by lipengju on 2018/5/26.
 */
public class TestComposite {

    public static void main(String args[]){
        TextFile textFileA = new TextFile("a.txt");
        TextFile textFileB = new TextFile("b.txt");
        TextFile textFileC = new TextFile("c.txt");

        textFileA.watch();

        Folder folder = new Folder("design");
        folder.add(textFileA);
        folder.add(textFileB);
        folder.add(textFileC);

        folder.watch();
        folder.getChild(2).watch();
    }
}

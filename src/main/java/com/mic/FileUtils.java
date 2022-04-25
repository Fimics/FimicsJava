package com.mic;


import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FileUtils {

    public static void main(String[] args) {
       String path ="/Users/lipengju/desktop/kotlin/";

       ArrayList list = new ArrayList();
        bfsListFile(path,list);
       list.forEach(System.out::println);
    }

    /**
     * 深度搜索遍历文件夹
     */
    public static void dfsListFile(String dirPath, List<String> list) {
        File file = new File(dirPath);
        File[] files = file.listFiles();
        for (File tmpFile : files) {
            if (tmpFile.isDirectory()) {
                dfsListFile(tmpFile.getAbsolutePath(), list);
            } else {
                list.add(tmpFile.getAbsolutePath());
            }
        }
    }

    /**
     * 广度搜索遍历文件夹
     */
    public static void bfsListFile(String dirPath, List<String> list) {
        File file = new File(dirPath);
        File[] fs = file.listFiles();
        Queue<File> queue = new LinkedList<>();

        // 遍历第一层
        for (File f : fs) {
            // 把第一层文件夹加入队列
            if (f.isDirectory())
                queue.offer(f);
            else
                list.add(f.getAbsolutePath());
        }
        // 逐层搜索下去
        while (!queue.isEmpty()) {
            // 从队列头取一个元素
            File fileTemp = queue.poll();
            File[] fileListTemp = fileTemp.listFiles();
            for (File f : fileListTemp) {
                if (f.isDirectory())
                    queue.offer(f);
                else
                    list.add(f.getAbsolutePath());
            }
        }

    }
}

package com.mic.anno;

import java.lang.reflect.Method;

public class AnnoClient {

    public static void main(String[] args) {
        AnnoClient client = new AnnoClient();
        client.test();
    }

    @AnnoTest(id = "123456")
    private void test() {
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(AnnoTest.class)) {
                System.out.println("获取到注解");
                AnnoTest anno = method.getAnnotation(AnnoTest.class);
                String id = anno.id();
                System.out.println("id=" + id);
            }
        }
    }
}


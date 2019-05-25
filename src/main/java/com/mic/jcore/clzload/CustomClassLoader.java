package com.mic.jcore.clzload;

import java.io.*;

@SuppressWarnings("unused")
public class CustomClassLoader extends ClassLoader {

    private static final String DEFAULT_DIR = "/Users/lipengju/code/java/FimicsJava/clazz/";
    private String dir = DEFAULT_DIR;
    private String name;
    protected CustomClassLoader parent;

    public CustomClassLoader() {
        super();
    }

    public CustomClassLoader(String name) {
        super();
        this.name = name;
    }

    public CustomClassLoader(String name, ClassLoader parent) {
        super(parent);
        this.parent = (CustomClassLoader) parent;
        this.name = name;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        if (parent != null) {
            return parent.findClass(name);
        }

        String path = name.replace(".", "/");
        File file = new File(dir, path + ".class");
        if (!file.exists()) {
            throw new ClassNotFoundException("the class " + name + " not found");
        }

        byte bytes[] = loadClassBytes(file);
        if (null == bytes || bytes.length == 0) {
            throw new ClassNotFoundException("load the class " + name + "failed");
        }

        return defineClass(name, bytes, 0, bytes.length);
    }


    private byte[] loadClassBytes(File file) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            FileInputStream in = new FileInputStream(file);

            byte buffer[] = new byte[1024];
            int len = 0;

            while ((len = in.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

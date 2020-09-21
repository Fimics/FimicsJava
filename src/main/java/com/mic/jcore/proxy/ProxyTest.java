package com.mic.jcore.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        Person person = new Student();
        Person studentProxy = (Person) new StudentProxy(person).getStudentProxy();
        studentProxy.eat();

    }
}

interface Person{
    void eat();
}

class Student implements Person{
    @Override
    public void eat() {
        System.out.println("AImpl -->a");
    }
}

class StudentProxy implements InvocationHandler{
    private Object realObject;
    public StudentProxy(Object object) {
        this.realObject = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("----------before--");
            Object obj =method.invoke(realObject,args);
            System.out.println("----------after--");
        return obj;
    }

    /**
     *
     loader:  一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载 主要用来加载类的元数据，通过反射创建代理类
     interfaces:  一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
     h:  一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
     * @return
     */
    public  Object getStudentProxy(){
        return  Proxy.newProxyInstance(realObject.getClass().getClassLoader(),
                realObject.getClass().getInterfaces(),this);
    }
}
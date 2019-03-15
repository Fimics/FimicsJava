package com.mic.thread.design.singlethread;

/**
 * gate-->叫共享资源，临界值
 * Single Threaded Execution design pattern
 * 意思为: 有一个一次只能通过一个人，每个人通过这个门时，会记录，姓名，来自哪里，第几个通过的
 * 这个例子几乎都是串行化的，怎么用读写锁分离出来？
 */
public class Gate {
    private int counter =0;
    private String name ="Nobody";
    private String address="NoWhere";



    public void pass(String name,String address){
        this.counter++;
        this.name=name;
        this.address=address;
        verify();
    }

    private void verify(){
        if(this.name.charAt(0)!=this.address.charAt(0)){
            System.out.println("**********BROKEN******"+toString());
        }
    }

    @Override
    public String toString() {
        return "Gate{" +
                "counter=" + counter +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

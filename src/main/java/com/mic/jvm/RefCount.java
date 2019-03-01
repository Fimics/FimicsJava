package com.mic.jvm;

/**
 * 引用计数回收算法
 */
public class RefCount {

    private RefCount refCount;

    public void setRefCount(RefCount refCount) {
        this.refCount = refCount;
    }

    public RefCount() {
        byte [] m = new byte[20*1024*1024];
    }

    public  static void main(String args []){

        RefCount refCount1 = new RefCount();
        RefCount refCount2 = new RefCount();
        refCount1.setRefCount(refCount2);
        refCount2.setRefCount(refCount1);
        refCount1.setRefCount(null);
        refCount2.setRefCount(null);
        System.gc();


    }

}

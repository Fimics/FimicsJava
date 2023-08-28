package com.mic.generics;


import java.util.Arrays;
import java.util.List;

// bounded type parameters 限定类型参数
//有时你可能想限制可以在参数化类型中用作类型参数的类型。
// 例如，对数字进行操作的方法可能只希望 接受 Number 或其子类的实例。这就是限定类型参数的用途。
public class K5_BoundedType {

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
//        integerBox.set(new Integer(10));
        integerBox.inspect(10);
//        integerBox.inspect("hello");
        List<Double> ld = Arrays.asList(1.2,2.3);
        List<Integer> li = Arrays.asList(2,3);
        System.out.println("sumOfList-- ld>"+Box.sumOfList(ld));
        System.out.println("sumOfList-- li>"+Box.sumOfList(li));
    }

    private static class Box<T>{
        private T t;

        public T get() {
            return t;
        }

        public void set(T t) {
            this.t = t;
        }

        //extends
        public <U extends Number> void inspect(U u){
           System.out.println("T: "+t.getClass().getName());
           System.out.println("U: "+u.getClass().getName());
        }

        /**
         * 限定类型参数是实现通用算法的关键，以下方法计算T{} 中大于指定元素elem的数据量
         * @param array
         * @param elem
         * @param <T>
         * @return
         */
        public static <T extends Comparable> int count(T[] array,T elem){
            int count = 0;
            for (T t:array){
                if(t.compareTo(elem)>0){
                    ++count;
                }
            }
            return count;
        }

        /**
         * 使用上限通配符来放宽对变量的限制,<? extends Number>
         * @param list
         * @return
         */
        public static double sumOfList(List<? extends  Number> list){
            double s = 0.0;
            for (Number n:list){
                s+=n.doubleValue();
            }
            return s;
        }

        /**
         * 无界通配符
         * @param list
         */
        public static void printList(List<?> list){
            for (Object o:list){
                System.out.println(o+"");
            }
        }
    }
}

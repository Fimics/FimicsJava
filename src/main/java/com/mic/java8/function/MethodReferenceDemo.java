package com.mic.java8.function;

import com.mic.java8.bean.Person;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("java","python","android","ios","javaScript","kotlin",
                "c","c++","lisp","ruby","swfit","groovy");

        //list.forEach(e-> System.out.println(e));

        //可以把方法引用看作一个 “函数指针”指向--> System.out.println(e)
        //list.forEach(System.out::println);

        Person p1 = new Person("java", 20);
        Person p2 = new Person("c", 60);
        Person p3 = new Person("kotlin", 10);

        List<Person> personList = Arrays.asList(p1,p2,p3);
        System.out.println(personList);

        //调用Person静态方法，就地排序，不创建新的集合 使用lambda表达式排序
        //personList.sort((p11,p22)->kotlin.test.Person.compareByAge(p11,p22));
        //System.out.println(personList);


        //1.方法引用，完全等价于上面的lambda形式
        //personList.sort(kotlin.test.Person::compareByAge);
        //System.out.println(personList);

        //2.实例方法引用
        /*BeanHelper helper = new BeanHelper();
        personList.sort((p11,p22)->helper.comparePersonByName(p11,p22));
        System.out.println(personList);

        personList.sort(helper::comparePersonByName);
        System.out.println(personList);*/

        //3.类名::实例方法名 第一个person调用compareByName()-->p1.compare(p2)
        /*personList.sort(kotlin.test.Person::compareByName);
        System.out.println(personList);
        Collections.sort(list,String::compareToIgnoreCase);
        System.out.println(list);
        */

        //4.ClassName::new
    }
}

package com.mic.annotation

//Target 描述该注解用在哪？ 类上？方法上
@Target(AnnotationTarget.CLASS,
        AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER,
        AnnotationTarget.EXPRESSION,
        AnnotationTarget.CONSTRUCTOR,
        AnnotationTarget.PROPERTY_SETTER,
        AnnotationTarget.FIELD,
        AnnotationTarget.PROPERTY_GETTER)

//
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class MyAnnotation



@MyAnnotation
class MyClass {

    @MyAnnotation
    fun myMethod(@MyAnnotation a: Int): Int {
        return (@MyAnnotation 10)
    }
}

//给构造方法增加注解
class MyClass2 @MyAnnotation constructor(a: Int) {

}

//给set方法增加注解
class MyClass3 {
    var a: Int? = null
        @MyAnnotation set
}
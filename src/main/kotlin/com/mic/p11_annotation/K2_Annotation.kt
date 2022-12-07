package com.mic.p11_annotation

//Target 描述该注解用在哪？ 类上？方法上  kotlin   //java
@Target(AnnotationTarget.CLASS,  // TYPE 作用于类
        AnnotationTarget.ANNOTATION_CLASS, // ANNOTATION_TYPE  作用于注解本身(元注解)
        AnnotationTarget.TYPE_PARAMETER, //TYPE_PARAMETER 作用于类型参数
        AnnotationTarget.PROPERTY, // NA 作用于属性
        AnnotationTarget.FIELD,    // FILED 作用于字段，(属性通常包含字段 Getter 以及Setter)
        AnnotationTarget.LOCAL_VARIABLE, // 作用于局部变量
        AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER, // NA 作用于val 参数
        AnnotationTarget.EXPRESSION,
        AnnotationTarget.CONSTRUCTOR,
        AnnotationTarget.PROPERTY_SETTER,
        AnnotationTarget.PROPERTY_GETTER)

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
class MyClass2 @MyAnnotation constructor(a: Int) {}

//给set方法增加注解
class MyClass3 {
    var a: Int? = null
        @MyAnnotation set
}
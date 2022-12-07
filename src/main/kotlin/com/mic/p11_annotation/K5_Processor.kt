package com.mic.p11_annotation

import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.ElementKind
import javax.lang.model.element.TypeElement
import kotlin.reflect.full.memberProperties

annotation class MapperAnnotation
/**
 * 注解处理器的使用方法也和Java一样：1）添加注解处理器信息。这需要在classpath里包含METAINFO/services/javax.annotation.processing.Processor文件，
 * 并将注解处理器包名和类名写入该文件。2）使用kapt插件。如果是gradle工程可以通过applyplugin：'kotlinkapt'添加注解处理器支持。kapt也支持生成Kotlin代码。
 * 如上述例子中，我们可以将genMapperClass中的代码替换为Kotlin代码，并且将其存储在processingEnv.options["kapt.kotlin.generated"]目录中。
 */

class MapperProcessor : AbstractProcessor() {

    private fun getMapperClass(pkg: String, clazzName: String, props: List<String>): String {
        return """
            package$pkg;
            import java.util.*;
            public class${clazzName}Mapper {
                public Map<String,Object> toMap($clazzName a){
                   Map<String,Object> m= new HashMap<String,Object>();
                   ${
            props.map {
                "m.put(\"${it}\",a.${it})"

            }
        }}}
        """
    }

    override fun process(set: MutableSet<out TypeElement>?, env: RoundEnvironment?): Boolean {
        val el = env?.getElementsAnnotatedWith(MapperAnnotation::class.java)?.firstOrNull()
        if (el?.kind == ElementKind.CLASS) {
            val pkg = el.javaClass.`package`.name
            val cls = el.javaClass.simpleName
            val props = el.javaClass.kotlin.memberProperties.map { it.name }
            val mapperClass = getMapperClass(pkg, cls, props)
            val jfo = processingEnv.filer.createClassFile(cls + "Mapper")
            val writer = jfo.openWriter()
            writer.write(mapperClass)
            writer.close()
        }

        return true
    }
}

fun main() {
    val processor=MapperProcessor()
}
package annotation;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/**
 * Author:sweet
 * Created:2019/1/23
 */

//@interface表示注解接口
@interface  MyAnnotation{
    public String name();
    public int age();
}
@Deprecated
@MyAnnotation(name="tang",age=18)
class Member implements Serializable{}

@MyAnnotation(name="tang",age=18)
public class CreateAnnotation {
    public static void main(String[] args) {
        Annotation[] annotations=new Annotation[0];
        annotations= Member.class.getAnnotations();
        System.out.println();
        for(Annotation a:annotations){
            System.out.println(a);
        }

    }
}

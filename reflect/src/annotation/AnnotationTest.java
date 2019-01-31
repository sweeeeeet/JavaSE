package annotation;

import java.io.Serializable;
import java.lang.annotation.Annotation;


/**
 * Author:sweet
 * Created:2019/1/23
 */
class Test implements Serializable{
    @Deprecated
    @Override
    public String toString(){
        return super.toString();
    }
}
@SuppressWarnings("serial")
@Deprecated
public class AnnotationTest {
    public static void main(String[] args) {
        Annotation[] ant=Test.class.getAnnotations();
        for(Annotation a:ant){
            System.out.println(a);
        }
        Annotation[] ant1=new Annotation[0];
        try {
            ant=Test.class.getMethod("toString").getAnnotations();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        for(Annotation a:ant1){
            System.out.println(a);
        }
    }
}

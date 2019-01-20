package loader;

/**
 * Author:sweet
 * Created:2019/1/16
 */
public class Test {
    public static void main(String[] args) {
        Class<?> cla=Test.class;
        System.out.println(cla.getClassLoader());
    }
}

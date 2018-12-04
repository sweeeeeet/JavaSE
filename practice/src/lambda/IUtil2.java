package lambda;

/**
 * Author:sweet
 * Created:2018/12/3
 */
@FunctionalInterface
public interface IUtil2 {
    String convert();

    public static void main(String[] args) {
       IUtil2 iu=() -> "hello";
        System.out.println(iu.convert());

        //对象方方法引用
        IUtil2 iUtil2="hello"::toUpperCase;
        System.out.println(iUtil2.convert());
    }
}

package lambda;

/**
 * Author:sweet
 * Created:2018/12/3
 */
@FunctionalInterface
public interface IUtil1 {
    String convert(Integer in);

    public static void main(String[] args) {
        //1.引用静态方法
        IUtil1 iUtil1 =String::valueOf;
        System.out.println(iUtil1.convert(34));//34
        String s=iUtil1.convert(34);
        System.out.println(s.charAt(1));//4
    }
}

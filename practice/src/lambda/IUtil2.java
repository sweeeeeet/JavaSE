package lambda;

/**
 * Author:sweet
 * Created:2018/12/3
 */
@FunctionalInterface
public interface IUtil2 {
    int convert(String str);
    public static void main(String[] args) {
       String str="ni hao ";

       //调用"ni hao "对象的实例方法indexOf(同样是入参为String，返回值为int)
        IUtil2 iUtil2=str::indexOf;
        System.out.println(iUtil2.convert("n"));
    }
}

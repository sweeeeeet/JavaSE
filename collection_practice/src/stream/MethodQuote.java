package stream;

/**
 * Author:sweet
 * Created:2019/1/16
 */
@FunctionalInterface
interface Iutil<P,R>{
    public  R switchWord(P p);
}

public class MethodQuote {
    public static void main(String[] args) {
        //利用泛型创建的方法在使用时一定要指定数据类型
        //静态方法用类引用
        Iutil<Integer,String> iu=String::valueOf;//利用String类的静态方法实现接口中的抽象函数
        String str = iu.switchWord(12);
        //用返回值的类型调用函数
        Iutil<Double,String> iu2=String::valueOf;
        //对象方法用对象引用（需对象调用）
        Iutil<String,String> iutil="java"::concat;
        System.out.println(iutil.switchWord(" is best"));
        //成员方法引用（类调用）
        Iutil<String,Integer> iutil1=String::hashCode;
    }
    }


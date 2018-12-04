package lambda;

/**
 * Author:sweet
 * Created:2018/12/3
 */
interface Funinter2{
    String print(int num);
}

public class TestLambda2 {

    public static void main(String[] args) {
    //括号中的参数与抽象方法的参数对应
    // (参数名可以重起,遵循不能与作用域内变量名重复的原则)
    //只有返回值可简写
        Funinter2 fun2=(num)->"hello";
        System.out.println(fun2.print(78));
    }
}

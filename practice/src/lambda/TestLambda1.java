package lambda;

/**
 * Author:sweet
 * Created:2018/12/3
 */
interface Funinter{
    void print();
}

public class TestLambda1 {
    public void inner() {
        Funinter iutil = new Funinter() {
            @Override
            public void print() {
                System.out.println("匿名内部类实现接口的抽象方法");
            }
        };
        iutil.print();
    }
    public static void main(String[] args) {
    //lambda表达式中,方法的实现只有一行代码,大括号可以省略
        Funinter iutil1 = ()-> System.out.println("lambda表达式实现接口抽象方法");
        iutil1.print();
        TestLambda1 testLambda1 =new TestLambda1();
        testLambda1.inner();


    }
}

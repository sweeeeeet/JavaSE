package lambda;

/**
 * Author:sweet
 * Created:2018/12/3
 */
interface Funinter3{
    String print(char ch);
}

public class TestLambda3 {

    public static void main(String[] args) {

        Funinter2 fun2=(ch)->{
            char temp='C'+32;
            return temp+""+ch;
        };
        System.out.println(fun2.print('b'));
    }
}

package lambda;

/**
 * Author:sweet
 * Created:2018/12/3
 */
@FunctionalInterface
public interface IUtil4 {
Person4  print(int a, String b);

    public static void main(String[] args) {
        IUtil4 iUtil4 =Person4::new;
    }
}

class Person4{
    private int age;
    private String name;

    public Person4(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public String getPersonInfo(){
        return "姓名"+this.name+"年龄"+this.age;
    }
}

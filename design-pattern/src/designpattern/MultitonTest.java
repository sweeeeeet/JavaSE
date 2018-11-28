package designpattern;

/**
 * Author:sweet
 * Created:2018/11/26
 */
public class MultitonTest{
    public static void main(String[] args) {
        Multiton gender=Multiton.getMultiton(1);
        Multiton gender2=Multiton.getMultiton(2);
        System.out.println(gender.getValue());
        System.out.println(gender2.getValue());
    }

}
 class Multiton {
    private String value;
    private static final Multiton MALE = new Multiton("男");
    private static final Multiton FEMALE = new Multiton("女");

    private Multiton(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Multiton getMultiton(int num) {
        switch (num) {
            case 1:
                return MALE;
            case 2:
                return FEMALE;
            default:
                return null;
        }

    }
}

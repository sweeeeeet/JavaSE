/**
 * Author:sweet
 * Created:2018/11/26
 */
interface IMesage {
    public  void getMesage();
}

class Mesage implements IMesage{
    @Override
    public void getMesage() {
        System.out.println("Imessag的实现类");
    }
}
public class ObjectTest2{
    public static void main(String[] args) {
        IMesage im=new Mesage();//实现类向接口转型
        Object obj=im;//接口向Object转型
       im.getMesage();

       //Object接收接口的实现类,依然要强制类型转换
       Object object=new Mesage();
        ((Mesage) object).getMesage();

        //Object强制类型转化,向下转型
        IMesage temp=(IMesage)object;
        temp.getMesage();
    }
}
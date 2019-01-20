package reflectclass;

import java.lang.reflect.Field;

/**
 * Author:sweet
 * Created:2019/1/17
 */
public class GetFiled {
    protected  boolean b=true;
    public long l=123l;
    String str = "java";
    private int num=100;
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> cla=null;
        cla=GetFiled.class;
        //只能获取到public权限的属性
        Field[] fields=cla.getFields();
        for(int i=0,size=fields.length;i<size;i++){
            //设置可以访问全部属性
            fields[i].setAccessible(true);
            System.out.println("成员属性名称"+fields[i].getName());
            System.out.println("成员属性类型"+fields[i].getType());
            //取得属性内容
            System.out.println("成员属性内容"+fields[i].get(cla.newInstance()));
        }
    }
}

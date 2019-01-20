package reflectclass;

import java.lang.reflect.Array;

/**
 * Author:sweet
 * Created:2019/1/17
 */
public class GetArray {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5};
        //取得元素类型
        Class<?> cla = num.getClass().getComponentType();
        System.out.println("数组元素类型：" + cla.getName());
        System.out.println("数组元素长度：" + Array.getLength(num));
        System.out.println("修改前的数组");
        for (int i = 0, len = Array.getLength(num); i < len; i++) {
            System.out.print(Array.get(num, i) + " ");
        }
        System.out.println();
        System.out.println("修改后的数组");
        for (int i = 0, len = Array.getLength(num); i < len; i++) {
            Array.set(num,i,i*2+1);
            System.out.print(Array.get(num,i)+ " ");
        }
//创建新的数组
        String[] str=null;
        str = (String[]) Array.newInstance(String.class, 5);
        for(int i=0;i<str.length;i++){
            Array.set(str,i,"i="+i);
        }
        for(int i=0;i<str.length;i++){
            System.out.println( Array.get(str,i));
        }
    }
}

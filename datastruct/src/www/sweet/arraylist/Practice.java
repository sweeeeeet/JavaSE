package www.sweet.arraylist;

/**
 * Author:sweet
 * Created:2019/4/3
 */
public class Practice {

    public static void Bubble(int[] array){
        boolean isSort=false;
        for(int i=0;i<array.length;i++){
            //12345
            //345
            for(int j=i;j<array.length-i-1;j++){
                //将最大的数置换到最后去
                if(array[i]>array[i+1]){
                    int temp=array[i];
                    array[i]=array[i+1];
                    array[i+1]=temp;
                    isSort=true;
                }
                //没有经过内循环，说明数组中，每前一个数都比后一个数小，因此可以直接退出排序
                if(isSort==false){
                    break;
                }

            }
        }
    }
}

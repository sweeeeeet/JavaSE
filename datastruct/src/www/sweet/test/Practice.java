package www.sweet.test;

/**
 * Author:sweet
 * Created:2019/5/8
 */
public class Practice {
    //求第k层节点个数
    public static int getKlevelSize(Node root,int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKlevelSize(root.left,k-1)+getKlevelSize(root.right,k-1);
    }

    public static void  insert(int[] array){
        //无序区间[0,array.length-i)
        //有序区间[array.length-i,array.length)
        for(int i=0;i<array.length;i++){

            int j=i-1;
            for(;j>=0&&array[j]<array[i];j--){
                //如果是大的直接插在有序区间的后面
                //如果抓起来是小的，就要找合适的位置，一直向前搜寻
                // 直到找到比我手上这张牌小的，我就插在她后面（与找到的这张牌的后一个交换或是直接把这牌向后搬）
                int a=array[j+1];
                array[j+1]=array[i];
                array[i]=a;
                //array[j+1]=array[j];
            }
                array[j+1]=array[i];
        }
    }

}

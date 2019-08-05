import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str1=sc.nextLine();
            String str2=sc.nextLine();
            if(str1==null||str2==null||str1.length()==0||str2.length()==0){
                return;
            }
            char[] ch1=str1.toCharArray();
            char[] ch2=str2.toCharArray();
            StringBuffer sb=new StringBuffer();
            StringBuffer res=new StringBuffer();
            for(int i=0;i<ch1.length;i++){
                //利用动态规划的思想，同时遍历两个字符串
                int index=i;
                for(int j=0;j<ch2.length;j++){
                    //首先保证在第二个字符串中不越界，并且两个字符相等，那么进入指针前进，并且追加到公共记录中
                    if(index<ch1.length&&ch1[index]==ch2[j]){
                        index++;
                        sb.append(ch2[j]);
                    }else{
                        //判断是否是最长字符串
                        if(sb.length()>res.length()){
                            res=sb;
                        }
                        //如果两个字符不相等，指针不前进，将公共字符串记录更新为空字符串
                        index=i;
                        sb=new StringBuffer("");
                    }
                }
                if(sb.length()>res.length()){
                    res=sb;
                }
            }
        }
    }
}
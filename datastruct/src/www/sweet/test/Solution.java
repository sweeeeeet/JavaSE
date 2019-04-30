package www.sweet.test;

import java.time.ZonedDateTime;
import java.util.Scanner;

/**
 * Author:sweet
 * Created:2019/4/29
 */
class Solution{
    public static void main(String[] args){
        String start=null;
        String arrive=null;
        Scanner scan=new Scanner(System.in);
        start=scan.nextLine();
        arrive=scan.nextLine();
        calcuTime(start,arrive);

    }
    public static void calcuTime(String start,String end){
        if(start==null||end==null){
            return;}
     int sstart= Integer.parseInt(start);
     int eend= Integer.parseInt(end);
     if(eend<sstart){
         return;
     }
     //1420-730=690
        //650
        int res=eend-sstart;//700
        int hour=res/100;
        int min=res-(100*hour);
       if (min>60){
            res+=60;
            hour=(res%100)-1;
            min=res-hour*100;
        System.out.println("航班飞行时间为"+hour+"小时"+min+"分钟");
        }
       System.out.println("航班飞行时间为"+hour+"小时"+min+"分钟");

    }
}

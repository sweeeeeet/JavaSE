package com.practice1128;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * Author:sweet
 * Created:2018/11/28
 */
public class EnumTest {
    public static void main(String[] args) {

        Week[] weeks=Week.values();
        for(int i=0;i<weeks.length;i++){
            System.out.print(weeks[i].ordinal());//int
            System.out.println(weeks[i].toString());//String
            System.out.println(weeks[i].name());//String
            System.out.println(weeks[i]);//Week
        }
//        //获取枚举成员
//        Week weekday=Week.FRIDAY;
//        switch (weekday) {
//            case MONDAY:
//                System.out.println("周一");
//                break;
//            case TUESDAY:
//                System.out.println("周二");
//                break;
//            case FRIDAY:
//                System.out.println("周五");
//                break;
//        }
    }
}

enum Week {

    MONDAY(00, 00, 00), TUESDAY, WEDNSDAY, THURSDAY, FRIDAY;
    private int hour;
    private int minutes;
    private int seconds;

    Week() {
    }

    Week(int hour, int minutes, int seconds) {
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }

}

package datastruction;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * Author:sweet
 * Created:2018/11/27
 */
public class LinkTest {
    public static void main(String[] args) {
        Link link=new Link("车头");
        link.add("01");
        link.add("02");
        link.print();
        System.out.println(link.size());;
//        System.out.println( link.contains("02"));;
//        System.out.println(link.contains("05"));;
//        System.out.println(link.remove("02"));;
//        System.out.println(link.remove("05"));;
//        link.print();
        link.set(0,"23");
        link.print();


    }
}

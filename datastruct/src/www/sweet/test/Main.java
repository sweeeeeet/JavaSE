package www.sweet.test;



import java.util.Scanner;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan =new Scanner(System.in);
        while(scan.hasNextLine()){
            int a=scan.nextInt();
            int count=  bottleNum(a);
            if(a-count*2+1==3){
                System.out.println(++count );
            }else{
                System.out.println(count );
            }
        }
    }

    public static int  bottleNum(int n){
        if(n<3){
            return 0;
        }

        return bottleNum(n-3+1)+1;
    }
}

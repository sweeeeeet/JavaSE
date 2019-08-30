import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = sc.nextInt();
            }
            int max = 0;
            for (int i = 1; i < num.length; i++) {
                if (num[i] < num[i - 1]) {
                    int nowMax=1;
                    while (i<num.length-1&&num[i]<num[i-1]){
                        i++;
                        nowMax++;
                    }
                    while (i<num.length-1&&num[i]>num[i+1]){
                        i++;
                        nowMax++;
                    }
                    if(num[i-1]>num[i]){
                        max=max>=nowMax?max:nowMax;
                    }
                    i--;
                }

            }
            System.out.println(max);
        }
    }
}
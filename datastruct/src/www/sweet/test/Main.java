import  java.util.*;
public  class Main{
    public static  void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] array=new int[n];
            for(int i=0;i<n;i++){
                array[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){

                int front=(n-i-1)%n;
                int next=(n-i+1)%n;
                if(array[front]+array[next]<array[i]){
                    System.out.println("No");
                    break;
                }
            }
            System.out.println("Yes");

        }
    }
}
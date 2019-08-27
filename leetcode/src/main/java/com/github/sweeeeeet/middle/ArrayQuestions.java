package com.github.sweeeeeet.middle;

/**
 * Author:sweet
 * Created:2019/5/16
 */
public class ArrayQuestions {
    public int fib(int N) {
        if(N==1||N==0){
            return N;
        }
        return fib(N-1)+fib(N-2);
    }

    public int fib2(int N) {
        if(N==1||N==0){
            return N;
        }
        int[] res=new int[N+1];
        res[0]=0;
        res[1]=1;
        for(int i=2;i<=N;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res[N];

    }
}

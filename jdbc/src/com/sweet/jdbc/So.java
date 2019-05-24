package com.sweet.jdbc;

/**
 * Author:sweet
 * Created:2019/5/15
 */
public class So {
    public void print(int m,int n){
        boolean[] persons=new boolean[n];
        int isHe=1;
        int index=0;
        int size=n;
        while(size>0){
            if(!persons[index]){
                if(isHe==m){
                    persons[index]=true;
                    System.out.println(index+1);
                    isHe=0;
                    size--;
                }
                isHe++;
            }
            index++;
            if(index==n){
                index=0;
            }
        }
    }
}

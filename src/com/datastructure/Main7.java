package com.datastructure;

import java.util.Scanner;

/**
 * Created by peter on 2017/3/19.
 * 牛牛新买了一本算法书，算法书一共有n页，页码从1到n。牛牛于是想了一个算法题目：在这本算法书页码中0~9每个数字分别出现了多少次？ 
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = getEachDigital(in.nextInt());
        for(int i=0;i<array.length;i++){
            if(i<array.length-1)
                System.out.print(array[i]+" ");
            else
                System.out.print(array[i]);
        }
    }
    /*可以分析0-9每个数字只出现一次，00-99每个数字出现20次，000-999每个数字出现300次，规律就是每个数字出现的次数
    为d*10^d(d是数字的位数)，当然此时没有考虑去掉01,001,010这类数，但总体就是这个思路，比如1897首选考虑的肯定是0-999，然后在考虑1000-1897
    其实也就是递归考虑000-897
     */
   public static int[] getEachDigital(int n){
       int[] digitals = new int[10];
       int[] b = new int[]{0,1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};
       int numberOfDigital = 0;
       int tempN = n;
       while (tempN>0){
           numberOfDigital++;
           tempN/=10;
       }
       int[] c =new int[numberOfDigital];
       tempN = n;
       int count = 0;
       while (tempN>0){
           c[count] = tempN%10;
           tempN/=10;
           count++;
       }
       for(int length=numberOfDigital;length>=1;length--){
           for(int i=0;i<=9;i++)digitals[i]+= c[length-1]*b[length-1]*(length-1);
           for(int i=0;i<c[length-1];i++)digitals[i]+=b[length];
           digitals[c[length-1]]+=n%b[length]+1;
       }
       for(int i=1;i<=numberOfDigital;i++){
           digitals[0]-=b[i];
       }
       return digitals;
   }

}

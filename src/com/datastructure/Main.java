package com.datastructure;

import java.util.Scanner;

/**如果一个数字能表示为p^q(^表示幂运算)且p为一个素数,q为大于1的正整数就称这个数叫做超级素数幂。现在给出一个正整数n,如果n是一个超级素数幂需要找出对应的p,q。
 * Created by peter on 2017/3/8.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("please input a number");
        while (in.hasNextDouble()){
            double data = in.nextDouble();
            System.out.println(getSuperPrime(data));
        }
    }

    //求超级素数
    public static String getSuperPrime(double m){
        for(int q=2;q<60;q++){
            double p = Math.pow(m,1.0/q);
            int initP = (int)(p+0.1);
            if(Math.pow(initP,q)==m){
                if(isPrime(initP)){
                    return initP+" "+q;
                }
            }
        }
        return "No";
    }
   //判断是否是素数
    public static boolean isPrime(int n){
        if(n<2)return false;
        if(n==2||n==3)return true;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)return false;
        }
        return true;
    }
}

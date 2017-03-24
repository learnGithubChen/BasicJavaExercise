package com.datastructure;

import java.util.Scanner;

/**牛牛正在挑战一款名为01翻转的游戏。游戏初始有A个0,B个1，牛牛的目标就是把所有的值都变为1，每次操作牛牛可以任意选择恰好K个数字，并将这K个数字的值进行翻转(0变为1，1变为0)。牛牛如果使用最少的操作次数完成这个游戏就可以获得奖品，牛牛想知道最少的操作次数是多少？
 例如:A = 4 B = 0 K = 3
 0000 -> 1110 -> 1001 -> 0100 -> 1111
 需要的最少操作次数为4
 * Created by peter on 2017/3/8.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            System.out.println(getTimes(a,b,k));
        }
    }
    public static int getTimes(int a,int b,int k){
        if(a==0)return 0;
        int used,rest;
        for(int i=1;i<=20000;i++){
            used = k*i - a;//A为0一定会翻转的一次
            if(used<0)
                continue;//剩余翻转次数不能为负
            rest = a*((i-1)/2*2);//A剩下需要多翻的一定是偶数次
            rest+=b*(i/2*2);//B翻转的次数一定是小于i的偶数
            if(used%2==0&&rest>=used){
                return i;
            }
        }
        return -1;
    }
}

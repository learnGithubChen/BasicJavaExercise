package com.datastructure;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by peter on 2017/3/15.
 * 牛牛有一个鱼缸。鱼缸里面已经有n条鱼，每条鱼的大小为fishSize[i] (1 ≤ i ≤ n,均为正整数)，牛牛现在想把新捕捉的鱼放入鱼缸。鱼缸内存在着大鱼吃小鱼的定律。经过观察，牛牛发现一条鱼A的大小为另外一条鱼B大小的2倍到10倍(包括2倍大小和10倍大小)，鱼A会吃掉鱼B。考虑到这个，牛牛要放入的鱼就需要保证：
 1、放进去的鱼是安全的，不会被其他鱼吃掉
 2、这条鱼放进去也不能吃掉其他鱼
 鱼缸里面已经存在的鱼已经相处了很久，不考虑他们互相捕食。现在知道新放入鱼的大小范围[minSize,maxSize](考虑鱼的大小都是整数表示),牛牛想知道有多少种大小的鱼可以放入这个鱼缸。
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       while (true){
           int minSize = in.nextInt();
           int maxSize = in.nextInt();
           int length = in.nextInt();
           int[] fishes = new int[length];
           for(int i=0;i<length;i++){
               fishes[i] = in.nextInt();
           }
           System.out.println(getMaxkinds(minSize,maxSize,fishes));
       }
    }
    public static int getMaxkinds(int minSize,int maxSize,int[] fishes){
        Set<Integer> sizeOfFishes = new HashSet<>();
        int j;
        //找出所有满足不吃池内鱼的尺寸
       for(int i =minSize;i<=maxSize;i++){
           boolean canInput = true;
           for(j =0;j<fishes.length;j++){
              if((i>=fishes[j]*2&&i<=fishes[j]*10)||(fishes[j]<=i*10&&fishes[j]>=i*2)){
                  canInput = false;
                  break;
              }
           }
            if(canInput){
               sizeOfFishes.add(i);
            }
       }

        return sizeOfFishes.size();
    }
}

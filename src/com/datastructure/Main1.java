package com.datastructure;

import java.util.Scanner;

/**给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。答案可能有多个，我我们需要找出长度最小的那个。
 例如 N = 18 L = 2：
 5 + 6 + 7 = 18
 3 + 4 + 5 + 6 = 18
 都是满足要求的，但是我们输出更短的 5 6 7
 * Created by peter on 2017/3/8.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int n = in.nextInt();
            int l = in.nextInt();
            System.out.println(getShortestLine(n,l));
        }
    }
    public static String getShortestLine(int n,int l){
        int initP = 0;//起始点
        for(int i=l;i<=100;i++){
            if(2*n%i==0){
                int firstResult = 2*n/i;
                if((firstResult+1-i)%2==0){
                    initP = (firstResult+1-i)/2;
                    String shortestLine = "";
                    for(int k=0;k<i;k++){
                        if(k<i-1){
                            shortestLine+=initP+k+" ";
                        }else{
                            shortestLine+=initP+k;
                        }
                    }
                    return shortestLine;
                }
            }
        }
        return "No";
    }
}

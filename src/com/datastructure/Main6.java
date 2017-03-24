package com.datastructure;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by peter on 2017/3/19.
 * 牛牛的好朋友羊羊在纸上写了n+1个整数，羊羊接着抹除掉了一个整数，给牛牛猜他抹除掉的数字是什么。牛牛知道羊羊写的整数神排序之后是一串连续的正整数，牛牛现在要猜出所有可能是抹除掉的整数。例如：
 10 7 12 8 11 那么抹除掉的整数只可能是9
 5 6 7 8 那么抹除掉的整数可能是4也可能是9
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] arrays = new int[length];
        for(int i=0;i<length;i++){
            arrays[i] = in.nextInt();
        }
        System.out.println(getDeleteNumber(arrays));
    }
    public static String getDeleteNumber(int[] arrays){
        Arrays.sort(arrays);
        int serialCounter =0;//数字连续的次数
        String deletedNumber = "";//返回值
        for(int i=1;i<arrays.length;i++){
            if(arrays[i-1]+1==arrays[i]){
                serialCounter++;
            }else{
                if(arrays[i-1]+2 ==arrays[i])
                    deletedNumber+=arrays[i]-1;
            }
        }
        if(serialCounter==arrays.length-2){
            return deletedNumber;
        }else if(serialCounter==arrays.length-1){
            return (arrays[0]-1)>0?(arrays[0]-1)+" "+(arrays[arrays.length-1]+1):arrays[arrays.length-1]+1+"";
        }else{
            return "mistake";
        }
    }
}

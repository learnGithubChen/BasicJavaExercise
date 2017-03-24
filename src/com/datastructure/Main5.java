package com.datastructure;

import java.util.Scanner;

/**
 * Created by peter on 2017/3/19.
 * DNA分子是以4种脱氧核苷酸为单位连接而成的长链，这4种脱氧核苷酸分别含有A,T,C,G四种碱基。碱基互补配对原则：A和T是配对的，C和G是配对的。如果两条碱基链长度是相同的并且每个位置的碱基是配对的，那么他们就可以配对合成为DNA的双螺旋结构。现在给出两条碱基链，允许在其中一条上做替换操作：把序列上的某个位置的碱基更换为另外一种碱基。问最少需要多少次让两条碱基链配对成功
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        System.out.println(getChangeTimes(s1,s2));
    }
    public static int getChangeTimes(String s1,String s2){
        int count = 0;
        for(int i=0;i<s1.length();i++){
            if(Math.abs(s1.charAt(i)-s2.charAt(i))==4||Math.abs(s1.charAt(i)-s2.charAt(i))==19){
            }else{
                count++;
            }
        }
        return count;
    }
}

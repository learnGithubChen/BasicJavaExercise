package com.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by peter on 2017/3/15.
 * 如果一个单词通过循环右移获得的单词，我们称这些单词都为一种循环单词。 例如：picture 和 turepic 就是属于同一种循环单词。 现在给出n个单词，需要统计这个n个单词中有多少种循环单词。
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String[] lines = new String[length];
        for(int i =0;i<length;i++){
            lines[i] = in.next();
        }
        System.out.println(getStringNumbers(lines));
    }
    public static int getStringNumbers(String[] lines){
        List<String> list = new ArrayList();
        list.add(lines[0]);
        for(int i=1;i<lines.length;i++){
            int j = 0;
            for(j =0;j<list.size();j++){
                if(isEqual(list.get(j),lines[i]))
                    break;
            }
            if(j==list.size()){
                list.add(lines[i]);
            }
        }

        return list.size();
    }

    public static boolean isEqual(String original,String desc){
        if(original.length()!=desc.length())
            return false;
        StringBuilder sb = new StringBuilder(original);
        for(int i = original.length()-1;i>0;i--){
            if((sb.substring(i)+sb.substring(0,i)).equals(desc)){
                return true;
            }
        }
        return false;
    }
}

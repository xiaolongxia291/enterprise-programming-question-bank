package com.tracy.bank.shopee;

import java.util.HashMap;

/**
 * @author Tracy 落单字符
 *
 * 给定字符串，请帮小虾米找出最后一个只出现一次的字符。
 *
 * 输入例子1:
 * "shopee"
 *
 * 输出例子1:
 * "p"
 */

public class Solution2022_9 {
    public static String lastUniqueChar (String str) {
        if(str.trim().length()==0)return "";
        /**
         * 使用HashMap，而不能用数组int[] count=new int[26]
         * 这道题坑就坑在题目没说可能会包含除了字母以外的其他字符
         */
        HashMap<Character,Integer> count = new HashMap<>();
        char[] chars=str.toCharArray();
        for(char c:chars){
            if(count.containsKey(c))count.replace(c,count.get(c)+1);
            else count.put(c,1);
        }
        for(int i=chars.length-1;i>=0;--i){
            if(count.get(chars[i])==1)return String.valueOf(chars[i]);
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(lastUniqueChar("shOpee1z"));
    }
}

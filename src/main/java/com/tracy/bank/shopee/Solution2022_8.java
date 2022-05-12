package com.tracy.bank.shopee;

/**
 * @author tracy
 * 2022-8 最长连续子字符串：
 *
 * 输入一个字符串 s ，请返回该字符串的“只包含一种字符的最长非空子字符串”。
 *
 * 输入例子1:
 * "ssssssssssssssshhhhopeeeeeeee"
 *
 * 输出例子1:
 * "sssssssssssssss"
 *
 * 输入例子2:
 * ""
 *
 * 输出例子2:
 * ""
 *
 */
public class Solution2022_8 {
    public static String findLongestSubstr (String str) {
        if(str.trim().length()==0)return "";
        /**
         * 遍历，用ans存放结果，用max存放最长子串
         */
        char[] chars=str.toCharArray();
        StringBuilder ans=null;
        int max=0;
        for(int i=0;i<chars.length;){
            int j=i+1;
            //这道题没说清楚的是：字母不区分大小写
            while(j<chars.length&&(chars[j]==chars[i]||Math.abs(chars[j]-chars[i])==32))++j;
            if(j-i>max){
                max=j-i;
                ans=new StringBuilder(str.substring(i,j));
            }
            i=j;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(findLongestSubstr("SsssSsssssssssshhhhopeeeeeeee"));
    }
}

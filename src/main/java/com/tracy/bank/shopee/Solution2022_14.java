package com.tracy.bank.shopee;

/**
 * @author tracy
 * 2022-14 字符串压缩功能：
 *
 * 利用字符重复出现的次数，实现字符串压缩功能。
 * 若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）
 *
 * 输入例子1:
 * "abcccaaaa"
 *
 * 输出例子1:
 * "a1b1c3a4"
 */
public class Solution2022_14 {
    public static String compressString (String test_string) {
        if(test_string==null||test_string.length()==0)return "";

        char[] chars=test_string.toCharArray();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<chars.length;){
            int j=i;
            while(j<chars.length&&chars[j]==chars[i])++j;
            ans.append(chars[i]);
            ans.append(j-i);
            i=j;
        }

        return ans.length()<test_string.length()?ans.toString():test_string;
    }

    public static void main(String[] args) {
        System.out.println(compressString("abcccaaaa"));
    }
}

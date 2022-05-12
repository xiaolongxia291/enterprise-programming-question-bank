package com.tracy.bank.shopee;

/**
 * @author tracy
 *
 * 2022-5 压缩字符串(一)：
 *
 * 利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2bc5a3。
 * 1.如果只有一个字符，1不用写
 * 2.字符串中只包含大小写英文字母（a至z）。
 *
 * 数据范围:
 * 0<=字符串长度<=50000
 *
 * 要求：时间复杂度O(N）
 *
 * 输入例子1:
 * "aabcccccaaa"
 *
 * 输出例子1:
 * "a2bc5a3"
 *
 * 输入例子2:
 * "shopeew"
 *
 * 输出例子2:
 * "shope2w"
 */
public class Solution2022_5 {
    public static String compressString (String param) {
        /**
         * 0 处理特殊情况
         */
        if(param.length()==0)return "";
        /**
         * 1 遍历
         */
        char[] chars=param.toCharArray();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<chars.length;++i){
            ans.append(chars[i]);
            int j=i;
            while(j<chars.length&&chars[j]==chars[i])++j;
            if(j-i>1)ans.append(j-i);
            i=j-1;
        }
        /**
         * 2 返回
         */
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressString("shopeew"));
    }
}

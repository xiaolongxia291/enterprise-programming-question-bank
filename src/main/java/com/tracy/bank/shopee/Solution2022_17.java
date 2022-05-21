package com.tracy.bank.shopee;

/**@author tracy
 *
 * 2022-17 字符串算术运算：
 *
 * 给定一个字符串式子，返回它的计算结果。
 * 术规则为: k*[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
 * 注意 k 保证为正整数。e.g. s = "3*[a2*[c]]", 返回 “accaccacc”
 *
 * 输入例子1:
 * "3*[a2*[c]]"
 *
 * 输出例子1:
 * "accaccacc"
 */
public class Solution2022_17 {
    public static String computeString (String str) {
        if(str==null||str.length()==0||str.charAt(0)==']')return "";

        char[] chars=str.toCharArray();
        StringBuilder ans=new StringBuilder();
        //处理字母
        int i=0;
        while(i<chars.length&&(chars[i]>='a'&&chars[i]<='z')){
            ans.append(chars[i]);++i;
        }
        if(i<chars.length){
            //处理数字
            StringBuilder num=new StringBuilder();
            while(i<chars.length&&(chars[i]>='0'&&chars[i]<='9')){
                num.append(chars[i]);++i;
            }
            //处理倍数拼接
            System.out.println("num:"+num);
            long count=Long.parseLong(num.toString());
            System.out.println("sub:"+str.substring(i+2,str.length()-1));
            String item=computeString(str.substring(i+2,str.length()-1));
            while(count-->0)ans.append(item);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(computeString("3*[a2*[c]]"));
    }
}

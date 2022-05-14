package com.tracy.bank.shopee;

/**
 * @author tracy
 *
 * 2022-11 替换字符串中的数字成&quot;num&quot;：
 *
 * 替换字符串中的数字成"num"，如果数字相连,则相连数字一起替换成"num"。数字指0123456789
 * 如："abvhjb123ddd" 替换成 "abvhjbnumddd"
 * 如："abvhjb1y3ddd" 替换成 "abvhjbnumynumddd"
 *
 * 输入例子1:
 * "abvhjb123ddd"
 *
 * 输出例子1:
 * "abvhjbnumddd"
 */
public class Solution2022_11 {
    public static String replaceStr (String s) {
        if(s==null||s.trim().length()==0)return "";

        char[] chars=s.toCharArray();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<chars.length;){
            if(chars[i]>='0'&&chars[i]<='9'){
                int j=i;
                while(j<chars.length&&chars[j]>='0'&&chars[j]<='9')++j;
                i=j;
                ans.append("num");
            }else{
                ans.append(chars[i]);
                ++i;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceStr("abvhjb1y3ddd"));
    }
}

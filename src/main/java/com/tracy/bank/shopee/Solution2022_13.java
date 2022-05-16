package com.tracy.bank.shopee;

/**
 * @author tracy
 * 2022-13 将输入的字符串转换为驼峰（camelCase）风格：
 * 只保留字母[a-zA-Z]和数字[0-9]
 * 输入字符串中的字母字符的前一字符如非字母或数字，该字母转换后为大写，其他字母转换后为小写；
 * 转换后的字符串第一个字符如果是字母，则该字母转换后为小写；
 * 字符串如果为空或者无[a-zA-Z]和数字[0-9]中字符，请默认输出如下字符串"shopee"
 *
 * 输入例子1:
 * "hello_world"
 *
 * 输出例子1:
 * "helloWorld"
 *
 */
public class Solution2022_13 {
    public static String camelCase (String newString) {
        if(newString==null||newString.length()==0||newString.trim().length()==0)return "shopee";

        char[] chars=newString.toCharArray();
        StringBuilder ans=new StringBuilder();

        for(int i=0;i<chars.length;){
            //去除非字母、数字字符
            if(inValid(chars[i])){
                ++i;
            }
            else {
                int j=i;
                while(j<chars.length&&!inValid(chars[j]))++j;
                //若有前一个字符，且前一个字符为非字母和数字字符，首字母转换为大写；否则全部转换为小写
                if(ans.length()!=0&&inValid(chars[i-1])){
                    ans.append(newString.substring(i,i+1).toUpperCase());
                    ans.append(newString.substring(i+1,j).toLowerCase());
                }else{
                    ans.append(newString.substring(i,j).toLowerCase());
                }
                i=j;
            }
        }
        return ans.length()==0?"shopee":ans.toString();
    }
    public static boolean inValid(char c){
        return (c<'a'||c>'z')&&(c<'A'||c>'Z')&&(c<'0'||c>'9');
    }

    public static void main(String[] args) {
        System.out.println(camelCase("he1llo_world"));
    }
}

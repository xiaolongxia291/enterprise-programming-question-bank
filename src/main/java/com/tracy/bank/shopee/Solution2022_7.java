package com.tracy.bank.shopee;

/**
 * @author tracy
 *
 * 2022-7 小驼峰格式转换：
 *
 * 将输入的变量名转换为小驼峰写法
 * 可能的输入命名格式如下：
 * TestVariable
 * test_variable
 * TEST_VARIABLE，
 * 最终输出为testVariable
 *
 * 输入例子1:
 * "test_variable"
 *
 * 输出例子1:
 * "testVariable"
 *
 * 输入例子2:
 * ""
 *
 * 输出例子2:
 * ""
 */
public class Solution2022_7 {
    public static String format (String name) {
        if(name==null||name.trim().length()==0)return "";
        char[] chars=name.toCharArray();
        StringBuilder ans=new StringBuilder();
        /**
         * 遍历字符串，找到单词分隔，处理并拼接
         */
        for(int i=0;i<chars.length;){
            if(chars[i]=='_'){
                ++i;
                continue;
            }
            int j=i+1;
            while(j<chars.length&&!isFirst(chars[j],chars[j-1]))++j;
            if(i==0){
                ans.append(name.substring(i,j).toLowerCase());
                i=j;
                continue;
            }
            ans.append(name.substring(i,i+1).toUpperCase());
            ans.append(name.substring(i+1,j).toLowerCase());
            i=j;
        }
        return ans.toString();
    }
    public static boolean isFirst(char c,char last){
        if(c=='_'||(c>='A'&&c<='Z'&&last>='a'&&last<='z'))return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(format("TEST_VARIABLE"));
    }
}

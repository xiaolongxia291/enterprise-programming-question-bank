package com.tracy.bank.shopee;

import java.util.Scanner;

/**
 * @author tracy
 *
 * 2022-16 字符串命名转换
 *
 * 孔乙己说“回”字有四种写法，编程语言中常见的命名风格有如下四种：
 *  - 全部首字母大写
 *  - 第一个单词首字母小写，其余单词首字母大写
 *  - 单词全部小写，由下划线连接
 *  - 单词全部小写，由减号连接
 *
 * 请设计并实现一个caseTransform函数，使得一个字符串str可以被方便地转成四种形式，并且将四种形式通过空格拼接成一个字符串返回
 * 为方便起见，这里假设输入字符串全部符合以上四种形式的英文字母组合
 *
 * 输入描述:
 * PascalCaseTest
 *
 * 输出描述:
 * PascalCaseTest  pascalCaseTest  pascal_case_test pascal-case-test
 *
 * 输入例子1:
 * PascalCaseTest
 *
 * 输出例子1:
 * PascalCaseTest pascalCaseTest pascal_case_test pascal-case-test
 */
public class Solution2022_16 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String str=input.next();
        System.out.println(caseTransform(str));
    }
    public static String caseTransform(String str){
        char[] chars=str.toCharArray();
        StringBuilder ans0=new StringBuilder();
        StringBuilder ans1=new StringBuilder();
        StringBuilder ans2=new StringBuilder();
        StringBuilder ans3=new StringBuilder();
        for(int i=0;i<chars.length;){
            if(chars[i]=='-'||chars[i]=='_')++i;
            else{
                int j=i+1;
                //首字母拼接
                String upper=String.valueOf(chars[i]).toUpperCase();
                String lower=String.valueOf(chars[i]).toLowerCase();
                ans0.append(upper);
                ans1.append(i==0?lower:upper);
                if(i!=0){
                    ans2.append('_');
                    ans3.append('-');
                }
                ans2.append(lower);
                ans3.append(lower);
                //单词的剩下部分拼接
                while(j<chars.length&&chars[j]<='z'&&chars[j]>='a'){
                    ans0.append(chars[j]);
                    ans1.append(chars[j]);
                    ans2.append(chars[j]);
                    ans3.append(chars[j]);
                    ++j;
                }
                i=j;
            }
        }
        return ans0+" "+ans1+" "+ans2+" "+ans3;
    }
}

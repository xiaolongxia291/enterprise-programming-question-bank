package com.tracy.bank.shopee;

import java.util.HashMap;

/**
 * @author tracy
 *
 * 2022-15 罗马数字转整数：
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。
 * 但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 输入例子1:
 * "III"
 *
 * 输出例子1:
 * 3
 *
 * 输入例子2:
 * "LVIII"
 *
 * 输出例子2:
 * 58
 *
 * 例子说明2:
 * L = 50, V= 5, III = 3.
 */
public class Solution2022_15 {
    public static int romanToInt (String s) {
        if(s==null||s.length()==0)return 0;

        HashMap<Character,Integer> map=new HashMap<>();
        map.put('V',5);
        map.put('L',50);
        map.put('D',500);
        map.put('M',1000);

        char[] chars=s.toCharArray();
        int ans=0;
        for(int i=0;i<chars.length;++i){
            char c=chars[i];
            if(c=='I'&&i+1<chars.length){
                if(chars[i+1]=='V'){
                    ans+=4;
                    ++i;//跳过下一个字符
                    continue;
                }
                if(chars[i+1]=='X'){
                    ans+=9;
                    ++i;//跳过下一个字符
                    continue;
                }
                ans+=1;
            }else if(c=='X'&&i+1<chars.length){
                if(chars[i+1]=='L'){
                    ans+=40;
                    ++i;//跳过下一个字符
                    continue;
                }
                if(chars[i+1]=='C'){
                    ans+=90;
                    ++i;//跳过下一个字符
                    continue;
                }
                ans+=10;
            }
            else if(c=='C'&&i+1<chars.length){
                if(chars[i+1]=='D'){
                    ans+=400;
                    ++i;//跳过下一个字符
                    continue;
                }
                if(chars[i+1]=='M'){
                    ans+=900;
                    ++i;//跳过下一个字符
                    continue;
                }
                ans+=100;
            }else{
                ans+=map.get(c);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}

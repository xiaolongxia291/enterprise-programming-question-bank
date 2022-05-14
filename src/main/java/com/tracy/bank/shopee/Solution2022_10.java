package com.tracy.bank.shopee;
import java.util.Arrays;

/**
 * @author tracy
 *
 *  2022-10 最大正整数：
 *
 * 输入一个正整数数组，输出由数组里面所有数字组成的最大正整数； 如 {4, 2, 3} 得 432 。
 *
 *
 * 输入例子1:
 * [6,4,5,1]
 *
 * 输出例子1:
 * 6541
 *
 */
public class Solution2022_10 {
    public static int maxIntValue (int[] arrs) {
        if(arrs==null||arrs.length==0)return 0;
        //递减排序，最小的成为个位，第二小的成为十位...
        Arrays.sort(arrs);
        int ans=0;
        for(int i=0;i<arrs.length;++i){
            ans+=arrs[i]*Math.pow(10,i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxIntValue(new int[]{6,4,5,1}));
    }
}

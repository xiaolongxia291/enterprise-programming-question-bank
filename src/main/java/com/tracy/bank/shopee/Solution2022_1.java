package com.tracy.bank.shopee;

import java.util.*;

/**
 * @author Tracy
 *
 * 2022-1 重排字符串和数字：
 *
 * 对于给定的一个包含连续字母、连续数字及空格的字符串（不会出现字母和数字连在一起出现），
 * 实现字母部分按出现顺序排列而数字按照从小到达顺序排在最后一个字母的后面。
 *
 * 数据范围： 字符串长度满足0<=n<=100
 *
 * 示例1：
 * 输入
 * "xb 1 cc 5 dd 10 ee 2"
 * 输出
 * "xb cc dd ee 1 2 5 10"
 *
 * 示例2：
 * 输入
 * ""
 * 输出
 * ""
 *
 * 做题思路：
 * 遍历一遍字符串，对于字母直接放入结果中，对于数字则放入一个优先队列中，
 * 最后把优先队列的元素取出来放入答案。时间复杂度O(nlog2n)，空间复杂度O(n)。
 *
 * 坑爹的地方：
 * 字符串中的数字有可能会溢出，因此应该用Long而不是Integer进行处理，
 * 由于没意识到这个问题前期我总是有一组测试不通过，处理之后直接AC了。
 */
public class Solution2022_1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param text_source string字符串 原始输入
     * @return string字符串
     */
    public static String char_and_num_return (String text_source) {
        // write code here
        /**
         * 0 处理特殊情况
         */
        if(text_source.trim().length()==0)return "";
        /**
         * 1 把输入的字符串以空格分割成字符串数组
         */
        String[] text=text_source.split(" ");
        /**
         * 2 遍历字符串数组：对于字符串数组直接取出来放入结果中，对于数字则放入优先队列中
         */
        StringBuilder ans=new StringBuilder();
        PriorityQueue<String> pq=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (int)(Long.parseLong(o1)-Long.parseLong(o2))%Integer.MAX_VALUE;
            }
        });
        for(String str:text){
            try{
                //如果为数字串
                Long num=Long.parseLong(str);
                pq.add(str);
            }catch (Exception e){
                //如果为字母串
                if(str.length()!=0) {
                    ans.append(str);
                    ans.append(" ");
                }
            }
        }
        /**
         * 3 将优先队列中的元素放入结果中，返回结果
         */
        while(pq.size()!=0){
            ans.append(pq.remove());
            ans.append(" ");
        }
        return ans.toString().trim();
    }
}

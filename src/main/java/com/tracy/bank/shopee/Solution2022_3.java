package com.tracy.bank.shopee;

/**
 * @author Tracy
 *
 * 2022-3 最小金额购买商品：
 *
 * 有一排商品，每一个商品都有自己的价值，现在需要花一定金额购买这些商品。
 * 规则是：如果一个商品的价值比它旁边的一个商品要高，那么这个商品就必须比它旁边的商品花费更多金额。
 * 所有的商品至少要进行一次金额购买。假设一次购买花费金额单位为1，最少需要多少金额可以购买所有商品？
 *
 * 现给定一个数组，数组元素表示每个商品的价值。请编写代码输出最少需要花费的金额。
 *
 * 示例1
 *
 * 输入
 * [1,0,2]
 * 输出
 * 5
 * 1
 * 2
 * 3
 * 4
 *
 * 做题思路：
 * 遍历一遍，记录下相邻元素之间的相对大小情况，
 * 同时记录求和值sum、最小值min；然后直接sum=sum+(1-min)并返回。
 * 时间复杂度O(n)，空间复杂度O(1)（原地修改）。
 */
public class Solution2022_3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array int整型一维数组
     * @return int整型
     */
    public static int cost (int[] array) {
        // write code here
        /**
         * 0 处理异常情况
         */
        if(array==null||array.length==0)return 0;
        /**
         * 1 遍历一遍数组，确定元素两两之间的大小情况，求出调整之前的和sum，记录最小值min
         */
        int item=array[0];//array在遍历过程会被修改，item用来记录前一个元素的值
        array[0]=1;//从1开始
        int sum=1,min=1;//
        System.out.println("当前元素："+item+"调整值："+array[0]+" sum:"+sum+" min:"+min);
        for(int i=1;i<array.length;++i){
            int item_this=array[i];
            if(item_this>item){
                array[i]=array[i-1]+1;
            }else if(item_this<item){
                array[i]=array[i-1]-1;
            }else{
                array[i]=array[i-1];
            }
            sum+=array[i];
            min=Math.min(min,array[i]);
            item=item_this;
            System.out.println("当前元素："+item+"调整值："+array[i]+" sum:"+sum+" min:"+min);
        }
        /**
         * 2 如果min<=0，需要在min的基础上加上array.length*(1-min)
         */
        if(min<=0)sum+=array.length*(1-min);
        return sum;
    }
}

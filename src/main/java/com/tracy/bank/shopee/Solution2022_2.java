package com.tracy.bank.shopee;

import java.util.LinkedList;

/**
 * @author Tracy
 *
 * 2022-2 成对的69:
 *
 * 成对的69匹配序列定义为：
 * 1、 空串"“是一个成对的69序列；
 * 2、如果"X"和"Y"是成对的69序列，那么"XY"也是成对的69序列；
 * 3、如果"X"是一个成对的69序列，那么"6X9"也是一个成对的69序列；
 * 4、每个成对的69序列都可以由以上规则生成。 例如，”", “69”, “6699”, "6969"都是成对的。
 *
 * 现在给出一个序列S，允许你的操作是： 在S的开始和结尾出添加一定数量的6或者9，
 * 使序列S变为一个成对的69序列。输出添加最少的6或者9之后成对的69序列是什么。
 *
 * 做题思路：栈。时间复杂度、空间复杂度均为O(n)。
 */
public class Solution2022_2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param S string字符串
     * @return string字符串
     */
    public static String Paired69 (String S) {
        // write code here
        /**
         * 0 处理异常情况
         */
        if(S==null||S.length()==0||S.trim().length()==0)return "";
        /**
         * 1 遍历字符串：遇到6入栈，遇到9弹栈，栈空则往结果中左边加入一个6
         */
        char[] chars=S.toCharArray();
        StringBuilder ans=new StringBuilder();
        LinkedList<Character> stack=new LinkedList<>();
        for(char c:chars){
            if(c=='6')stack.addLast('6');
            else if(c=='9'&&stack.size()!=0)stack.removeLast();
            else{
                ans.append('6');
            }
        }
        ans.append(S);
        /**
         * 2 检查栈中剩下还有几个元素，就往结果右边加入几个9
         */
        while(stack.size()!=0){
            ans.append('9');
            stack.removeLast();
        }
        return ans.toString();
    }
}

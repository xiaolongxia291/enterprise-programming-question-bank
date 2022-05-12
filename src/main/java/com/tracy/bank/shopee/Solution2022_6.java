package com.tracy.bank.shopee;

/**
 * @author tracy
 *
 * 2022-6 掰花瓣：
 *
 * 手上有 n 朵花，每朵的花瓣数保存在一个数组中。我们每次可以选择任意一朵，拿走其中的一瓣或者两瓣，求掰完所有花的最少次数。
 *
 * 输入例子1:
 * [4,2,1]
 *
 * 输出例子1:
 * 4
 */
public class Solution2022_6 {
    public static int petalsBreak (int[] petals) {
        if(petals.length==0)return 0;

        int ans=0;
        for(int i=0;i<petals.length;++i){
            if(petals[i]==0)continue;
            else if(petals[i]<=2){
                ++ans;
            }else{
                ans+=petals[i]/2;
                if((petals[i]&1)==1)++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(petalsBreak(new int[]{1,2,1}));
    }
}

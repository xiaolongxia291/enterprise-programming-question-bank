package com.tracy.bank.shopee;

/**
 * @author tracy
 *
 * 2022-4 发送指令跟随坐标移动：
 *
 * 假设点P处于坐标轴原点，W表示向上，A表示向左，S表示向下，D表示向右，输入一串指令代表P点的移动轨迹，输出最终P的位置
 *
 * 例如 "2W2D"表示向上移动两个坐标位置，再向右移动两个坐标位置
 * "W2D"表示向上移动一个坐标位置，再向右移动两个坐标位置
 *
 * 输入例子1:
 * "2W2D"
 *
 * 输出例子1:
 * [2,2]
 */
public class Solution2022_4 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param order string字符串
     * @return int整型一维数组
     */
    public static int[] GetEndPoint (String order) {
        /**
         * 0 处理特殊情况
         */
        if(order==null||order.length()==0)return new int[]{0,0};
        /**
         * 1 遍历字符数组，每轮处理一个方向的移动
         */
        char[] chars=order.toCharArray();
        int x=0,y=0;
        for(int i=0;i<chars.length;++i){
            //当前不为数字，表示该方向移动为1，可直接运算
            if(chars[i]<'0'||chars[i]>'9'){
                switch (chars[i]){
                    case 'W':++y;break;
                    case 'w':++y;break;
                    case 'S':--y;break;
                    case 's':--y;break;
                    case 'A':--x;break;
                    case 'a':--x;break;
                    case 'D':++x;break;
                    case 'd':++x;break;
                }
            }
            //当前为数字
            else {
                //取出连续的数字
                int j=i,num=0;
                while(j<chars.length&&chars[j]>='0'&&chars[j]<='9')++j;
                if(j>i){
                    num=Integer.parseInt(order.substring(i,j));
                }
                i=j;
                switch (chars[i]){
                    case 'W':y+=num;break;
                    case 'w':y+=num;break;
                    case 'S':y-=num;break;
                    case 's':y-=num;break;
                    case 'A':x-=num;break;
                    case 'a':x-=num;break;
                    case 'D':x+=num;break;
                    case 'd':x+=num;break;
                }
            }
        }
        return new int[]{x,y};
    }

    public static void main(String[] args) {
        for(int i:GetEndPoint("2wwww1dddD")){//坑爹之处在于大小写可能都有，但题目没说
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

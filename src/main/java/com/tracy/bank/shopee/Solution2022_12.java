package com.tracy.bank.shopee;

/**
 * @author tracy
 *
 * 2022-12 岛屿计算：
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 输入：
 * grid = [
 *           ["1","1","1","1","0"],
 *           ["1","1","0","1","0"],
 *           ["1","1","0","0","0"],
 *           ["0","0","0","0","0"]
 *         ]
 *
 * 输出：1
 *
 * 输入例子1:
 * [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
 *
 * 输出例子1:
 * 1
 */
public class Solution2022_12 {
    public static int numIslands (String[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)return 0;

        int ans=0;
        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if("1".equals(grid[i][j])){
                    dfs(grid,i,j);
                    ++ans;
                }
            }
        }
        return ans;
    }
    public static void dfs(String[][] grid,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||"0".equals(grid[i][j]))return;
        grid[i][j]="0";
        dfs(grid,i,j+1);
        dfs(grid,i+1,j);
    }

    public static void main(String[] args) {
        String[][] grid=new String[][]{
                {"1","1","1","1","0"},
                {"1","1","0","1","0"},
                {"1","1","0","0","0"},
                {"0","0","0","0","1"}
        };
        System.out.println(numIslands(grid));
    }
}

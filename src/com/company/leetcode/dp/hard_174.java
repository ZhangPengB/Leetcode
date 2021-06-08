package com.company.leetcode.dp;

import java.util.Arrays;

/*
 * dp[i][j]表示进入房间之前的能量值
 * 初始化:dp[m+1][j]=1  dp[i][n+1]=1 正向进入公主房间后，出来的能量值必须大于等于1
 * 返回值：由dp[i][j]定义可知，返回值dp[0][0]表示初始能量值，此时还没进入房间
 * */
public class hard_174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i=0;i<=m;i++)
        {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

//        for (int i = 0; i < m + 1; i++) {
//            dp[i][n + 1] = Integer.MAX_VALUE;  //最右边一列
//        }
        dp[m-1][n]=1;

//        for (int j = 0; j < n + 1; j++) {
//            dp[m + 1][j] = Integer.MAX_VALUE;   //最底下一行
//        }
        dp[m][n-1]=1;


        for (int i=m-1;i>=0;i--)
        {
            for (int j=n-1;j>=0;j--)
            {
                int minn=Math.min(dp[i+1][j],dp[i][j+1]);
                dp[i][j]=Math.max(minn-dungeon[i][j],1);  //进入房间之前能量值必须大于等于1，这里减去房间中得能量值，表示进入房间之前的能量值，否则不能存活，因此取两者最大值
            }
        }
        return dp[0][0];
    }

}

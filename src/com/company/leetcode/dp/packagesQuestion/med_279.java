package com.company.leetcode.dp.packagesQuestion;

/*
* 完全背包问题，元素可以无限使用
* dp[i]表示组成完全平方和为i时的最少个数，dp[0]初始化为0，题目种要求在（1，4，9...种选）
*
* */

public class med_279 {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for (int i=1;i<n+1;i++)  //从1开始，dp[0]初始化为0
        {
            dp[i]=Integer.MAX_VALUE;
        }
        for (int i=1;i<=n;i++)  //遍历背包
        {
            for (int j=1;j*j<=i;j++)  //遍历物品，物品必须满足j*j<=i
            {
                if (i-j*j>=0)
                {
                    dp[i]=Math.min(dp[i-j*j]+1,dp[i]);
                }
            }
        }
         return dp[n];
    }
}

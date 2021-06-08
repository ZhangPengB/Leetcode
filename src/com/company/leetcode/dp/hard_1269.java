package com.company.leetcode.dp;

public class hard_1269 {
    //
    public int numWays(int steps, int arrLen) {
        //dp[i][j]表示经过i步操作后，指针停在j位置处的方案数
        int[][] dp=new int[steps][arrLen];

        //初始化
        for(int i=0;i<steps;i++)
        {
            dp[i][0]=1;
        }
        for (int j=1;j<arrLen;j++)
        {
            dp[0][j]=0;
        }

        for (int i=1;i<steps;i++)
        {
            for (int j=1;j<arrLen-1;j++)
            {
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1]+dp[i-1][j];
            }
        }
        return dp[steps-1][0];
    }
}

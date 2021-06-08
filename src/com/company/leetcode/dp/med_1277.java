package com.company.leetcode.dp;

import java.util.Arrays;

public class med_1277 {
    //dp[i][j]表示以matrix[i][j]为右下角的最大边长，dp[i][j]为几，就包含几个以matrix[i][j]为右下角的正方形，将dp[i][j]中不为0的值相加即可得到结果
    public int countSquares(int[][] matrix) {
        int m= matrix.length;;
        int n=matrix[0].length;

        int[][] dp=new int[m][n];
        int result=0;
        for (int i=0;i<m;i++)
        {
            for (int j=0;j<n;j++)
            {
                if (matrix[i][j]=='1')
                {
                    if (i==0 || j==0)
                    {
                        dp[i][j]=1;
                    }
                    else
                    {
                        dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                    }
                }
                result+=dp[i][j];
            }
        }
        return result;
    }
}

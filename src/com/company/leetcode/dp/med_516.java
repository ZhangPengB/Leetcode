package com.company.leetcode.dp;

//给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
public class med_516 {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        //dp[i][j]表示以i开始，j结尾的最长子序列
        int[][] dp=new int[n][n];
        //初始化,对角线以下的默认初始化为0，因为i>j,此时不可能构成字符串，更不可能是回文子序列，对角线初始化为1，因为当i=j时，回文子序列长度为1
        for (int i=0;i<n;i++)
        {
            dp[i][i]=1;
        }

        //递推公式：dp[i][j]=dp[i+1][j-1]+2;  dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
        //遍历顺序：由递推公式知道，只能从后至前，从下往上
        for (int i=n-1;i>=0;i--)
        {
            for (int j=i+1;j<n;j++)  //只需求上对角元素值即可
            {
                if (s.charAt(i)==s.charAt(j))
                {
                    dp[i][j]=dp[i+1][j-1]+2;
                }
                else
                {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]); //不相等时，取左右元素加入序列时的最大
                }
            }
        }
        return dp[0][n];
    }
}

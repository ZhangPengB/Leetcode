package com.company.leetcode.dp.packagesQuestion;

public class med_474 {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp=new int[m+1][n+1];
        for (String str:strs)
        {
            //统计str中0和1的个数
            int zerosNum=0;
            int oneNum=0;
            for (int i=0;i<str.length();i++)
            {
                if (str.charAt(i)=='0')
                {
                    zerosNum++;
                }
                else oneNum++;
            }

            //背包遍历,且从后向前
            for (int i=m;i>=zerosNum;i--)
            {
                for (int j=n;j>=oneNum;j--)
                {
                    dp[i][j]=Math.max(dp[i][j],dp[i-zerosNum][j-oneNum]+1);
                }
            }
        }
        return dp[m][n];
    }
}

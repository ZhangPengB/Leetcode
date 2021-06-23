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


    public int findMaxForm1(String[] strs, int m, int n)
    {
        int[][] dp=new int[m+1][n+1];
        //看不出初始化
        for (String str:strs)    //先遍历物品
        {
            int[] count=countZeroAndOne(str);
            int a=count[0],b=count[1];
            for (int i=m;i>=a;i--)
            {
                for (int j=n;j>=b;j--)
                {
                    dp[i][j]=Math.max(dp[i][j],dp[i-a][j-b]+1);
                }
            }
        }
        return dp[m][n];
    }

    //统计字符串中0 和 1 的个数
    public int[] countZeroAndOne(String str)
    {
        int[] count=new int[2];
        for (int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if (c=='0')
            {
                count[0]++;
            }
            else
            {
                count[1]++;
            }
        }
        return count;
    }
}

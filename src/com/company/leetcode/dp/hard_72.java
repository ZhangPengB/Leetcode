package com.company.leetcode.dp;

public class hard_72 {
    public static int minDistance(String word1, String word2) {
        if (word1.length()==0) return word2.length();
        if (word2.length()==0) return word1.length();

        int[][] dp=new int[word1.length()+1][word2.length()+1];
        System.out.println(dp.length+"--"+dp[0].length);

        //初始化
        for(int i=0;i<=word1.length();i++) dp[i][0]=i;
        for (int j=0;j<=word2.length();j++) dp[0][j]=j;


        for (int i=1;i<=word1.length();i++)
        {
            for (int j=1;j<=word2.length();j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1="distance";
        String word2="springbok";
        System.out.println(minDistance(word1,word2));
    }
}

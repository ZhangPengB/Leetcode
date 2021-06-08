package com.company.leetcode.dp;


//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
public class med_221 {
    /*
     * 动态规划
     * 下标含义：（1）dp[i][j]表示以matrix[i-1,j-1]为正方形右下角的最大边长，当matrix[i-1][j-1]为‘1’时，以该位置元素可以构成正方形（最起码可以构成边长为1的正方形），
     * 当matrix[i-1][j-1]不是1 时，以该元素为右下角不可能构成正方形，dp[i][j]=0.当可以构成正方形时，dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
     * 解释上述递推公式：当matrix[i][j]是1时，要使构成的正方形尽可能地大，需要往左边和上边找，同时也需要往左上角找，比如往左边找时，最大边长为3，往上边找时，最大边长为1，往左上角找时，最大变长为2，
     * 那么dp[i][j]只能取三者最小值才可能构成正方形，否则无法构成
     *
     * 解释上面（1）：由递推公式可以看出，dp[i][j]与左上角，左边和上边值相关，考虑matrix第一行和第一列，由于无法确定第一行上边和左上角值，无法确定第一列左边和左上角值，因此定义dp[i][j]为以matrix[i-1][j-1]为右下角值
     * 相当于给matrix第一行上面添加一行，在第一列前面添加一列，并初始化dp值为0
     *
     * */
    //通过！！！！！！！
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int[][] dp=new int[m+1][n+1];
        int maxEdge=0;
        for (int i=1;i<m+1;i++)
        {
            for (int j=1;j<n+1;j++)
            {
                if (matrix[i-1][j-1]=='1')
                {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
                else //不等于1时，可有可无，因为dp初始化本来就是0
                {
                    dp[i][j]=0;
                }
                maxEdge=Math.max(dp[i][j],maxEdge);
            }
        }

        //打印dp,方便核对
        for (int i=0;i<m+1;i++)
        {
            for (int j=0;j<n+1;j++)
            {
                System.out.print(dp[i][j]+"-");
            }
            System.out.println();
        }

        return maxEdge*maxEdge;
    }


    //动态规划2：dp[i][j]表示以matrix[i][j]为正方形右下角的最大边长
    public int maximalSquare1(char[][] matrix) {
        int m= matrix.length;
        int n=matrix[0].length;

        int[][] dp=new int[m][n];
        int maxEdge=0;
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
                        dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    }
                }
                maxEdge=Math.max(maxEdge,dp[i][j]);
            }
        }
        return maxEdge*maxEdge;
    }
}

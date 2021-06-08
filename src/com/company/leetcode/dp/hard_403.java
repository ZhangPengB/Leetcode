package com.company.leetcode.dp;

/*
* 动态规划解决
* 确定dp下标及其含义:dp[i][k](k只有三个状态，k-1,k,k+1)表示青蛙能否从上一个石头跳k步到达石头i，如果可以值为true，否则为false
* 递推公式：dp[i][k]=dp[j][k-1] || dp[j][k] || dp[j][k+1] 之间是或的关系，这里的j!=i-1,因为跳到第i个s石头不一定从i-1个石头跳，也有可能从i-2甚至i-3等其他石头跳，所以这里表示为j
* 且k=stones[i]-stones[j]
* 初始化：dp[0][0]=true;dp[1][1]=true，dp[1][0]=false,dp[1][2]=false
* 遍历方向及遍历次数：青蛙一直往前跳，所以遍历方向肯定是从头至尾，两层循环，外层遍历石头，内层遍历跳的步数的状态（0，1，2）0表示跳k-1步，1表示跳k步，2表示跳k+1步
* 返回值：dp[len-1][]
*
*
* 青蛙从0开始跳，第一步跳1步，当跳了n步后，第n+1次跳时，最多只能跳n+1步，最少跳1步（每次都跳一步），每跳一步，石头编号增加1，所以石头编号肯定>=跳的步数
*
* 青蛙现在所处的石头编号为i,上一步跳的距离为k，k必须满足k<=i,理由如下：
*       青蛙位于第0个石头上时，青蛙的上一次跳跃距离限定为0，之后每次跳跃，青蛙所在的石头编号至少增加1，而每次跳跃距离至多增加1.
*       青蛙跳m次后，青蛙现在所处的编号i>=m,上一步跳跃的距离m>=k,因此i>=m
*       我们可以两层循环，从后向前枚举，上一步所在的石头编号为j，当上一步跳跃距离超过了j+1时，我们停止跳跃，因为在第i个石头上至多只能跳出j+1的距离
* */

public class hard_403 {
    public boolean canCross(int[] stones) {
        int len=stones.length;
        if(stones[1]>1) return false;  //根据题意，stones[0]=0且第一步只能跳一个单元格，所以当stones[1]>1时肯定不能跳到，返回false
        boolean[][] dp=new boolean[len][3];
        dp[0][0]=dp[1][1]=true;
        dp[1][0]=dp[1][2]=false;  //跳0步或者跳2步均不能到达第2块石头

        for (int i=1;i<len;i++)
        {
            if (stones[i]-stones[i-1]>i)  //跳的步数>石头编号，每次都跳最大距离时的序列为[0,1,3,6,10,15,21...]
            {
                return false;
            }
        }

        for(int i=1;i<stones.length;i++)
        {
            for (int j=i-1;j>=0;j--)  //从当前要跳的石头向前遍历
            {
                int k=stones[i]-stones[j];  //到当前石头要跳的距离

                if (k>j+1) break;  //青蛙从0开始跳，第一步跳1步到达石头1（编号为1）以后每跳一步，石头编号至少增加1（可以从石头1一下子跳2步到石头3），而每次跳跃距离至多增加1

                dp[i][k]=dp[j][k-1] || dp[j][k] || dp[j][k+1];

                if (i==len-1 && dp[i][k])
                {
                    return true;
                }
            }
        }
        return false;
    }
}

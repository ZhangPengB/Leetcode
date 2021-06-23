package com.company.leetcode.dp.packagesQuestion;


public class easy_70 {
    /*
    * 题目描述：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    * 解析：完全的斐波那契数列问题，普通动态规划来解决即可
    * */
    public int climbStairs(int n)
    {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;i++)
        {
            dp[n]=dp[n-1]+dp[n-2];
        }
        return dp[n];
    }


/*
* 题目描述：将上面的爬1步或者爬2步改为每步可以爬1~m步，求爬到台阶为n的方法总数
* 此时该问题即为一个完全背包问题
* 1-m每步可爬的台阶即为物品，n为背包容量，因每步可爬1-m中的任一一步，且1-m可不限次数重复选取，所以这是完全背包问题，爬的方法是一个排列问题
* dp[i]表示爬台阶为i的方法总数
* 遍历顺序：外层背包，内层物品
* 递推公式：dp[i]+=dp[i-j];
* */

    public int climbStairs_m(int n,int m)
    {
        int[] dp=new int[n+1];
        dp[0]=1;
        for (int i=1;i<=n;i++)  //遍历背包（目标）
        {
            for (int j=1;j<=m;j++) //遍历物品（步数）
            {
                if (i-j>=0)
                {
                    dp[i]+=dp[i-j];
                }
            }
        }
        return dp[n];
    }

    //如果将上述的m改成2，那么就是该斐波那契数列爬楼梯案例！！！
}

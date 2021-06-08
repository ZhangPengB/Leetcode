package com.company.leetcode.dp.packagesQuestion;

/*
 * 题目描述：给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *         你可以认为每种硬币的数量是无限的。
 *
 * 动态规划———完全背包解决
 * 因为钱币可以无限次使用，所以为完全背包问题
 * dp[j]表示组成钱币总数为j的最小钱币数量
 * 确定递推公式:不考虑coins[i],dp[j]只与dp[j-coins[i]]有关，求出dp[j-coins[i]]总数，加上1即为考虑coins[i]时的最少钱币数量，所以dp[i]=min(dp[j-coins[i]],dp[j])
 *初始化：dp[0]=0,因为求最小，dp[i]可初始化为正无穷
 * 确定遍历顺序：两层循环，这里背包为amount,物品为coins[i],物品可以无限次利用，比如[1,5,5]和[5,5,1]表示同一种结果,与顺序无关，可以看成是一个组合问题，背包外层，物品内层
 * */

public class med_322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        System.out.println(dp[2]);
        dp[0] = 0;
        for (int i = 0; i < amount; i++)   //遍历背包
        {
            for (int j = 0; j < coins.length; j++)  //遍历物品
            {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i - coins[j]], dp[i]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}

package com.company.leetcode.dp.packagesQuestion;

//硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
public class med_8_11 {
    //完全背包问题：因为每个硬币使用个数不限，将硬币看作物品，待计算的n的表示法看成背包容量，因此该问题看成是完全背包问题
    // 定义dp[i]表示凑成n分的表示方法，当装入币值coin时，可恰好将该背包装满，那么装入coin之前的方法为dp[n-nums[i0]],因此将所有的dp[n-nums[i]]累加即可得到装满该背包的方法数
    // 因此递推公式为：dp[n]+=dp[n-nums[i]]
    //由递推公式可知，求dp[n]值与之前的值有关，所以当dp[1]+=dp[1-1]=1，因此可初始化dp[0]=1,装满背包容量为1 的背包只存在一种使用物品质量为1的一种情况，初始化dp长度为n+1
    //该问题为组合问题[1,5]和[5,1]属于同一种情况，因此先遍历物品，再遍历背包（用物品去装背包）
    public int waysToChange(int n) {
        int[] dp=new int[n+1];
        int[] nums={1,5,10,25};
        dp[0]=1;
        for (int num:nums)  //遍历物品
        {
            for (int j=num;j<=n;j++)    //遍历背包,用每一件物品去装背包
            {
                dp[j]+=dp[j-num];
                dp[j]%=1000000007;
            }
        }
        for (int coin:nums) System.out.print(coin+"--");
        return dp[n];
    }
}

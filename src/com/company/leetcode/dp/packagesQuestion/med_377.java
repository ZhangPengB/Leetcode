package com.company.leetcode.dp.packagesQuestion;

public class med_377 {
    //完全背包的排列总数
    //因为是排列问题，与物品的顺序有关，所以物品遍历是内层，背包遍历是外层，且物品可重复使用，所以从前至后
    //递推公式：求排列组合总数：dp[j]+=dp[j-nums[i]]  j为背包容量，当1<=i<=target时，如果存在一种排列，使得和为i，那么对于其中的一个元素num（num<=i),对于元素之和为i-num的每一种排列，
    // 再其后面加上num之后即可得到一个元素之和为i的排列，因此再计算dp[i]之前，应该先计算所有的dp[i-num]之和
    //dp[0]=1; dp[1]=dp[0]=1; dp[2]=dp[1]+dp[0]; dp[3]=dp[2]+dp[1]+dp[0];...
     public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;    //只有当不选取任何元素的时候，元素之和才是0，因此初始化为1
        for (int i=0;i<=target;i++)  //遍历背包
        {
            for (int j=0;j<nums.length;j++)  //遍历物品，从前之后
            {
                if(i-nums[j]>=0)
                {
                    dp[i]+=dp[i-nums[j]];   //排列总数
                }
            }
        }
        return dp[target];
    }
}

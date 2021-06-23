package com.company.leetcode.dp.packagesQuestion;

//题目描述：给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

import java.text.DecimalFormat;
import java.util.Arrays;

public class med_416 {
    public boolean canPartition1(int[] nums) {
        int sum= Arrays.stream(nums).sum();
        Arrays.sort(nums);
        DecimalFormat df=new DecimalFormat("0.0");
        String a=df.format((float)sum/2);
        double target=Double.parseDouble(a);
        System.out.println(target);
        double count=0;
        for(int e:nums)
        {
            count+=e;
            if (count==target) return true;
            if (count>target) return false;
        }
        return false;
    }


    //0-1背包问题，在数组中找出一些数，使这些数之和恰好等于sum/2,转为背包问题即：背包容量为sum/2,物品的重量和价格均为数组中的数值，找出一些物品使其恰好装满这个sum/2的背包
//    dp[j]:表示容量为j时所装的物品重量 该题中dp[j]==j时才能满足题意
    public boolean canPartition(int[] nums)
    {
        int sum=Arrays.stream(nums).sum();
        if (sum%2==1) return false;
        int target=sum/2;
        int[] dp=new int[sum];
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
                if (dp[j] == target) return true;
            }
        }
        return false;
    }

    public boolean canPartition2(int[] arr)
    {
        int n=arr.length;
        int sum=0;
        int maxNum=0;
        for (int e:arr)
        {
            maxNum=Integer.max(maxNum,e);
            sum+=e;
        }
        if (sum%2==1) return false;
        int target=sum/2;  //背包容量
        if (maxNum>target) return  false;
        int[] dp=new int[target+1];
        //遍历物品
        for (int k : arr) {
            for (int j = target; j >= k; j--)  //遍历背包
            {
                dp[j] = Integer.max(dp[j], dp[j - k] + k);
            }
        }
        return dp[target] == target;
    }
}

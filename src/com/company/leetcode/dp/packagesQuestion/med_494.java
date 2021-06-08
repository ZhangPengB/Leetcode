package com.company.leetcode.dp.packagesQuestion;

import java.util.Arrays;
import java.util.Vector;


/*
* 0-1背包问题：既然是target，那么就一定有left组合-right组合=target；left+right=sum,sum值是固定的
* */
public class med_494 {
//    private int count=0;
    private Vector<Vector<Integer>> result;
    private Vector<Integer> path;

    public void backtracking(int[] nums,int target,int cursum,int startIndex)
    {
        //递归终止
        if (cursum==target)
        {
//            System.out.println("count:"+count);
//            count+=1;
            result.add(path);
            return ;
        }

        //单层
        for (int i=startIndex;i<nums.length && cursum+nums[i]<=target;i++)
        {
            cursum+=nums[i];
            path.add(nums[i]);
            backtracking(nums,target,cursum,i+1);
            path.removeElementAt(path.size()-1);
            cursum-=nums[i];
        }
    }

    public int findTargetSumWays1(int[] nums, int target) {
        int sum= Arrays.stream(nums).sum();
        if (target>sum) return 0;
        if ((target + sum) % 2==1) return 0;
        int bagSize=(target+sum)/2;   //转为求目标和
        backtracking(nums,bagSize,0,0);
        return result.size();
    }


    /*0-1背包来解决
     数组中所有相加元素之和为x,数组之和为sum,所有相减元素之和为sum-x,目标和为target，所以x-(sum-target)=target->x=(sum+target)/2
     因此当上式中不能整除时，即不能存在解，到这里，即将求target转为求元素和为x的方法个数
     0-1背包问题包含左右两部分，此时的left为元素相加和，right为元素相减和


     本题中，若看成0-1背包问题的话，此时的dp[j]表示装满容量为j的背包，有几种方法,而原始的背包问题是容量为j的背包最多能装多少。即是一个将数组元素放入背包的组合问题
     确定递推公式：dp[j]=dp[j]+dp[j-nums[i]]
     */
    public int findTargetSumWays(int[] nums, int target)
    {
        int sum= Arrays.stream(nums).sum();
        if (target>sum) return 0;
        if ((target + sum) % 2==1) return 0;
        int bagSize=(target+sum)/2;   //转为求目标和，两个int值相加，可能存在溢出的可能（本题没有）
        int[] dp=new int[bagSize+1];
        dp[0]=1;
        for (int i=0;i<nums.length;i++)
        {
            for (int j=bagSize;j>=nums[i];j--)
            {
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[bagSize];
    }
}

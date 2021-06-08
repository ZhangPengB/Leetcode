package com.company.leetcode.doublePoint;

import java.util.Arrays;

public class med_16 {
    //双指针+排序：通过
    public static int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);

        int close=Integer.MAX_VALUE;   //表示接近程度，当和与target差的绝对值小于close时，更新close
        int result=0;
        for (int i=0;i<n-2;i++)
        {
            // 保证和上一次枚举的元素不相等，值相同时，枚举下一个值
            if (i>0 && nums[i]==nums[i-1]) continue;
            int left=i+1,right=n-1;
            while(left<right)
            {
                int sum=nums[i]+nums[left]+nums[right];
//                if (sum==target) return sum;
                System.out.print(sum+" ");
                System.out.println(close);
                if (Math.abs(sum-target)<close)  //当当前和更接近目标和时
                {
                    close=Math.abs(sum-target);  //更新接近程度
                    result=sum;  //更新结果值

                }
                //更新指针位置
                //当前和小于目标和时，左指针右移，寻找的下一个元素要与上一个元素不相同
                if(sum<target)
                {
                    while (left<right && nums[left]==nums[left+1])
                    {
                        left++;
                    }
                    left++;
                }
                else if(sum>target)  //当前和大于目标和，右指针左移，寻找下一个与上一个元素不相同的值
                {
                    while (left<right && nums[right]==nums[right-1])
                    {
                        right--;
                    }
                    right--;
                }
                else return result;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums={0,2,1,-3};
        int target=1;
        System.out.println(threeSumClosest(nums,target));
    }
}

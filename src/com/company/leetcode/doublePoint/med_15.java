package com.company.leetcode.doublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class med_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        if (nums==null || n<3)
        {
            return result;
        }
        //双指针来解决
        for (int i=0;i<n-2;i++)
        {
            if (nums[i]>0) break;  //第一个数大于0，后面的数都比它大，不成立
            if (i>0 && nums[i]==nums[i-1])  //去重
            {
                continue;
            }
            if (nums[i]+nums[i+1]+nums[i+2]>0)   //去重，连续三个数相加大于0
            {
                break;
            }
            if (nums[i]+nums[n-2]+nums[n-1]<0)  //去重
            {
                continue;
            }
            int left=i+1,right=n-1;
            while(left<right)
            {
                int sum=nums[i]+nums[left]+nums[right];
                if (sum==0)
                {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //加入当前结果后，指针还需移动：left向右移，right向左移，但是指向的值不能和上一个相同
                    while(left<right && nums[left]==nums[left+1])
                    {
                        left++;
                    }
                    left++;
                    while(left<right && nums[right]==nums[right-1])
                    {
                        right--;
                    }
                    right--;
                }
                else if (sum<0)
                {
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }
        return result;
    }
}

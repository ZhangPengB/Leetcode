package com.company.leetcode.doublePoint;

public class med_80 {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        if (n<=2) return n;
        int left=2,right=2;
        while(right<n)
        {
            if(nums[right]!=nums[left-2])  //相等时，说明重复个数大于2
            {
                nums[left++]=nums[right];
            }
            right++;
        }
        return left;
    }
}

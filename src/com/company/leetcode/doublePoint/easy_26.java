package com.company.leetcode.doublePoint;

public class easy_26 {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        if (n<1) return 0;
        if (n==1) return 1;
        int result=1;
        //将不重复的元素移动到数组左侧
        int left=1,right=1;
        while(right<n)
        {
            if (nums[right]!=nums[right-1])
            {
                nums[left++]=nums[right];
                result++;
            }
            right++;
        }
        return result;
    }
}

package com.company.leetcode.doublePoint;

public class easy_27 {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int left=0,right=0;
        int result=0;
        while(right<n)
        {
            if (nums[right]!=val)
            {
                nums[left++]=nums[right];
                result++;
            }
            right++;
        }
        return result;
    }


    public int removeElement1(int[] nums,int val)
    {
        int n=nums.length;
        int left=0;
        for (int i=0;i<n;i++)
        {
            if (nums[i]!=val)
            {
                nums[left++]=nums[i];
            }
        }
        return left;
    }

    //交换元素方法，将val值移到数组末尾
    public int removeElement2(int[] nums,int val)
    {
        int n=nums.length;
        int left=0;
        for (int i=0;i<n;i++)
        {
            if(nums[i]!=val)
            {
                int tmp=nums[i];
                nums[i]=nums[left];
                nums[left++]=tmp;
            }
        }
        return left;
    }
}

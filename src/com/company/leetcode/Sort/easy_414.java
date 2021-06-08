package com.company.leetcode.Sort;

import java.util.HashSet;
import java.util.Set;

public class easy_414 {
    public int thirdMax(int[] nums) {
        int n=nums.length;
        quickSort(nums,0,n-1);
        int max=0;
        Set<Integer> S=new HashSet<>();
        for (int i=n-1;i>=0;i--)
        {
            max=Math.max(max,nums[i]);
            if (!S.contains(nums[i]))
            {
                S.add(nums[i]);
            }
            if(S.size()==3)
            {
                return nums[i];
            }
        }
        return max;
    }

    //基准元素位置
    public int getStandard(int[] nums,int l,int r)
    {
        int base=nums[l];
        while(l<r)
        {
            //基准元素选的是左边元素，所以从右边向左遍历找小于基准元素的值
            while(l<r && nums[r]>=base)
            {
                r--;
            }
            if (l<r)
            {
                nums[r]=nums[l];
            }
            //从左边向右遍历找第一个大于基准元素的值
            while(l<r && nums[l]<=base)
            {
                l++;
            }
            if (l<r)
            {
                nums[l]=nums[r];
            }
        }
        nums[l]=base;
        return l;
    }



    //快速选择排序算法
    public void quickSort(int[] nums,int l,int r)
    {
        if (l<r)
        {
            int q=getStandard(nums,l,r);
            quickSort(nums,l,q-1);
            quickSort(nums,q+1,r);
        }
    }


    public int quickSelect(int[] nums,int l,int r,int index)
    {
        int q=getStandard(nums,l,r);
        if (q==index) return nums[q];
        else
        {
            return q<index?quickSelect(nums,q,r,index):quickSelect(nums,l,q-1,index);
        }
    }


    public int thirdMax1(int[] nums) {
        //一次遍历，寻找最大值，次大值和第三大值
        int n=nums.length;
        float high=Float.MIN_VALUE,med=Float.MIN_VALUE,low=Float.MIN_VALUE;
        float max=Float.MIN_VALUE;
        for (int e:nums)
        {
            max=Math.max(max,e);
            if (e>high)
            {
                low=med;
                med=high;
                high=e;
            }
            else if(e>med && e!=high)
            {
                low=med;
                med=e;
            }
            else if (e>low && e!=med && e!=high)
            {
                low=e;
            }
        }
        return low==Float.MIN_VALUE?(int)max:(int)low;
    }
}

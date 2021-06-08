package com.company.leetcode.doublePoint;

import java.util.Arrays;

public class med_324 {
    //排序+穿插 通过
    public void wiggleSort(int[] nums) {
        int n=nums.length;
        if(n<=1) return;
        int[] tmp=Arrays.copyOf(nums,nums.length);
        Arrays.sort(tmp);
        //逆序交叉插入，可以将大值组和小值组中相等数分开
        int index=n-1;
        //插入大值
        int big=1;
        while(big<n)
        {
            nums[big]=tmp[index--];
            big+=2;
        }
        //插入小值
        int small=0;
        while (small<n)
        {
            nums[small]=tmp[index--];
            small+=2;
        }
    }

    //对上面的逆序加深理解，通过
    public void wiggleSort2(int[] nums) {
        int n=nums.length;
        if(n<=1) return;
        int[] tmp=Arrays.copyOf(nums,nums.length);
        Arrays.sort(tmp);
        //逆序交叉插入，可以将大值组和小值组中相等数分开
        int index=0;
        if (n%2==1)
        {
            index=n/2;  //奇数时
        }
        else
        {
            index=n/2-1;  //偶数时，索引为-1时的值
        }

        //先逆序插入小值
        int small=0;
        while (small<n)
        {
            nums[small]=tmp[index--];
            small+=2;
        }

        //再逆序插入大值
        int len=n-1;
        int big=1;
        while(big<n)
        {
            nums[big]=tmp[len--];
            big+=2;
        }
    }

    //桶排序
    public void wiggleSort1(int[] nums)
    {
        int n=nums.length;
        int[] bucket=new int[5001];
        for(int e:nums) bucket[e]++;
        //穿插
        //插入大值
        int index=5000;
        int big=1;
        while(big<n)
        {
            while(bucket[index]==0)
            {
                index--;
            }
            nums[big]=index;
            bucket[index]--;
            big+=2;
        }

        //插入小值
        int small=0;
        while(small<n)
        {
            while(bucket[index]==0)
            {
                index--;
            }
            nums[small]=index;
            bucket[index]--;
            small+=2;
        }
    }
}

package com.company.leetcode.Sort;

public class med_75 {
    //冒泡排序
    //最坏：O（n^2)
    public void sortColors(int[] nums) {
        int n=nums.length;
        for (int i=0;i<n-1;i++)
        {
            for (int j=0;j<n-1-i;j++)
            {
                if (nums[j]>nums[j+1])
                {
                    int tmp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }
    }

    public static void sortColors2(int[] nums)
    {
        int ptr=0;
        //将0交换到头部
        for (int i=0;i<nums.length;i++)
        {
            if (nums[i]==0)
            {
                int tmp=nums[i];
                nums[i]=nums[ptr];
                nums[ptr++]=tmp;
            }
        }

        //再将1放到0后面
        for (int i=ptr;i<nums.length;i++)
        {
            if (nums[i]==1)
            {
                int tmp=nums[i];
                nums[i]=nums[ptr];
                nums[ptr++]=tmp;
            }
        }
    }



    public static void sortColors1(int[] nums)
    {
        int num0 = 0, num1 = 0, num2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[num2++] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            }else if(nums[i] == 1) {
                nums[num2++] = 2;
                nums[num1++] = 1;
            }else {
                nums[num2++] = 2;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums={1,0,2,1,2,1,0,0};
        sortColors2(nums);
        for (int e:nums)
        {
            System.out.print(e+" ");
        }
    }

}

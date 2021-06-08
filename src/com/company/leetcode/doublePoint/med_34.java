package com.company.leetcode.doublePoint;

public class med_34 {
    public static int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int[] result={-1,-1};
        if (n<1) return result;
        int index=0;
        //找开始位置
        for (int i=0;i<n;i++)
        {
            if (i==0 && nums[i]==target)
            {
                result[0]=i;
                break;
            }
            if (i>0)
            {
                if (nums[i-1]!=target && nums[i]==target)
                {
                    result[0]=i;
                }
            }
        }
        //找结束位置
        for (int i=n-1;i>=0;i--)
        {
            if (i==n-1 && nums[i]==target)
            {
                result[1]=i;
                break;
            }
            if(i<n-1)
            {
                if (nums[i]==target && nums[i+1]!=target)
                {
                    result[1]=i;
                }
            }
        }
        return result;
    }



    //结束位置只需要找大于target处的索引，然后减一
    //开始位置找等于target的索引
//    public static int[] searchRange1(int[] nums, int target)
//    {
//        int left=binarySearch(nums,target,true);
//        int right=binarySearch(nums,target,false);
//    }

    /*
    * lower为true:表示找起始位置
    * 为false：表示找结束位置
    * */
//    public static int binarySearch(int[] nums,int target,boolean lower)
//    {
//        int n=nums.length;
//        int left=0,right=n-1;
//        if (lower)
//        {
//            //找
//        }
//        while(left<right)
//        {
//            int mid=(right+left)/2;
//            if (lower && nums[mid]>=target)  //target在左边数组
//            {
//                right=mid-1;
//            }
//            else  //target在右边数组
//            {
//                left=mid+1;
//            }
//        }
//        return
//    }

    public static void main(String[] args) {
        int[] nums={};
        int target=8;
        int[] result=searchRange(nums,target);
        for (int e:result)
        {
            System.out.print(e+" ");
        }
    }
}

package com.company.leetcode.Sort;

import java.util.Arrays;
import java.util.Random;

//public class med_215 {
//    public int findKthLargest(int[] nums,int k)
//    {
//        Arrays.sort(nums);
//        int n=nums.length;
//        return nums[n-k];
//    }
//}




class Solution {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}


class quickSort
{
    //单趟排序
    public int singlePass(int[] arr,int l, int r)
    {
        //基准数据
        int key=arr[l];
        while(l<r)
        {
            //从右边找第一个小于基准元素的值
            while(l<r && arr[r]>=key)
            {
                r--;
            }
            if (l<r)
            {
                arr[l]=arr[r];  //找到后，因为元素值是小于key值的，所以移到key值左边
            }
            //从左边找第一个大于基准元素的数值
            while(l<r && arr[l]<=key)
            {
                l++;
            }
            if (l<r)
            {
                arr[r]=arr[l];  //找到后，因为元素是大于key值的，所以移到key值后面
            }
        }
        //循环结束时，l==r，将key值赋给改位置（分割点）
        arr[l]=key;
        return l;
    }

    public void quickSort1(int[] arr,int l,int r)
    {
        if (l<r)
        {
            int standard=singlePass(arr,l,r);
            //左边排序
            quickSort1(arr,l,standard-1);
            //右边排序
            quickSort1(arr,standard+1,r);
        }
    }

    public int quickSelect(int[] arr,int l,int r,int index)
    {
        int standard=singlePass(arr,l,r);
        if (standard==index)
        {
            return arr[index];
        }
        else
        {
            return standard<index?quickSelect(arr,standard+1,r,index):quickSelect(arr,l,standard-1,index);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        return quickSelect(nums,0,n-1,n-k);
    }
}



public class Main
{
    public static void main(String[] args) {
        int[] arr={49,38,58,97,76,13,27,49};
        int n=arr.length;
        quickSort s=new quickSort();
        s.quickSort1(arr,0,n-1);
        for (int e:arr)
        {
            System.out.print(e+" ");
        }
    }
}




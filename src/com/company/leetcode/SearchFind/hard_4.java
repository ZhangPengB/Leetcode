package com.company.leetcode.SearchFind;

import java.util.Arrays;

public class hard_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 == 0) return medianNum(nums2);
        if (n2 == 0) return medianNum(nums1);
        int[] he = new int[n1 + n2];
        int l1 = 0, l2 = 0;
        int index = 0;
        while (index<n1+n2)
        {
            if ((l1 < n1 && l2 < n2))
            {
                if((l1 < n1 && l2 < n2) && nums1[l1] <= nums2[l2])
                {
                    he[index++] = nums1[l1++];
                }
                else
                {
                    he[index++] = nums2[l2++];
                }
            }
            System.out.println(index);
        }
        for (int e : he) {
            System.out.print(e);
        }
        return medianNum(he);
    }

    public static double medianNum(int[] nums) {
        if (nums.length % 2 == 1)  //奇数，直接返回中间值
        {
            return nums[nums.length / 2];
        }
        return (double) (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2;
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2)
    {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] all = new int[n1 + n2];
        for (int i=0;i<n1;i++)
        {
            all[i]=nums1[i];
        }
        for (int i=0;i<n2;i++)
        {
            all[i+n1]=nums2[i];
        }

        Arrays.sort(all);
        for (int e:all)
        {
            System.out.print(e+" ");
        }
        int len=all.length;
        if (len%2==1)
        {
            return all[len/2];
        }
        return (all[len/2-1]+all[len/2])/2.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays1(nums1,nums2));
    }
}


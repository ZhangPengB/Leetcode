package com.company.leetcode.shuxue.tanxin;

public class med_1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;
        for (int num : nums1) {
            sum1 += num;
        }
        for (int num : nums2) {
            sum2 += num;
        }


        if (sum1 == sum2) return 0;
        if (sum1 > sum2) return minOperations(nums2, nums1);

        int diff = sum2 - sum1;
        int[] freq = new int[6];  //存增量/减量个数，下标为索引值
        int res = 0;
        for (int num : nums1) {
            freq[6 - num]++;
        }
        for (int num : nums2) {
            freq[num - 1]++;
        }

        for (int i=0;i<freq.length;i++)
        {
            System.out.print(i+":"+freq[i]);
        }

        //贪心思想：从5开始，对应的是nums1可以最大程度递增量为5；nums2可以最大程度递减量为5
        for (int i = freq.length - 1; i >= 0; i--) {
            while (freq[i] > 0 && diff > 0) {
                res++;
                freq[i]--;
                diff -= i;
            }
        }
        return diff > 0 ? -1 : res;
    }
}

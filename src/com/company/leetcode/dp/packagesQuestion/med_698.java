package com.company.leetcode.dp.packagesQuestion;


//题目描述：给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。

import java.util.Arrays;
import java.util.Vector;

//没通过
public class med_698 {
    private static int count = 0;  //记录划分个数
    private static Vector<Vector<Integer>> result = new Vector<Vector<Integer>>();
    private static Vector<Integer> path = new Vector<>();


    private static boolean backTracking(int[] nums, int cursum, int target, int startIndex, boolean[] used) {
        //递归终止条件
//        if (k==0) return true;
//        if (cursum>target) return;
        if (cursum == target) {
            count += 1;
            return true;
        }

        //单层递归逻辑,
        for (int i = startIndex; i < nums.length; i++) {
            if (used[i] == false && cursum + nums[i] <= target)  //没被使用
            {
                cursum += nums[i];
                used[i] = true;
                if (backTracking(nums, cursum, target, i + 1, used)) {
                    backTracking(nums, 0, target, 0, used); //从树的最顶层重新开始遍历，used数组已经发生变化
                }
//                used[i]=false;
                cursum -= nums[i];  //能走到这里，如果上面if语句执行成功，则重新从头开始遍历，如果执行为false，
            }
        }
        return false;

    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {

        boolean[] used = new boolean[nums.length];  //全false,记录数组中的数是否被访问过

        int sum = Arrays.stream(nums).sum();  //数组之和

        if (sum % k != 0) return false;  //k个数组不能均分，无法满足要求，返回false
        int target = sum / k;

        backTracking(nums, 0, target, 0, used);

        System.out.println(count);
        if (k == count) return true;

        return false;
    }


    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2,2,2,2,2,2,2,2,2,3,3};
        int k = 8;
//        [1,1,1,1,1,1,1,1,1,1]
//        5
        System.out.println(canPartitionKSubsets(nums, k));
    }

}

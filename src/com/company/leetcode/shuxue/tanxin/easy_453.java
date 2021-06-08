package com.company.leetcode.shuxue.tanxin;

import java.util.Arrays;
import java.util.stream.IntStream;

public class easy_453 {
    public int minMoves(int[] nums) {
        int numSum = 0;
        int minItem = nums[0];
        for (int num : nums) {
            numSum += num;
            if (minItem > num) {
                minItem = num;
            }
        }
        return numSum - minItem * nums.length;
    }

    //此方法可能存在问题，数组和可能会非常大导致整数越界，为了避免此问题，可即时计算moves
    public int minMoves1(int[] nums) {
        int moves = 0, min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            moves += num - min;
        }
        return moves;
    }
}

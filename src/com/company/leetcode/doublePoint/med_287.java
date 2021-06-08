package com.company.leetcode.doublePoint;

import java.util.HashSet;
import java.util.Set;

public class med_287 {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}

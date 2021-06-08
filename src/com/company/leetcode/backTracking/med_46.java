package com.company.leetcode.backTracking;

import java.util.ArrayList;
import java.util.List;


//没通过
public class med_46 {
    private List<List<Integer>> result=new ArrayList<List<Integer>>();
    private List<Integer> path=new ArrayList<Integer>();

    private void backTracking(int[] nums, boolean[] used) {

        if (path.size() == nums.length) {
            result.add(path);
            return;
        }

        //单层递归
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTracking(nums, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];  //默认初始化为fasle
        backTracking(nums, used);
        return result;
    }
}

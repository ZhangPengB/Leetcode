package com.company.leetcode.backTracking;

import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;

//目前纠结于hashSet使用，暂没通过
public class med_491 {
    private List<List<Integer>> result;
    private List<Integer> path;

    private void backTracking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            result.add(path);
        }

        HashSet hs = new HashSet();
        //递归树横向遍历
        for (int i = startIndex; i < nums.length; i++) {
            if ((!path.isEmpty() && nums[i] < path.get(path.size() - 1))
                    || hs.contains(nums[i])) {
                continue;
            }
            hs.add(nums[i]);
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        result.clear();
        path.clear();
        backTracking(nums, 0);
        return result;
    }


    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add("hello world1!");
        System.out.println(hs.size());
        System.out.println(hs.contains("hello world1!"));
        Iterator<String> it = hs.iterator();
        System.out.println(it.next());
//        while (!hs.isEmpty()) {
//        }
    }

}



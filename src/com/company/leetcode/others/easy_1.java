package com.company.leetcode.others;


import java.util.HashMap;

public class easy_1 {
    private int[] result;

    //暴力解法
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
//                    result[0]=i;
//                    result[1]=j;
                }
            }
        }
        return new int[0];
    }

    //哈希表
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            //先判断target-nums[i]是否存在哈希表中，如果存在，加入哈希表，随后把当前元素加入哈希表
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


    public int[] twoSum2(int[] nums, int target) {
        HashMap hm = new HashMap();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                res[0] = (int) hm.get(target - nums[i]);
                res[1] = i;
            } else {
                hm.put(nums[i], i);
            }
        }
        return res;
    }


    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        System.out.println("adadf".charAt(0));
        int maxSubLength = 0;
        int tmplen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!hm.containsKey(c))   //不包含当前字符
            {
                hm.put(c, i);
                tmplen += 1;
            } else {
                maxSubLength = Math.max(maxSubLength, tmplen);
                tmplen = 1;  //初始为1，表示当前字符长度
                hm.clear();  //哈希Map清空
                hm.put(c, i);  //把当前字符加入
            }
        }
        return maxSubLength;
    }
}

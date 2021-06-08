package com.company.leetcode.dp.packagesQuestion;


import java.util.Arrays;

//回溯来做：再集合中找出所有和相等的子集
public class med_473 {
    private static int count = 0;

    private static boolean backTracking(int[] matchsticks, int startIndex, int target, int cursum, boolean[] used) {
        //递归终止条件
//        if (cursum > target) return;  //剪枝操作
        if (cursum == target) {
//            count += 1;
            return true;
        }

        //单层递归逻辑
        for (int i = startIndex; i < matchsticks.length; i++) {
            if (!used[i] && cursum + matchsticks[i] <= target)  //该元素没被使用过且当前和小于等于目标和
            {
                cursum += matchsticks[i];
                used[i] = true;
                //如果找到了满足题意的子集和，直接返回，不用回溯（即不用恢复used[i]=true为false）,如果没找到，向上回溯,恢复used[i]=true为false
                if (backTracking(matchsticks, i + 1, target, cursum, used)) {
                    return true;
                }
                else
                {
                    continue;
//                    cursum -= matchsticks[i];  //回溯
                }
            }
//            else   //该元素被使用过或者加上该元素后和超过目标和
//            {
//                return false;
//            }
        }
        return false;
    }

    public static boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;
        int target = sum / 4;

        boolean[] used = new boolean[matchsticks.length];

        return backTracking(matchsticks, 0, target, 0, used);
    }


    public static void main(String[] args) {
        int[] matchsticks = {5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3};
        System.out.println(makesquare(matchsticks));
    }
}

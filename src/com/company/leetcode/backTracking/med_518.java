package com.company.leetcode.backTracking;


import java.util.ArrayList;
import java.util.List;

//回溯解决:超出时间限制
public class med_518 {
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> path=new ArrayList<>();

    public void backTracking(int amount,int[] coins,int cursum,int startIndex)
    {
        //递归终止
        if (cursum>amount) return;
        if (cursum==amount)
        {
            System.out.println(path.size());
            for (int e:path)
            {
                System.out.print(" "+e);
            }
            System.out.println();
            result.add(path);
            return;
        }

        //单层递归逻辑
        for (int i=startIndex;i<coins.length;i++) //加上startIndex是为了通过控制根节点（所有的父节点）起始位置去重（[1,2,2],[2,2,1]重复）
        {
            cursum+=coins[i];
            path.add(coins[i]);
            backTracking(amount,coins,cursum,i);
            path.remove(path.size()-1);
            cursum-=coins[i];  //回溯
        }
    }

    public int change1(int amount, int[] coins) {
        result.clear();
        path.clear();
        backTracking(amount,coins,0,0);
        return result.size();
    }

    //完全背包解决
    //因为是组合问题，与元素顺序无关，遍历顺序必须是物品在外，背包在内。比如[1,5]和[5,1]是同一种结果，所以只要保证物品被遍历一遍即可，故将物品遍历放在外层
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int i=0;i<coins.length;i++)  //遍历物品
        {
            for (int j=coins[i];j<=amount;j++) //遍历背包:这里不同于0-1背包问题，0-1背包中每件物品只能被添加一次，而完全背包中每件物品可以被添加多次，所以这里从前至后
            {
                dp[j]+=dp[j-coins[i]];  //组合总数
            }
        }
        return dp[amount];
    }
}

package com.company.leetcode.dp.packagesQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Vector;
/*
* 有一堆石头，每块石头的重量都是正整数。

每一回合，从中任意选出两块 石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：

如果x == y，那么两块石头都会被完全粉碎；
如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
*/

/*
* 思路：此问题可以转为0-1背包问题
* 想象成将这堆石头分成两堆（且将一堆石头看成一个整体对象），当两队石头的重量越靠近时，那么最后剩余的石头质量肯定最小，这样就将问题化为0-1背包问题了。
* 即在背包容量一定的前提下，使得放的石头越多，这样两堆石头重量会越接近，差距越小，所剩石头重量越小。所以两堆的重量大小应该都越接近中间值越好，可定目标容量为中间值
*
* 物品的重量是stones[i]，价值也是stoned[i]
*
* 背包容量大小为SUM（stones)/2（向下取整） dp[j]表示容量为j的背包最多可以的石头重量
*
* 递推公式：dp[j]=max(dp[j],dp[j-stones[i]]+stones[j]
*
* 初始化：dp[0]=0
*
* 遍历方向次数：两层循环，物品价值外围遍历，背包容量内层（且为倒序遍历）
*
* 返回值：在计算target的时候，target = sum / 2 因为是向下取整，所以sum - dp[target] ⼀定是⼤于等于
dp[target]的
*
* */

//测试用例：[2,7,4,1,8,1]
public class med_1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum= Arrays.stream(stones).sum();  //求数组和
        System.out.println(sum);
        int target=sum/2;  //目标背包容量
        int[] dp=new int[sum];  //dp数组长度初始化等于石头重量之和，因为背包最大容量最多也就是所有石头重量之和，也可以初始化长度为target+1
        System.out.println(dp[2]);
        for (int i=0;i< stones.length;i++)         //遍历物品
        {
            for (int j=target;j>=stones[i];j--)     //遍历背包，倒叙
            {
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        for (int e:dp)
        {
            System.out.print(e+" ");
        }
        return sum-dp[target]-dp[target];
    }
}

package com.company.leetcode.dp.packagesQuestion;


/*
* 有一堆石头，每块石头的重量都是正整数。

每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：

如果x == y，那么两块石头都会被完全粉碎；
如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
*/

import java.util.*;
import java.util.Arrays.*;
public class easy_1046 {
    public int lastStoneWeight(int[] stones) {
        //int[]->数值流->装箱->转为数组
//        Integer[] tmp=Arrays.stream(stones).boxed().toArray(Integer[]::new);
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for (int s:stones)
        {
            pq.offer(s);
        }

        while(pq.size()>1)
        {
            int a=pq.poll();
            int b=pq.poll();
            if (a>b)
            {
                pq.offer(a-b);
            }
        }
        return pq.isEmpty()?0:pq.poll();
    }
}

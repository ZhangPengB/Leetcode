package com.company.leetcode.doublePoint;

public class med_1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int m=queries.length;
        boolean[] answer=new boolean[m];
        for (int i=0;i<m;i++)
        {
            answer[i]=isSatified(candiesCount,queries[i]);
        }
        return answer;
    }

    public static boolean isSatified(int[] candiesCount,int[] query)
    {
        int n=candiesCount.length;
        int pre_sum=0;
        //该类型糖果之前的糖果之和
        for (int i=0;i<n && i<query[0];i++)
        {
            pre_sum+=candiesCount[i];
        }
        int post_sum=pre_sum+candiesCount[query[0]];
        //吃的糖果数是存在一个区间内，如果此区间满足一定条件，则在第n天就可以吃到第query[0]类糖果
        //左区间：因为每天至少吃一颗，所以左区间为query[1]
        //右区间：每天按query[2]要求最多颗糖来吃，右区间为query[1]*query[2]
        //区间A为(query[1],query[1]*query[2]]
        //第n类之前糖果总数pre_sum,包括第n类的糖果总数post_sum
        //因为第query[1]天若能吃到query[0]糖果，则presum必须吃完或者恰好吃完(pre_sum<=num),postsum可以开始吃了，但不能吃完num<post_sum，所以问题转换为查询区间A中是否存在满足此条件的数，若存在，则为true，否则为false
        int left=query[1];
        int right=query[1]*query[2];
        for (int num=left;num<=right;num++)  //num表示吃的糖果数
        {
            if (pre_sum<=num && num<post_sum)
            {
                return true;
            }
        }
        return false;
    }


}

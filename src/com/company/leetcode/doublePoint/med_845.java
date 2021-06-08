package com.company.leetcode.doublePoint;

public class med_845 {
    public int longestMountain(int[] arr) {
        int n=arr.length;
        int result=0;
        int index=1;
        while(index<n)
        {
            int up=0,down=0;

            //既不上升，也不下降的要过滤掉
            while(index<n && arr[index-1]==arr[index])
            {
                index++;
            }
            //统计上升山脉，不包括山顶
            while(index<n && arr[index-1]<arr[index])
            {
                up++;
                index++;
            }
            System.out.println("up:"+up);
            //统计下降山脉
            while (index<n && arr[index-1]>arr[index])
            {
                down++;
                index++;
            }
            //上升山脉和下降山脉必须都大于0，才能称之为山脉
            if (up>0 && down>0)
            {
                result=Math.max(result,up+down+1);
            }
        }
        return result;
    }


    //计算每个元素左边上升个数和右边上升个数，然后对应位相加再加1取最大值即可
    public int longestMountain1(int[] arr) {
        int n=arr.length;
        int[] up=new int[n];
        int[] down=new int[n];
        int result=0;
        for (int i=1;i<n;i++)
        {
            if (arr[i]>arr[i-1])
            {
                up[i]=up[i-1]+1;
            }
        }

        for (int i=n-1;i>0;i--)
        {
            if (arr[i]<arr[i-1])
            {
                down[i-1]=down[i]+1;
            }
        }

        for (int i=0;i<n;i++)
        {
            System.out.println(up[i]+" "+down[i]);
        }
        for (int i=0;i<n;i++)
        {
            if (up[i]==0 || down[i]==0)  //只要有一个为0，无法构成山脉
            {
                continue;
            }
            result=Math.max(result,down[i]+up[i]+1);
        }
        return result;
    }
}

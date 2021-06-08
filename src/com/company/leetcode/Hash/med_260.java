package com.company.leetcode.Hash;

import java.util.HashMap;
import java.util.Map;
public class med_260 {
    public int[] singleNumber(int[] nums) {
        int n=nums.length;
        if (n==2) return nums;
        int[] result=new int[2];
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int e:nums)
        {
            map.put(e,map.getOrDefault(e,0)+1);
        }
        int index=0;
        for (int key:map.keySet())
        {
            if(map.get(key)==1)
            {
                result[index++]=key;
            }
        }
        return result;
    }

    //异或实现分组求解
    public static int[] singleNumber1(int[] nums)
    {
        int ret=0;  //初始化为0，因为任何数与0异或保持不变
        for (int e:nums)
        {
            ret^=e;
        }
        //取ret最后一个为1的值作为标志位
        int mask=ret &(-ret);
        System.out.println(mask);
        int a=0,b=0;
        for (int e:nums)
        {
            if ((e&mask)==0)  //相与为0，分为一组
            {
                a^=e;
            }
            else   //相与为1，分为一组
            {
                b^=e;
            }
        }
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        int[] nums={-1,2,2,3};
        int[] res=singleNumber1(nums);
    }
}

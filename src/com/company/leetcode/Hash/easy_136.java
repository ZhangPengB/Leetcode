package com.company.leetcode.Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class easy_136 {
    public int singleNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int e:nums)
        {
            if (set.contains(e))
            {
                set.remove(e);
            }
            else
            {
                set.add(e);
            }
        }
        Iterator<Integer> it=set.iterator();
        return it.next();
    }

    //异或运算
    public int singleNumber1(int[] nums)
    {
        int result=0;  //初始化为0，a^0=a;a^a=0;a^b^c=a^c^b=b^c^a(交换律)
        for (int e:nums)
        {
            result^=e;
        }
        return result;
    }
}

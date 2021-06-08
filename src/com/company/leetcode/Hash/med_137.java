package com.company.leetcode.Hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class med_137 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int e:nums)
        {
            map.put(e,map.getOrDefault(e,0)+1);
        }
//        for (int key:map.keySet())
//        {
//            System.out.print(key+" "+map.get(key));
//        }
        int result=-1;
        for (int key:map.keySet())
        {
            if (map.get(key)==1)
            {
                result=key;
                break;
            }
        }
        return result;
    }
}

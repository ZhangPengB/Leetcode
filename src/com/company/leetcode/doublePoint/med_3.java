package com.company.leetcode.doublePoint;

import java.util.HashMap;

public class med_3 {
    //通过！！！
    public static int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0) return 0;
        int low=0,fast=0;
        int n=s.length();
        int result=1;
        while (low<n && fast<n)
        {
            HashMap<Character,Integer> hs=new HashMap<Character, Integer>();
            for (int i=low;i<n;i++,fast++)
            {
                char c=s.charAt(i);
                if (!hs.containsKey(c))  //实时计算子串长度，求最大值
                {
                    hs.put(c,i);
                    int sublen=i-low+1;
                    result=Math.max(sublen,result);
                }
                else            //包含当前字符时，慢指针指向与该字符相同的下一个字符，作为新字符串的起始位置，然后跳出当前循环，开始搜索新字符串
                {
                    fast=i;     //记录当前遍历位置
                    low=hs.get(c);
                    low++;
                    break;
                }

            }
        }
        return result;
        }


    public static int lengthOfLongestSubstring1(String s){
        if (s == null || s.length() == 0) return 0;
        int low = 0;
        int n = s.length();
        int maxLen=0;
        HashMap<Character,Integer> hs=new HashMap<>();
        for (int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if (hs.containsKey(c))
            {
                //当前字符包含在当前有效字串中和当前字符不包含在当前有效子串中，基于两种情况，所以取max
                low = Math.max(low,hs.get(c) + 1);  //这里可以这样写，基于两点，第一：hashsmap key相同时会value会被覆盖，所以必须取max,
                // 第二：如abba这样的字符串，第二次重复字符的a,由于之前就存在于hs,但是对应index不一定大于之前的low，所以必须取max,low表示新字符串的起始位置
                System.out.println(low);
            }
            hs.put(c,i);  //Associates the specified value with the specified key in this map. If the map previously contained a mapping for the key, the old value is replaced.
            maxLen=Math.max(maxLen,i-low+1);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abba"));
    }
}

package com.company.leetcode.doublePoint;

import java.util.HashMap;
import java.util.HashSet;

public class hard_76 {
    public static String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();

        if (m==1)
        {
            for (int i=0;i<n;i++)
            {
                if(s.charAt(i)==t.charAt(0)) return s.substring(i,i+1);
            }
            return "";
        }

        HashMap<Character,Integer> Hs=new HashMap<>();
        HashMap<Character,Integer> window=new HashMap<>();
        //将t中字符放入Hs，累加值
        for (char ch:t.toCharArray())
        {
            Hs.put(ch,Hs.getOrDefault(ch,0)+1);
        }

        for (char ch:Hs.keySet())
        {
            System.out.print(ch+":"+Hs.get(ch));
            System.out.println();
        }

        String result="";
        boolean startFlag=true;
        int start=-1;  //子串开始标志
        int valid=0;  //记录有效字符，作为判断子串结束标志
        int count=0;  //统计window中有效字符个数
        for (int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if (Hs.containsKey(c))
            {
                if(startFlag)
                {
                    startFlag=false;
                    start=i;
                }
                window.put(c,window.getOrDefault(c,0)+1);
                count++;
                if (window.get(c)==Hs.get(c))
                {
                    valid++;
                }
            }

            int p=start;
            //字符串结束，start向右移动，每向右移动一位，如果当前字符存在于window中，个数减1，直到window的size等于
            if(valid==Hs.size())
            {
                System.out.println("-------------");
                for (char ch:window.keySet())
                {
                    System.out.print(ch+":"+window.get(ch));
                    System.out.println();
                }
//                System.out.println();

                while(p<i && count>m)
                {
                    char ch=s.charAt(p);
                    if (window.containsKey(ch) && window.get(ch)>Hs.get(ch))
                    {
                        window.put(ch,window.get(ch)-1);
                        count--;
                    }
                    p++;
                }
                System.out.println("count:"+count);
                //走到这里，count==m,缩小到最小字符串了
                result=s.substring(p,i+1);
                System.out.println(result);
                startFlag=true;
                p++;
                //向右移动，将下一个遇到的并且存在于Hs中的字符作为新的子串起始位置,
                while(p<i && !Hs.containsKey(s.charAt(p)))
                {
                    p++;
                }
                System.out.println("p:"+p);

            }

        }
        return result;
    }

    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        String res=minWindow(s,t);
        System.out.println(res);
    }
}

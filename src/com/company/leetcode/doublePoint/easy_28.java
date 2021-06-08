package com.company.leetcode.doublePoint;

public class easy_28 {
    //该代码通过
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();
        if (n2 == 0) return 0;
        if (n2 > n1) return -1;
        if (haystack.equals(needle)) return 0;
        boolean flag = true;   //标志位，用于判断字符串是否相同
        for (int i = 0; i + n2 <= n1; i++)   //这里是等于，可取到最后一位
        {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int start = i;
                int index = 0;
                while (start < n1 && index < n2)   //判断字符串是否相同
                {
                    if (haystack.charAt(start) != needle.charAt(index)) {
                        flag = false;
                        break;
                    }
                    index++;
                    start++;
                }
                if (flag)   //字符串相同
                {
                    return i;
                } else {
                    flag = true;
                }
            }

        }
        return -1;
    }

    //朴素匹配法
    public int strStr1(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();
        if (n2 == 0) return 0;
        if (n2 > n1) return -1;
        for (int i = 0; i + n2 <= n1; i++) {
            int start = i, index = 0;
            while (index < n2 && haystack.charAt(start) == needle.charAt(index)) {
                index++;
                start++;
            }
            if (index == n2) return i;
        }
        return -1;
    }


    public static int[] getNext(String p)
    {
        int i=1,j=0;
        int[] next=new int[p.length()+1];
        next[1]=0;
        while (i<p.length())
        {
            if (j==0 || p.charAt(i)==p.charAt(j))
            {
                ++i;
                ++j;
                next[i]=j;
            }
            else
            {
                j=next[j];
            }
        }
        return next;
    }


    public int index_KMP(String s,String p)
    {
        int i=1,j=1;
        int[] next=new int[p.length()+1];
        next=getNext(p);
        while(i<s.length() && j<=p.length())
        {
            if (j==0 || s.charAt(i)==p.charAt(i))
            {
                i++;
                j++;
            }
            else
            {
                j=next[j];
            }
        }
        if (j>p.length())
        {
            return i-p.length();
        }
        return -1;
    }

    public static void main(String[] args) {
        String p="aaaab";
        int[] next=getNext(p);
        for(int e:next)
        {
            System.out.print(e+" ");
        }
    }
}

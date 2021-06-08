package com.company.leetcode.huawei;

import java.util.*;

public class HJ31 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            String s=sc.nextLine();
            String result=reverseString(s);
            System.out.println(result);
        }
    }

    public static String test(String s)
    {
        StringBuilder result=new StringBuilder();
        List<String> list=new ArrayList<>();
//        StringBuilder sb=new StringBuilder();
        String tmp="";
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if (c>='a'&& c<='z'||c>='A'&&c<='Z')
            {
                tmp+=c;
            }
            else
            {
                list.add(tmp);
                tmp="";
            }
        }
        if (tmp.length()!=0)
        {
            list.add(tmp);
        }
        for (int i=list.size()-1;i>0;i--)
        {
            result.append(list.get(i));
            result.append(" ");
        }
        result.append(list.get(0));
        return result.toString();
    }


    public static String reverseString(String s)
    {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if ((c>='a' && c<='z')||(c>='A' && c<='Z'))
            {
                sb.append(c);
            }
            else
            {
                sb.append(' ');
            }
        }
        String[] tmp=sb.toString().split(" ");
        StringBuilder result=new StringBuilder();
        for (int i=tmp.length-1;i>=0;i--)
        {
            System.out.println(tmp[i]);;
            if (!tmp[i].equals(""))  //相邻空格分割出来的是""而不是" "，字符串比较用equal
            {
                result.append(tmp[i]);
                result.append(" ");
            }
        }
        return result.toString();
    }
}

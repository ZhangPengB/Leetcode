package com.company.leetcode.huawei;

import javax.swing.plaf.IconUIResource;
import java.util.*;

public class bishi_2016 {

}



class Main1_2016
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int n=sc.nextInt();
            System.out.println(deletenum(n));
        }
    }

    public static int test(int n)
    {
        List<Integer> list=new ArrayList<Integer>();
        for (int i=0;i<n;i++)
        {
            list.add(i);
        }
        int index=0;
        while(list.size()>1)
        {
            index=(index+2)%list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    public static int deletenum(int n)
    {
//        Queue<Integer> Q=new ArrayDeque<>();
        Deque<Integer> dq=new ArrayDeque<>();
        for (int i=0;i<n;i++)
        {
            dq.add(i);
        }
        int count=0;
        while(dq.size()>1)
        {
            while (count<2)
            {
                int num=dq.pop();
                dq.add(num);
                count++;
            }
            //删除元素
            dq.pop();
            count=0;
        }
        return dq.pop();
    }
}


class Main2_2016
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            String s=sc.nextLine();
            System.out.println(test(s));
        }

    }

    public static String test(String s)
    {
        Set<Character> set=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if (!set.contains(c))
            {
                set.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
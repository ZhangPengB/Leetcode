package com.company.leetcode.huawei;

import java.sql.SQLOutput;
import java.util.*;

public class bishi1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int n=sc.nextInt();
            System.out.println(Drink(n));
        }
    }

    public static int Drink(int n)
    {
        int sum=0;
        while(n>2)
        {
            sum+=n/3;
            n=n/3+n%3;
        }
        if (n==2) sum+=1;
        return sum;
    }
}


class Main1
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int n=sc.nextInt();
            int[] nums=new int[n];
            for (int i=0;i<n;i++)
            {
                nums[i]=sc.nextInt();
            }
            List<Integer> list=test(nums);
            for (int i=0;i<list.size();i++)
            {
                System.out.println(list.get(i));
            }
        }
    }

    //实现对数组元素的排序和去重
    public static List<Integer> test(int[] nums)
    {
        Arrays.sort(nums);
        Set<Integer> set=new HashSet<Integer>();
        List<Integer> list=new ArrayList<>();
        for (int e:nums)
        {
            if (!set.contains(e))
            {
                set.add(e);
                list.add(e);
            }
        }
        return list;
    }
}


class Main2
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            String hex=sc.nextLine();
            System.out.println(hextodec(hex));

        }
    }


    public static int hextodec(String hex)
    {
        Map<Character,Integer> map=new HashMap<>();
        map.put('A',10);
        map.put('B',11);
        map.put('C',12);
        map.put('D',13);
        map.put('E',14);
        map.put('F',15);
        int n=hex.length();
        int result=0;
        for (int i=2;i<n;i++)
        {
            char c=hex.charAt(i);
            if(map.containsKey(c))
            {
                int value=map.get(c);
                result+=value*Math.pow(16,n-i-1);
            }
            else
            {
                int num=(int)c-(int)('0');
                result+= num*Math.pow(16,n-i-1);
            }
        }
        return result;
    }

}

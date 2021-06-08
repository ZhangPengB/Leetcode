package com.company.leetcode.huawei;

import java.util.*;

public class HJ102 {
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
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Map.Entry<Character,Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o1.getValue()<o2.getValue())  //不同字符按字符个数降序表示，所以返回1时，前者必须小于后者
                {
                    return 1;
                }
                else if (o1.getValue()==o2.getValue())
                {
                    if (o1.getKey()<o2.getKey())  //次数相同时，按AscII码升序输出，升序前者必须大于后者，返回1；如果前者小于后者，返回-1
                    {
                        return -1;
                    }
                    else
                    {
                        return 1;
                    }
                }
                else
                {
                    return -1;
                }
            }
        });
        StringBuilder sb=new StringBuilder();
        for (Map.Entry entry:list)
        {
            sb.append(entry.getKey());
        }
        return sb.toString();
    }
}

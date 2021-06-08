package com.company.leetcode.huawei;

import java.util.*;

public class HJ14 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            String sn=sc.nextLine();
            int n=Integer.parseInt(sn);  //字符串转换为int
//            String[] s=new String[n];
            List<String> list=new ArrayList<>();
            for (int i=0;i<n;i++)
            {
                list.add(sc.nextLine());
            }
            List<String> result=test(list);
            for (int i=0;i<result.size();i++)
            {
                System.out.println(result.get(i));
            }
        }
    }

    public static List<String> test(List<String> list)
    {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int l1=o1.length(),l2=o2.length();
                int i=0;
                while(i<l1 && i<l2)
                {
                    if (o1.charAt(i)<o2.charAt(i))  //不同字符按字典序排序，升序
                    {
                        return 1;
                    }else if(o1.charAt(i)==o2.charAt(i))  //相同字符时
                    {
                        i++;
                        continue;
                    }
                    else
                    {
                        return -1;
                    }
                }
                if (i==l1) return 1;
                if (i==l2) return -1;
                return 0;
            }
        });
//        Arrays.sort(s);
        return list;
    }
}

package com.company.leetcode.dp;

public class med_647 {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];  //dp[i][j]表示以i开始，j结尾的字符串是否为回文串，若是，为true，否则为false
        dp[0][0]=true;
        int count=0;
        for (int j=0;j<n;j++)
        {
            for (int i=0;i<=j;i++)
            {
                dp[i][j]=s.charAt(i)==s.charAt(j) &&(j-i<2 ||dp[i+1][j-1]);
                if (dp[i][j])
                {
                    count++;
                }
            }
        }
        for (int i=0;i<n;i++)
        {
            for (boolean e:dp[i])
            {
                System.out.println(e);
            }
        }
        return count;
    }


    //中心扩展法
    public int countSubstrings1(String s)
    {
        int count=0;
        int n=s.length();
        //统计以一个字符向两边扩展
        for (int i=0;i<n;i++)
        {
            int left=i,right=i;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right))
            {
                count++;
                left--;
                right++;
            }
        }
        System.out.println(count);

        for (int j=0;j<n-1;j++)
        {
            int left=j,right=j+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right))
            {
                count++;
                left--;
                right++;
            }
        }
        System.out.println(count);
        return count;
    }


    //将上述单独统计综合起来计算：以单个字符为回文中心个数为n,以两个字符为回文中心的个数为n-1,所以总的回文中心为m=2*n-1
    //回文中心左起点：l=m/2,右起点为r=m/2+m%2
    public int countSubstrings2(String s)
    {
        int count=0;
        int n=s.length();
        for (int i=0;i<2*n-1;i++)
        {
            int l=i/2,r=i/2+i%2;
            while (l>=0 && r<n && s.charAt(l)==s.charAt(r))
            {
                count++;
                l--;
                r++;
            }
        }
        System.out.println(count);
        return count;
    }


    //回文中心无非一个字符或者两个字符，并且都是以当前字符开始，所以在遍历过程中同时处理以当前字符开始的一个或者两个回文中心情况
    public int countSubstrings3(String s)
    {
        int n=s.length();
        int count=0;
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<2;j++)
            {
                int l=i;
                int r=i+j;
                while (l>=0 && r<n && s.charAt(l)==s.charAt(r))
                {
                    count++;
                    l--;
                    r++;
                }
            }
        }
        return count;
    }


}

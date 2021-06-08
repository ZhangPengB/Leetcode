package com.company.leetcode.dp;

public class med_5 {
    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        System.out.println(right-left-1);
        return right - left - 1;  //扩展后的回文串长度，如果不是回文串，长度为0
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]); //j - i 代表长度减去 1，防止
                if (dp[i][j] &&  j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }



    public String longest(String s)
    {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        String res="";
        for (int i=n-1;i>=0;i--)
        {
            for (int j=i;j<n;j++)
            {
                dp[i][j]=s.charAt(i)==s.charAt(j) && (j-i<2 || dp[i+1][j-1]);
                if (dp[i][j] && j-i+1>res.length())
                {
                    res=s.substring(i,j+1);
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        String s="babad";
        System.out.println(longestPalindrome1(s));
    }
}

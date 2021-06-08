package com.company.leetcode.others.zifuchuan;

//破坏回文串并使得字典序最小
public class med_1328 {
    public String breakPalindrome(String palindrome) {
        int n=palindrome.length();
        int half=n/2;
        char[] str=palindrome.toCharArray();
        for (int i=0;i<half;i++)
        {
            if (str[i]>'a')
            {
                str[i]='a';
                return String.valueOf(str);
            }
        }
        str[n-1]='b';
        return String.valueOf(str);
    }
}
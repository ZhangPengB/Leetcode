package com.company.leetcode.doublePoint;

public class easy_9 {
    public boolean isPalindrome(int x) {
        String str=Integer.toString(x);
        for(int left=0,right=str.length()-1;left<right;left++,right--)
        {
            if (str.charAt(left)!=str.charAt(right))
            {
                return false;
            }
        }
        return true;
    }
}

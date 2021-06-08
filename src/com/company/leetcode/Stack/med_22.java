package com.company.leetcode.Stack;

import java.util.ArrayList;
import java.util.List;

public class med_22 {
    List<String> result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n<=0) return result;
        getParenthesis("",n,n);
        return result;
    }

    public void getParenthesis(String str,int left,int right)
    {
        if (left==0 && right==0)
        {
            result.add(str);
            return ;
        }
        if (left==right)
        {
            //剩余左右括号数相等，下一个只能用左括号
            getParenthesis(str+'(',left-1,right);
        }
        else if (left<right)
        {
            //左括号数小于右括号，下一个既可以用左括号，也可以用右括号
            if (left>0)
            {
                getParenthesis(str+'(',left-1,right);
            }
            getParenthesis(str+')',left,right-1);
        }
    }
}

package com.company.leetcode.Stack;

import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

public class easy_20 {
    public boolean isValid(String s) {
        if (s.length()==1) return false;
        Map<Character,Character> Hm=new HashMap<>();
        Hm.put('(',')');
        Hm.put('[',']');
        Hm.put('{','}');
        Stack<Character> S=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            //左括号，入栈
            if (Hm.containsKey(c))
            {
                S.push(s.charAt(i));
            }
            //右括号，且栈不为空
            if (Hm.containsValue(c) && !S.empty())
            {
                char ch=S.pop();;  //弹出栈顶元素
                //判断是否匹配,如果不匹配，直接退出,匹配,继续向后，
                if(Hm.get(ch)!=c)
                {
                    return false;
                }
            }
        }
        return S.empty();
    }
}

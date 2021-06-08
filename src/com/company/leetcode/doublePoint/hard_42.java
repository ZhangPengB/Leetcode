package com.company.leetcode.doublePoint;

import java.util.Stack;

public class hard_42 {
     public int trap(int[] height) {
        int n=height.length;
        if (n<=2) return 0;
        Stack<Integer> S=new Stack<>();
        int current=0;   //当前指针位置，从左向右遍历
        int result=0;
        while(current<n)
        {
            while(!S.empty() && height[current]>height[S.peek()])
            {
                int h=height[S.peek()];  //中间高度
                S.pop();
                //加在这里，一来防止后面S.peek()时异常，二来从业务逻辑角度讲，当栈为空时，形不成容器（因为容器至少需要三个数）无法计算容量，所以直接break
                if (S.empty())
                {
                    break;
                }
                //计算容器容量
                int min=Math.min(height[S.peek()],height[current]);
                int distance=current-S.peek()-1;
                result+=distance*(min-h);
            }
            S.push(height[current]);
            current++;
        }
        return result;
    }

    //双指针:为什么雨水容量可以这样计算？？？
    public int trap1(int[] height)
    {
        int n=height.length;
        int result=0;
        if (n<=2) return result;
        int left=0,right=n-1;
        int Maxleft=0,Maxright=0;
        while(left<right)
        {
            Maxleft=Math.max(height[left],Maxleft);
            Maxright=Math.max(height[right],Maxright);
            if (height[left]<height[right])
            {
                result+=Maxright-height[left];
                left++;
            }
            else
            {
                result+=Maxleft-height[right];
                right--;
            }
        }
        return result;
    }
}

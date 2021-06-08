package com.company.leetcode.doublePoint;

public class med_11 {
    //暴力，超时
    public int maxArea1(int[] height) {
        int n=height.length;
        if (n<2) return 0;
        int result=0;
        for (int i=0;i<n;i++)
        {
            for (int j=i+1;j<n;j++)
            {
                result=Math.max(result,(j-i)*Math.min(height[j],height[i]));
            }
        }
        return result;
    }

    //双指针：两个指针分别位于容器两端，根据规则移动移动指针，更新res，直至i==j
    //指针移动规则：容器盛水容量：(j-i)*Math.min(height[j],height[i])，i,j分别为容器的两端
    //若移动短板：短板有可能更短，也有可能更长，大于长板，所盛水容量可能增加
    //若移动长板，长板若变得更长，容量照样减小，长板若变得更短，甚至小于短板，容量也减小
    //所以，移动长板，容量肯定减小，移动短板，容量有可能增加，因此应该移动短板
    //如果两个板一样长，移动容器那边都可以
    public int maxArea(int[] height)
    {
        int n=height.length;
        if (n<2) return 0;
        int left=0,right=n-1;
        int result=0;
        while(left<right)
        {
            result=Math.max(result,(right-left)*Math.min(height[right],height[left]));
            if (height[left]>height[right])
            {
                right--;
            }
            else
            {
                left++;
            }
        }
        return result;
    }

}

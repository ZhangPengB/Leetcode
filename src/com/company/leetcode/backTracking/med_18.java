package com.company.leetcode.backTracking;

import com.sun.deploy.util.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class med_18 {

    //回溯存在去重问题，目前没通过
    public void backTracking(int[] nums,int target,int cursum,int startIndex,List<List<Integer>> result,List<Integer> path)
    {
        if (target==cursum && path.size()==4)
        {
            System.out.println(path);
            if (result.size()==0)
            {
                result.add(new ArrayList<>(path));
            }
            else
            {
                if (path.equals(result.get(result.size()-1)))
                {
                    return;
                }
                result.add(new ArrayList<>(path));  //这里加入的是new的新对象
                return;
            }
        }

        for (int i=startIndex;i<nums.length;i++)
        {
            if(i==0)
            {
                path.add(nums[i]);
                cursum+=nums[i];
            }
            else if (i>0 && nums[i]==nums[i-1])
            {
                path.add(nums[i]);
                cursum+=nums[i];
            }
            else   //重复了，不选当前元素，跳过
            {
                continue;
            }
            backTracking(nums,target,cursum,i+1,result,path);
            cursum-=nums[i];
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        for (int e:nums) System.out.print(e+" ");
        System.out.println();
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        if (n<4) return result;
        backTracking(nums,target,0,0,result,path);
        return result;
    }
//
//    [[-5,-4,4,5],[-5,-3,3,5],[-5,-2,2,5],[-5,-2,3,4],[-5,-1,1,5],[-5,-1,2,4],[-5,0,0,5],[-5,0,1,4],[-5,0,2,3],[-5,0,1,4],[-5,0,2,3],
//    [-4,-3,2,5],[-4,-3,3,4],[-4,-2,1,5],[-4,-2,2,4],[-4,-1,0,5],[-4,-1,1,4],[-4,-1,2,3],[-4,0,0,4],[-4,0,1,3],
//    [-3,-2,0,5],[-3,-2,1,4],[-3,-2,2,3],[-3,-1,0,4],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//
//    [[-5,-4,4,5],[-5,-3,3,5],[-5,-2,2,5],[-5,-2,3,4],[-5,-1,1,5],[-5,-1,2,4],[-5,0,0,5],[-5,0,1,4],[-5,0,2,3],
//    [-4,-3,2,5],[-4,-3,3,4],[-4,-2,1,5],[-4,-2,2,4],[-4,-1,0,5],[-4,-1,1,4],[-4,-1,2,3],[-4,0,0,4],[-4,0,1,3],
//    [-3,-2,0,5],[-3,-2,1,4],[-3,-2,2,3],[-3,-1,0,4],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]  29


    public List<List<Integer>> fourSum1(int[] nums,int target)
    {
        int n=nums.length;
        List<List<Integer>> result=new ArrayList<>();
        if (nums==null || n<4)
        {
            return result;
        }
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++)
        {
            if (i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            //第一层循环去重
            if (nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target)
            {
                break;
            }
            if (nums[i]+nums[n-3]+nums[n-2]+nums[n-1]<target)  //当前元素值太小，取下一个nums[i]
            {
                continue;
            }
            for (int j=i+1;j<n-2;j++)
            {
                if (j>i+1 && nums[j]==nums[j-1])
                {
                    continue;
                }
                 //第二层循环去重
                 if (nums[i]+nums[j]+nums[j+1]+nums[j+2]>target)  //nums[j]太大，直接结束
                 {
                     break;
                 }
                 if (nums[i]+nums[j]+nums[n-2]+nums[n-1]<target)
                 {
                     continue;
                 }
                 int left=j+1,right=n-1;
                 while(left<right)
                 {
                     int sum=nums[i]+nums[j]+nums[left]+nums[right];
                     if (sum==target)
                     {
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //左指针右移遇到不同的数，右指针左移遇到不同的数
                         while (left<right && nums[left]==nums[left+1])
                         {
                             left++;
                         }
                         left++;
                         while(left<right && nums[right]==nums[right-1])
                         {
                             right--;
                         }
                         right--;
                     }
                     else if (sum<target)
                     {
                         left++;
                     }
                     else
                     {
                         right--;
                     }

                 }
            }
        }
        return result;
    }
}

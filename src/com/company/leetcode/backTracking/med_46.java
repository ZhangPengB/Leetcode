package com.company.leetcode.backTracking;

import java.util.ArrayList;
import java.util.List;


//没通过->已通过
public class med_46 {
    List<Integer> path= new ArrayList<>();
    List<List<Integer>> result= new ArrayList<>();

    private void backTracking(int[] nums, boolean[] used) {
//        System.out.println(path.size());
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));  //Java中，参数传递是值传递，对象类型变量在传参过程中复制的是变量的地址，这些地址被添加到了res变量中，但实际上指向的是同一块内存地址，因此需要拷贝，否则为空列表
            return;
        }

        //单层递归
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            System.out.println("递归之前==>"+path);
            backTracking(nums, used);
            used[i] = false;
            path.remove(path.size() - 1);
            System.out.println("递归之后==>"+path);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];  //默认初始化为fasle
        if(nums.length==0) return result;
        backTracking(nums, used);
        return result;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        med_46 s=new med_46();
        List<List<Integer>>list=s.permute(nums);
        System.out.println(list);
    }
}

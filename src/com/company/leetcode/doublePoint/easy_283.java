package com.company.leetcode.doublePoint;

public class easy_283 {
    /*
    * 两次遍历，第一次向右遍历，将所有非零元素依次放在数组前面，记录下非零元素位置，第二次从非零元素位置开始遍历，赋值为0即可
    * */
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int left=0;
        for(int i=0;i<n;i++)
        {
            if (nums[i]!=0)
            {
                nums[left++]=nums[i];
            }
        }
        for (int i=left;i<n;i++)
        {
            nums[i]=0;
        }
    }

    /*
    * 快速排序思想：选取中间点，将非零元素放在左边，零元素放在右边
    * 实现时，使用两个指针，i指向非零元素。遇到非零元素时，我们就交换i,j当前指向的元素
    * j初始化指向数组开头
    * 一次遍历即可
    * */
    public void moveZeroes1(int[] nums){
        int n=nums.length;
        int j=0;
        for (int i=0;i<n;i++)
        {
            if (nums[i]!=0)
            {
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j++]=tmp;
            }
        }
    }
}

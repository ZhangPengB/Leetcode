package com.company.leetcode.doublePoint;

import java.util.*;

public class hard_239 {
    public static int[] maxSlidingWindow1(int[] nums, int k)
    {
        int n=nums.length;
        if(k==1) return nums;
        HashMap<Integer,Integer> hs=new HashMap<>();
        int[] result=new int[n-k+1];
        int index=0;
        int max=Integer.MIN_VALUE;
//        List<Integer> list=new ArrayList<Integer>(Arrays.asList(nums));


        for (int i=0;i<n-k+1;i++)
        {
            if (index==0)
            {
                for(int j=0;j<k;j++)
                {
                    if (nums[j]>max)
                    {
                        max=nums[j];
                        hs.put(max,j);
                    }
                }
                result[index++]=max;
            }
            else
            {
                int  premax=result[index-1];
                if(nums[i]>=premax)   //当前值大于等于上一个最大值，不管上一个最大值是否在当前子数组中，当前子数组的最大值都是该最大值
                {
                    result[index++]=nums[i];
                    hs.put(nums[i],i);
                }
                else  //当前值小于上一个最大值，如果上一个最大值还在当前子数组，则当前子数组最大值为上一个最大值，如果不在，遍历该子数组，求出最大值
                {
                    int premaxindex=hs.get(premax);
                    if (premaxindex>=i)  //上一个最大值在当前子数组
                    {
                        result[index++]=premax;
                        hs.put(premax,premaxindex);
                    }
                    else        //上一个最大值不在当前子数组，遍历求出最大值
                    {
                        int right=i+k-1;
                        int left=i;
                        int pmax=Integer.MIN_VALUE;
                        while(right>=left)
                        {
                            if(nums[left]>pmax)
                            {
                                pmax=nums[left];
                                hs.put(nums[left],left);
                            }
                            left++;
                        }
                        result[index++]=pmax;
                    }
                }
            }
        }
        for(int e:hs.keySet())
        {
            System.out.println(e+":"+hs.get(e));
        }
        return result;
    }



    //针对下面for循环中四步处理步骤简单思考
    //毋庸置疑，当将所有情况都处理完后，再考虑更新结果，所以result添加元素放在最后一步
    //另一个问题：队列先添加元素还是先弹出元素？毫无疑问，是在比较了当前元素和队尾元素大小之后，再将当前元素下标加入到队尾，所以应先比较大小（弹出元素）
    //移除队首元素和添加到result先后顺序？因为保证队首元素即为当前子数组最大值，所以应先移除队首元素

    //对代码风格思考：之前总是考虑各种if-else之间关系，并且在其中更新result，多个if-else有时候写着写着自己都蒙蔽了，搞不清楚逻辑关系了；反观下面的代码逻辑风格
    //当你处理完所有待处理的逻辑时，最后在考虑更新result，此时的result就显得那么合理清晰
    //处理逻辑时，画流程图可理清逻辑的先后处理顺序！！！
    //引用柯南的名言：除去不可能的,不管多么不合情理,但那就是真相…，处理程序逻辑也是一样，当将所有不可能的情况都处理掉后，剩下的一定是结果！！！
    public static int[] maxSlidingWindow(int[] nums, int k)
    {
        int n=nums.length;
        if (nums==null || n<2)
        {
            return nums;
        }
        int[] result=new int[n-k+1];
        int index=0;
        //双端队列，按从大到小顺序存储遍历nums中的值
        Deque<Integer> queue=new LinkedList<>();  //链表实现
//        Deque<Integer> deque=new ArrayDeque<>();  //数组实现
        for (int i=0;i<n;i++)
        {
            //保证从大到小，如果前面的数小于当前值，依次弹出
            while(!queue.isEmpty() && nums[queue.peekLast()]<=nums[i])
            {
                queue.pollLast();
            }
            //添加当前值对应的下标
            queue.add(i);
            //队首元素不在在当前子数组区间，移除掉
            if (queue.peek()<=i-k)
            {
                queue.poll();
            }
            //当窗口长度为k时，保存当前窗口最大值，即为队首元素
            if (i+1>=k)  //考虑到一开始窗口未形成，这里写成i+1>=k，一旦第一个窗口形成，后面每移动一步，均会形成窗口
            {
                result[index++]=nums[queue.peek()];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int n=3;
        int[] result=maxSlidingWindow(nums,n);
        for (int e:result)
        {
            System.out.print(e+"-");
        }
    }

}

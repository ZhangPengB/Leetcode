package com.company.leetcode.huawei;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  //电话数
        int M = sc.nextInt();  //棋牌室容量
        int[] time = new int[24];  //存储每天的预约时间长度
        for (int i = 0; i < N; i++) //遍历N 个预约电话
        {
            String[] info = sc.nextLine().split(" ");
            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);
            int timelen = Integer.parseInt(info[2]);

            int currentSum = 0;  //表示每个预约时间段内容量
            boolean flag = true;  //记录预约是否成功
            //对每个电话预约，求该段时间内，当前预约人数加上已存在容量之和是否少于总容量，如果遍历完该段时间后，还是小于，加入数组，在开始时间处加timelen,在离开时间处减去timelen
            for (int j = start; j < end; j++) {
                currentSum += time[j];
                if (currentSum + timelen > M)  //超过容量，该次预约不成功，作废，跳过
                {
                    flag = false;
                    break;  //这里要用break，结束当前循环体
                }
            }
            if (flag)                  //该次预约成功，在开始和结束时刻加入或剪掉相应人数
            {
                time[start] += timelen;
                time[end] -= timelen;
            }
        }

        for (int e : time) {
            System.out.print(e + " "); //输出用空格隔开
        }
    }
}

//        for (int i=1;i<10;i++)
//        {
//            System.out.println("i============="+i);
//
//            for (int j=1;j<10;j++)
//            {
//                System.out.println("zhiqian:"+j);
//                if (j>5)
//                {
//                    break;  //break 跳出结束当前循环体（一层）continue跳过该层循环，继续循环下一层，当前循环体还在
//                }
//                System.out.println("j:"+j);
//            }
//        }
package com.company.leetcode.huawei;


import java.util.HashSet;
import java.util.Scanner;
import java.io.*;


public class t3
{
    int Treedepth=0;
    int zhiDepth=0;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int maxts=Integer.parseInt(in.nextLine());
            //数组来存放跳数建设成本
            int[] tsValue=new int[maxts];
            for (int i=0;i<maxts;i++)
            {
                tsValue[i]=Integer.parseInt(in.nextLine());
            }

            //统计树的深度
            int depth=1;
            String[] treeinfo=in.nextLine().split(" ");
            int nodeNums=Integer.parseInt(treeinfo[0]);
            int edgeNums=Integer.parseInt(treeinfo[1]);
            HashSet hs=new HashSet();
            for (int i=0;i<edgeNums;i++)
            {
                String[] treecon=in.nextLine().split(" ");
                int tmp=Integer.parseInt(treecon[0]);
                if (!hs.contains(tmp))
                {
                    hs.add(tmp);
                    depth+=1;
                }
            }
            System.out.println(depth);
            if (depth<=3)
            {
                System.out.println(tsValue[0]);
            }
            else if (depth>3 &&depth<=5)
            {
                System.out.println(tsValue[1]);
            }
            else
            {
                System.out.println(tsValue[tsValue.length-1]);
            }
        }
    }
}




//    public int depth(TreeNode root) {
//        if(root==null)
//        {
//            return 0;
//        }
//        Treedepth+=1;  //走到这里，根节点不为空，深度加一
//        dfs(root);
//        return Treedepth;
//    }
//
//    public  void dfs(TreeNode root)
//    {
//        //递归终止
//        if (root.left==null && root.right==null)
//        {
//            Treedepth=Math.max(Treedepth,count);
//            return;
//        }
//
//        //单层递归
//        if (root.left!=null)
//        {
//            zhiDepth+=1;
//            dfs(root.left);
//            zhiDepth-=1; //回溯
//        }
//        if(root.right!=null)
//        {
//            zhiDepth+=1;
//            dfs(root.right);
//            zhiDepth-=1; //回溯
//        }
//    }


package com.company.leetcode.Tree;

public class med_222 {
    //回溯
    int nodeCount=0;
    int pathCount=0;
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        pathCount+=1;
        dfs(root);
        return nodeCount;
    }


    public void dfs(TreeNode node)
    {
//        pathCount+=1;
        //递归终止
        if (node==null)
        {
            nodeCount+=pathCount;
            return ;
        }


        //单层递归
        if (node.left!=null)
        {
            pathCount+=1;
            dfs(node.left);
            pathCount-=1;
        }
        if (node.right!=null)
        {
            pathCount+=1;
            dfs(node.right);
            pathCount-=1;
        }
    }

}

package com.company.leetcode.Tree;
import java.util.Queue;
import java.util.LinkedList;


/*
* 给定⼀个⼆叉树，找出其最⼩深度。
最⼩深度是从根节点到最近叶⼦节点的最短路径上的节点数
* 注意的点：如果左子树或者右子树为空，那么最小深度为不为空的子树深度加一；两者都不为空时，才是左右子树最小深度加一
* */
public class easy_111 {
    //递归
//    public int minDepth(TreeNode root) {
//        //递归终止
//        if (root == null) return 0;
//        int leftDepth = minDepth(root.left);
//        int rightDepth = minDepth(root.right);
//        //如果左子树为空，右子树不为空，最小深度为右子树深度加1
//        if (root.left == null && root.right != null) {
//            return rightDepth + 1;
//        }
//        //如果左子树不为空，右子树为空，最小深度为左子树深度加1
//        if (root.left != null && root.right == null) {
//            return leftDepth + 1;
//        }
//        //左右子树都不为空，返回两者最小值加1
//        return Math.min(leftDepth, rightDepth) + 1;
//    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left==null)
        {
            return minDepth(root.right)+1;
        }
        if (root.right==null)
        {
            return minDepth(root.left)+1;
        }
        //都不为空
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }

}

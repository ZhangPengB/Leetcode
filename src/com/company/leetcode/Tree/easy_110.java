package com.company.leetcode.Tree;

/*
 * 判断一个树是否为平衡二叉树：二叉树的每个节点左右子树高度差不超过1
 * 自底向上递归的做法类似于后序遍历，对于当前遍历到的节点，先递归地判断其左右子树是否平衡，再判断以当前节点为根的子树是否平衡。
 * 如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回 -1−1。如果存在一棵子树不平衡，则整个二叉树一定不平衡
 * */
public class easy_110 {
    public boolean isBalanced(TreeNode root) {
        if (depth(root) == -1) return false;
        return true;
    }


    //后续遍历，自底向上递归判断，先左后右再根
    public int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == -1) return -1;  //左子树不是平衡二叉树
        if (right == -1) return -1;  //右子树不是平衡二叉树
        if (Math.abs(right - left) > 1) {  //以根节点开始的二叉树不是平衡二叉树
            return -1;
        }
        return Math.max(left, right) + 1;
    }

}

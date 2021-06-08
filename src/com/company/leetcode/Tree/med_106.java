package com.company.leetcode.Tree;

import java.util.Vector;


public class med_106 {
    //通过
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        if (inorder == null || postorder == null) {
            return null;
        }
        //取根节点，为后序遍历的最后一个元素
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);


        if (postorder.length == 1) return root;

        //以根节点来切割中序遍历为左右子树
        //首先寻找根节点在中序遍历中位置
        int rootPosition = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootPosition = i;
                break;
            }
        }
        System.out.println(rootPosition);
        //切割中序数组
        int[] leftInorder = new int[rootPosition];
        System.out.println("ll" + leftInorder.length);
        int[] rightInorder = new int[inorder.length - rootPosition - 1];
        System.out.println("rl:" + rightInorder.length);

        for (int i = 0; i < rootPosition; i++) {
            leftInorder[i] = inorder[i];
        }
        int rightInorderStart = 0;
        for (int i = rootPosition + 1; i < inorder.length; i++) {
            rightInorder[rightInorderStart++] = inorder[i];
        }

        //切割后序数组
        int[] leftPostorder = new int[leftInorder.length];
        System.out.println("lp:" + leftPostorder.length);
        int[] rightPostorder = new int[rightInorder.length];
        System.out.println("rp:" + rightPostorder.length);

        for (int i = 0; i < leftInorder.length; i++) {
            leftPostorder[i] = postorder[i];
        }
        int rightPostStart = 0;
        for (int i = leftInorder.length; i < postorder.length - 1; i++)  //因为最后一位为根节点，舍弃掉
        {
            rightPostorder[rightPostStart++] = postorder[i];
        }
        //递归实现构建左右子树
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        return root;
    }


    //中序+后序构造二叉树，这样可以构造唯一二叉树的前提是，树中的元素都不相同
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    //中序+后序构造二叉树，这样可以构造唯一二叉树的前提是，树中的元素都不相同
    public TreeNode help(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
        // if (inorder.length == 0 || postorder.length == 0) return null;
        if (postorderStart == postorderEnd) return null;
        //取根节点，为后序遍历的最后一个元素
        int rootVal = postorder[postorderEnd - 1];
        TreeNode root = new TreeNode(rootVal);


        if (postorderEnd-postorderStart==1) return root;

        //以根节点来切割中序遍历为左右子树
        //首先寻找根节点在中序遍历中位置,
        int rootPosition = 0;
        for (int i = inorderStart; i < inorderEnd; i++) {
            if (inorder[i] == rootVal) {
                rootPosition = i;
                break;
            }
        }
        // System.out.println("rootposition:"+rootPosition);
        //在中序遍历中确定左右子树中序遍历的起始索引
        int leftInorderStart = inorderStart;
        int leftInorderEnd = rootPosition;
        int rightInorderStart = rootPosition + 1;
        int rightInorderEnd = inorderEnd;


        //在后序遍历中确定左右子树的起始索引
        int leftPostorderStart = postorderStart;
        int leftPostorderEnd = leftInorderEnd - leftInorderStart +leftPostorderStart;
//        int leftPostorderEnd = postorderStart+rootPosition-inorderStart;

        int rightPostorderStart = leftPostorderEnd + 1;
//        int rightPostorderStart = postorderStart+(rootPosition-inorderStart);
        int rightPostorderEnd = postorderEnd - 1;


        System.out.println("inorder:"+leftInorderStart+" "+leftInorderEnd+" "+rightInorderStart+" "+rightInorderEnd);
        System.out.println("postorder:"+leftPostorderStart+" "+leftPostorderEnd+" "+rightPostorderStart+" "+rightPostorderEnd);

        root.left = help(inorder, leftInorderStart, leftInorderEnd, postorder, leftPostorderStart, leftPostorderEnd);
        root.right = help(inorder, rightInorderStart, rightInorderEnd, postorder, rightPostorderStart, rightPostorderEnd);
        return root;
    }

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        return help(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
}

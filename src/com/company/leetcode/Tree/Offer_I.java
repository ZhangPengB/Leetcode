package com.company.leetcode.Tree;

/*
* 求二叉树的深度：深度为从根节点到叶子节点的所经过的节点个数
* 二叉树的高度：从节点到根节点的根节点的路径所经过的节点个数
* 对比二叉树的深度和高度定义可知，求深度需要从上至下，即前序遍历；求高度需要从下至上，须后序遍历。
* 但是在二叉树中，树的高度和深度是相同的，所以可以按照求高度的方式（后序）来求高度，反之也可以按照前序遍历求深度的方式来求深度
*
* 下面提供两种方式：方法1为前序遍历求深度；方法二为后续遍历求深度
* */

//回溯来求解
public class Offer_I {
    int depth = Integer.MAX_VALUE;
    int tmpDepth=0;
    public int minDepth(TreeNode root)
    {
        if (root == null) return 0;
        tmpDepth+=1;
        dfs(root, tmpDepth);
        return depth;
    }

    public void dfs(TreeNode node, int tmpDepth) {
//        tmpDepth+=1;
        //递归终止条件
        if (node.left == null && node.right == null) {
            depth = Math.min(depth, tmpDepth);
            return;
        }

        //单层递归逻辑
        if (node.left != null) {
            tmpDepth += 1;
            dfs(node.left, tmpDepth);
            tmpDepth -= 1;
        }
        if (node.right != null) {
            tmpDepth += 1;
            dfs(node.right, tmpDepth);
            tmpDepth -= 1;
        }
    }


    //递归来求解
    public int depth(TreeNode node)
    {
        //递归终止条件：该节点为空
        if(node==null)
        {
            return 0;
        }

        int leftDepth=depth(node.left);
        int rightDepth=depth(node.right);
        return Math.max(leftDepth,rightDepth)+1;
    }

    public int maxDepth1(TreeNode root)
    {
        if (root == null) return 0;
        return depth(root);
    }


//    上面函数进一步
public int maxDepth2(TreeNode node)
{
    //递归终止条件：该节点为空
    if(node==null)
    {
        return 0;
    }

    int leftDepth=maxDepth2(node.left);
    int rightDepth=maxDepth2(node.right);
    return Math.max(leftDepth,rightDepth)+1;
}

}

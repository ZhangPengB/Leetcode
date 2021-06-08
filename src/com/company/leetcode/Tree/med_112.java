package com.company.leetcode.Tree;


public class med_112 {

    //深度优先搜索（更像回溯算法）
    public boolean dfs(TreeNode node, int count, int targetSum) {
        //递归终止条件
        if (node.left == null && node.right == null && count == targetSum) {
            return true;
        }

        //单层递归逻辑
        if (node.left != null) {
            count += node.left.val;
            if (dfs(node.left, count, targetSum)) return true;  //这里需提供返回值，因为只需要找到一条路径即可
            count -= node.left.val;  //回溯
        }
        if (node.right != null) {
            count += node.right.val;
            if (dfs(node.right, count, targetSum)) return true;
            count -= node.right.val;      //回溯
        }
        //程序走到这里，表示所有树枝都遍历完了没有找到，返回false
        return false;
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, root.val, targetSum);
    }


    //递归实现：递归的精髓在分析单一节点
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null)  //这里的root代表单一节点（看成整棵树搞混）
        {
            return false;
        }
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }
        return hasPathSum1(root.left, targetSum - root.val) || hasPathSum1(root.right, targetSum - root.val);
    }
}

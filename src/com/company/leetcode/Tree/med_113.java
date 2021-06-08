package com.company.leetcode.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//import java.util.List;



public class med_113 {
    List<List<Integer>> result=new LinkedList<List<Integer>>();
    Deque <Integer> path=new LinkedList<Integer>();

    void transvalTree(TreeNode node, int count, int targetSum) {
        //递归终止条件:如果是叶子节点且count==targetSum,则加入结果集，递归终止
        if (node.left == null && node.right == null && count == targetSum) {
            result.add(new LinkedList<Integer>(path));
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }

        //单层处理逻辑
        if (node.left != null) {
            path.add(node.left.val);
            count += node.left.val;
            transvalTree(node.left, count, targetSum);
            count -= node.left.val;  //向上回溯
            path.pollLast();  //弹出最后一个元素。回溯
        }

        if (node.right != null) {
            path.add(node.right.val);
            count += node.right.val;
            transvalTree(node.right, count, targetSum);
            count -= node.right.val;
            path.pollLast();
        }
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return result;
        }
        path.add(root.val);
        transvalTree(root, root.val, targetSum);
        return result;
    }

}

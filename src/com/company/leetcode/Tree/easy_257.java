package com.company.leetcode.Tree;

import java.util.*;

/*
 * 返回从根节点到叶子结点的所有路径
 * */
//回溯来解决:遍历整棵树,所以单层递归逻辑没有返回值
//通过
public class easy_257 {
    List<String> result = new LinkedList<>();
    Vector<Integer> path = new Vector<>();

    public void dfs(TreeNode root) {
        path.add(root.val);
        //终止条件
        if (root.left == null && root.right == null)  //叶子节点
        {
            StringBuilder tmppath = new StringBuilder();

            for (int i = 0; i < path.size() - 1; i++) {
                tmppath.append(path.get(i));
                tmppath.append("->");
            }
            tmppath.append(path.get(path.size() - 1));  //把路径上的最后一个元素添加进来
            result.add(tmppath.toString());
            return;
        }

        //单层递归逻辑
        if (root.left != null) {
//            path.add(root.left.val);
            dfs(root.left);
            path.removeElementAt(path.size() - 1); //回溯
        }

        if (root.right != null) {
//            path.add(root.right.val);
            dfs(root.right);
            path.removeElementAt(path.size() - 1);  //回溯
        }
    }

//    //精简版本，隐藏了回溯细节
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> result = new ArrayList<>();
//        if (root == null) return result;  //如果树为空
//        StringBuilder path = new StringBuilder();
//        transval(root, path, result);
//        return result;
//    }
//
//    public void transval(TreeNode node, StringBuilder path, List<String> result) {
//        path.append(node.val);
//        if (node.left == null && node.right == null) {
//            result.add(path.toString());
//            return;
//        }
//
//        if (node.left != null) {
//            transval(node.left, path.append("->"), result);
//        }
//        if (node.right != null) {
//            transval(node.right, path.append("->"), result);
//        }
//    }
}

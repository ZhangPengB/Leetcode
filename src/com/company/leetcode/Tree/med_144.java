package com.company.leetcode.Tree;

import java.util.*;

public class med_144 {
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> result=new ArrayList<>();
        preorder(root,result);
        return result;
    }

    public void preorder(TreeNode node,List<Integer> result)
    {
        //终止条件
        if (node==null) return;

        //递归逻辑
        result.add(node.val);
        preorder(node.left,result);
        preorder(node.right,result);
    }


    //迭代法
    public List<Integer> preorderTraversal1(TreeNode root)
    {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> S=new Stack<>();
        if (root==null) return result;
        S.push(root);
        while(!S.empty())
        {
            TreeNode node=S.pop();
            result.add(node.val);

            if (node.right!=null) S.push(node.right);  //注意这里先是右节点入栈
            if (node.left!=null) S.push(node.left);
        }
        return result;
    }


    public List<Integer> inorder(TreeNode root)
    {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> S=new Stack<>();
        if (root==null) return result;
        while(root!=null || !S.empty())
        {
            if(root!=null)   //走到左端最底层
            {
                S.push(root);
                root=root.left;
            }
            else
            {
                TreeNode node=S.pop();
                result.add(node.val);
                root=node.right;
            }
        }
        return result;
    }


    public List<Integer> postorder(TreeNode root)
    {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> S=new Stack<>();
        if (root==null) return result;
        S.push(root);
        while(!S.empty())
        {
            TreeNode node=S.pop();
            result.add(node.val);

            if (node.left!=null) S.push(node.left);
            if (node.right!=null) S.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }


}

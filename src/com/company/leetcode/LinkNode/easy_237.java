package com.company.leetcode.LinkNode;

public class easy_237 {
    /*
    * 要删除节点，必须要找到当前节点的前驱结点并改变前驱结点的指向
    * 将当前节点值替换为后继节点值，然后当前节点后继节点指向后继节点的后继节点
    * */
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}

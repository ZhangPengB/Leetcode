package com.company.leetcode.LinkNode;

//class ListNode
//{
//    int val;
//    ListNode next;
//    ListNode(){}
//    ListNode(int val){this.val=val;}
//    ListNode(int val,ListNode next){this.val=val;this.next=next;}
//}


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class med_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        Stack<Integer> res=new Stack<>();

        while(l1!=null)
        {
            stack1.add(l1.val);
            l1=l1.next;
        }
        System.out.println(stack1);
        while (l2!=null)
        {
            stack2.add(l2.val);
            l2=l2.next;
        }
        System.out.println(stack2);


        int carry=0;
        while(!stack1.isEmpty() || !stack2.isEmpty())
        {
            int n1=stack1.isEmpty()?0:stack1.pop();
            int n2=stack2.isEmpty()?0:stack2.pop();
            System.out.println(stack1.size());
            System.out.println(stack2.size());
            int sum=n1+n2+carry;
            res.push(sum%10);
            carry=sum/10;
        }
        if (carry>0)
        {
            res.push(carry);
        }
        System.out.println(res.get(2));

        ListNode head=null,tail=null;
        while(!res.isEmpty())
        {
            if (head==null)
            {
                head=tail=new ListNode(res.pop());
            }
            else
            {
                tail.next=new ListNode(res.pop());
                tail=tail.next;
            }
        }
        return head;
    }
}

package com.company.leetcode.LinkNode;

class ListNode
{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val,ListNode next){this.val=val;this.next=next;}
}


public class med_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null,tail=null;
        int carry=0;
        while (l1!=null || l2!=null)
        {
            int n1=l1!=null?l1.val:0;
            int n2=l2!=null?l2.val:0;
            int sum=n1+n2+carry;
            if (head==null)
            {
                head=tail=new ListNode(sum%10);
            }
            else
            {
                tail.next=new ListNode(sum%10);
                tail=tail.next;
            }
            carry=sum/10;   //计算进位值
            if (l1!=null)
            {
                l1=l1.next;
            }
            if (l2!=null)
            {
                l2=l2.next;
            }
        }
        if (carry>0)
        {
            tail.next=new ListNode(carry);
        }
        return head;
    }


    public ListNode addTwoNumbers1(ListNode l1, ListNode l2)
    {
        ListNode p=l1;
        ListNode q=l2;
        int len1=0;
        int len2=0;
        while (p.next!=null)
        {
            len1++;
            p=p.next;
        }
        System.out.println(len1);
        while (q.next!=null)
        {
            len2++;
            q=q.next;
        }
        System.out.println(len2);

        if (len1>len2)
        {
            for (int i=0;i<len1-len2;i++)   //给l2末尾补零
            {
                q.next=new ListNode(0);
                q=q.next;
            }
        }
        else
        {
            for (int j=0;j<len2-len1;j++)  //给l1末尾补零
            {
                p.next=new ListNode(0);
                p=p.next;
            }
        }

        p=l1;
        q=l2;
        ListNode head=null,tail=null;
        int carry=0;
        while (p!=null && q!=null)  //因为两个长度相同，可以使用&&，不相同时类似方法1，使用||
        {
            int sum=p.val+q.val+carry;
            if (head==null)
            {
                head=tail=new ListNode(sum%10);
            }
            else
            {
                tail.next=new ListNode(sum%10);
                tail=tail.next;
            }
            carry=sum/10;
            if (p!=null)
            {
                p=p.next;
            }
            if (q!=null)
            {
                q=q.next;
            }
        }
        if (carry>0)
        {
            tail.next=new ListNode(carry);
        }
        return head;
    }

}

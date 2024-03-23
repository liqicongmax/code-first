package codeTop.链表.lc24;//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 2179 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import codeTop.base.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode l1=new ListNode();
        ListNode l2=new ListNode();
        ListNode n1=l1;
        ListNode n2=l2;
        while(head!=null){
            l1.next=head;
            l1=l1.next;

            head=head.next;
            if(head!=null){
                l2.next=head;
                l2=l2.next;
                head=head.next;
            }
        }
        l1.next=null;
        l2.next=null;
        ListNode res=new ListNode();
        ListNode root=res;
        n1=n1.next;
        n2=n2.next;
        while(n1!=null&&n2!=null){
            res.next=n2;
            n2=n2.next;
            res=res.next;
            res.next=n1;
            res=res.next;
            n1=n1.next;
        }
        if(n1!=null){
            res.next=n1;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        System.out.println(new Solution().swapPairs(n1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

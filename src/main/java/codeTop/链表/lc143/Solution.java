package codeTop.链表.lc143;//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics 栈 递归 链表 双指针 👍 1450 👎 0


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
    public void reorderList(ListNode head) {
        if(head.next==null){
            return;
        }
        ListNode l1=head;
        ListNode fast=head;
        ListNode slow =head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
        }
        ListNode l2=slow.next;
        slow.next=null;
        l2=reverse(l2);
        ListNode dummy = new ListNode();
        ListNode res=dummy;
        while(l1!=null||l2!=null){
            if(l1!=null){
                dummy.next=l1;
                l1=l1.next;
                dummy=dummy.next;
            }
            if(l2!=null){
                dummy.next=l2;
                l2=l2.next;
                dummy=dummy.next;
            }

        }
        head=res.next;
    }

    public ListNode reverse(ListNode node){
        ListNode pre=null;
        while(node!=null){
            ListNode next = node.next;
            node.next=pre;
            pre=node;
            node=next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

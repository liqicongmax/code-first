package codeTop.链表.lc82;//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 双指针 👍 1280 👎 0


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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode root=dummy;
        while(dummy!=null&&dummy.next!=null){
            ListNode next=dummy.next;
            int val=next.val;
            int len=0;
            while (next.next!=null&&val==next.next.val){
                next=next.next;
                len++;
            }
            if(len!=0) {
                next = next.next;
                dummy.next = next;
            }else{
                dummy=dummy.next;
            }
        }

        return root.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

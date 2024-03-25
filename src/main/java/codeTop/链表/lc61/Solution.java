package codeTop.链表.lc61;//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
// 
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics 链表 双指针 👍 1038 👎 0


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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy=head;
        ListNode root=head;
        int len=0;
        while(dummy!=null){
            dummy=dummy.next;
            len++;
        }
        k=k%len;
        if(k==0){
            return head;
        }
        k=len-1-k;
        for(int i=0;i<k&&head!=null;i++){
            head=head.next;
        }
        if(head!=null) {
            ListNode tail = head.next;
            head.next = null;
            return merge(tail,root);
        }
        return null;
    }


    public ListNode merge(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }
        ListNode head=l1;
        while(l1!=null&&l1.next!=null){
            l1=l1.next;
        }
        l1.next=l2;

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

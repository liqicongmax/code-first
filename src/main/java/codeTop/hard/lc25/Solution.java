package codeTop.hard.lc25;//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 2289 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import codeTop.base.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 设置一个尾巴节点作为k个一轮反转的结尾
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            // 如果这轮不足k个，就不反转，原样返回head
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        // realHead是从head到tail反转后的结果
        ListNode realHead = reverse(head, tail);
        // 为什么用header不是tail，因为从head到tail已经反转过了，此时head才是尾巴
        // 从header到tail.pre被反转了，因此下一轮从next开始继续进行k个一轮反转
        head.next = reverseKGroup(tail, k);
        return realHead;
    }

    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        while (head != tail) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        tail.next = pre;
        pre = tail;

        return pre;
    }

    /**
     * 链表从第m个节点到第n个节点反转
     * 例如 1-2-3-4-5 第二个节点到第4个节点反转，结果为1-4-3-2-5
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = new ListNode(-1);
        ListNode l = pre;
        pre.next = head;
        for (int i = 0; i < left - 1; i++) {
            head = head.next;
            l = l.next;
        }
        ListNode tail = head;
        for (int i = 0; i < right - left; i++) {
            tail = tail.next;
        }
        ListNode realTail = tail.next;
        l.next = reverse(head, tail);
        head.next = realTail;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Solution s = new Solution();
        print(s.reverseBetween(n1, 2, 4));
//        print(s.reverse(n1, n5));
    }

    public static void print(ListNode n) {
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

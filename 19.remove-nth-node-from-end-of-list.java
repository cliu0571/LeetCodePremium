/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start
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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // dummy: in case removing the head (e.g. [1,2,3], 3)
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode p1 = dummy;
        for (int i = 0; i <= n; i++) {
            p1 = p1.next;
        }

        ListNode p2 = dummy;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;
        return dummy.next;
    }
}
// @lc code=end

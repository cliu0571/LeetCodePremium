/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (33.38%)
 * Likes:    1250
 * Dislikes: 92
 * Total Accepted:    186.3K
 * Total Submissions: 557.1K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * 
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public void reorderList(ListNode head) {
        // 1. find mid
        // 2. reverse 2nd half
        // 3. merge 1st half and 2nd half
        if (head == null || head.next == null)
            return;
        ListNode mid = findMid(head);
        ListNode half = mid.next;
        mid.next = null;
        head = merge(head, reverse(half));
        return;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (one != null && two != null) {
            curr.next = one;
            one = one.next;
            curr.next.next = two;
            two = two.next;
            curr = curr.next.next;
        }
        if (one != null)
            curr.next = one;
        if (two != null)
            curr.next = two;
        return dummy.next;
    }
}
// @lc code=end

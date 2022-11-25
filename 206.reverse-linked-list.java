/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (58.30%)
 * Likes:    3194
 * Dislikes: 77
 * Total Accepted:    763.8K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * 
 * 
 * Follow up:
 * 
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    /** Iterative solution */
    public ListNode reverseList(ListNode head) {
        /** Iterative solution */
        // return reverseListIterative(head);
        /** Recursive solution */
        return reverseListRecursive(head);
    }

    /** Iterative solution */
    private ListNode reverseListIterative(ListNode head) {
        ListNode ans = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = ans;
            ans = head;
            head = next;
        }
        return ans;
    }

    /* recursive solution */
    private ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode last = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

   
}
// @lc code=end

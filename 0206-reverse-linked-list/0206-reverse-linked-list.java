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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode p1 = head;
        if (p1 == null || p1.next == null) {
            return p1;
        }
        while (p1 != null && p1.next != null) {
            ListNode temp = p1.next;
            p1.next = prev;
            prev = p1;
            p1 = temp;
        }
        p1.next = prev;
        prev = p1;
        return prev;
    }
}
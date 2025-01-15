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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);
        ListNode head = newList;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;
            newList.next = temp;
            l1 = l1.next;
            l2 = l2.next;
            newList = newList.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;
            newList.next = temp;
            l1 = l1.next;
            newList = newList.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;
            newList.next = temp;
            l2 = l2.next;
            newList = newList.next;
        }
        if (carry > 0) {
            ListNode temp = new ListNode(carry);
            newList.next = temp;
        }
        return head.next;
    }
}
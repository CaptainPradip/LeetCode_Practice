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
    public boolean isPalindrome(ListNode head) {
        ListNode newList = new ListNode(0);
        ListNode newHead = newList;
        ListNode trav = head;

        while (trav != null) {
            newList.next = new ListNode(trav.val);
            newList = newList.next;
            trav = trav.next;
        }
        newHead = newHead.next;
        ListNode reverseList = reverse(head);

        while (newHead != null && reverseList != null) {
            if (newHead.val != reverseList.val) {
                return false;
            }
            newHead = newHead.next;
            reverseList = reverseList.next;
        }
        return true;
    }

    public ListNode reverse(ListNode list) {
        ListNode current = list;
        ListNode previous = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
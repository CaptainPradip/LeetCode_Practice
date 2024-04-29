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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = slow.next;
        slow.next = null;
        ListNode second = reverseList(prev);
        ListNode first = head;
        while(second!=null){
            ListNode temp1 = first.next ;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp;
        ListNode current = head;
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

}
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
    public ListNode removeNodes(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode trav = head;
        while (trav != null) {
            while (!stack.isEmpty() && stack.getLast().val < trav.val) {
                stack.removeLast();
            }
            stack.addLast(trav);
            trav = trav.next;
        }
        ListNode head2 = new ListNode(0);
        ListNode current = head2;
        while (!stack.isEmpty()) {
            current.next = new ListNode(stack.removeFirst().val);
            current = current.next;
        }
        return head2.next;
    }
}
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current = head;
        ListNode prev = null ;
        ListNode temp;
        // got to left -1 
        while(current!=null && left >1)
        {
            prev = current ;
            current = current.next;
            left--;
            right--;
        }
        // keep the pre List refernce 
        ListNode connection = prev;
        // Keep the tail ref of reverse list
        ListNode tail = current;
        // reverse list 
        while(current!=null && right>0){
            temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
            right--;
        }

       if(connection!=null){
           connection.next=prev;
       }else{
           head = prev;
       }
       // join the tail to next remaining list 
       tail.next=current;
        return head;
    }
}
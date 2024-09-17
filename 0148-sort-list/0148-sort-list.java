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
    public ListNode sortList(ListNode head) {
			if(head==null || head.next == null){
				return head;
			}
      ListNode mid =  findMid(head);
	  ListNode left= sortList(head);
	  ListNode right = sortList(mid);
	  return mergeList(left, right);
    }

	public ListNode mergeList(ListNode list1, ListNode list2){

		ListNode dummy = new ListNode();
		ListNode tail = dummy;
		while(list1!=null && list2!=null){
				if(list1.val< list2.val){
					tail.next = list1 ;
					list1 = list1.next;
				} else{
					tail.next = list2;
					list2 = list2.next;
				}
				tail= tail.next;		
		}
	    tail.next = list1!=null ? list1: list2;
		return  dummy.next;
		
	}
	public ListNode findMid(ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		ListNode preMid = null;
		while(fast !=null && fast.next !=null){
			fast = fast.next.next;
			preMid = slow;
			slow = slow.next;
		}
		if(preMid!=null)
			preMid.next=null;
		return slow ;
	}
}
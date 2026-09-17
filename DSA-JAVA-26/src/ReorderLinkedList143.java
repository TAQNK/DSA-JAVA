//You are given the head of a singly linked-list. The list can be represented as:
//
//L0 → L1 → … → Ln - 1 → Ln
//Reorder the list to be on the following form:
//
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//You may not modify the values in the list's nodes. Only nodes themselves may be changed.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,3,4]
//Output: [1,4,2,3]
//Example 2:
//
//
//Input: head = [1,2,3,4,5]
//Output: [1,5,2,4,3]
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 5 * 104].
//1 <= Node.val <= 1000
public class ReorderLinkedList143 {
	public static reverse(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		
		while(curr != null) {
			ListNode next = curr.next;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public static ListNode findMiddle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	 public void reorderList(ListNode head) {
		 if(head == null || head.next == null || head.next.next == null)return ;
		 
		 ListNode middleNode = findMIddle(head);
		 ListNode reverse = reverseNode(middle.next);
		 
		 middleNode.next = null;// sepration of two linked list
		 // then traversing both linked list elements one by one 
		 
		 ListNode firstHalf=  head;
		 ListNode secondHalf = reverse;
		 
		 ListNode dummy = new ListNode(-1);
		 ListNode curr = dummy;
		 while(firstHalf != null && secondHalf != null) {
			 curr.next = firstHalf;
			 firstHalf = firstHalf.next;
			 curr = curr.next;
			 
			 curr.next = secondHalf;
			 secondHalf = secondHalf.next;
			 curr = curr.next;
		 }
		 return dummy.next;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

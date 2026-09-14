//Given the head of a linked list, remove the nth node from the end of the list and return its head.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
//Example 2:
//
//Input: head = [1], n = 1
//Output: []
//Example 3:
//
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
//Constraints:
//
//The number of nodes in the list is sz.
//1 <= sz <= 30
//0 <= Node.val <= 100
//1 <= n <= sz

public class nthNodeFromLast19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        // using the naive approach 
        // strps to follow
        // 1. find the length of list
        // 2. get the index from where we will  be deleteing the element 
        // -(size - n + 1)node 
        // 3. trverse till size - n 
        // 4. make the (size - n)th node -> next  = size-n)th node -> next -> next ;
        if(head == null || head.next == null){
            return null;
        }
        ListNode dummy = head;
        int size = 0 ;
        while(dummy != null){
            size++;
            dummy = dummy.next;
        }
        // edge case when size of list = the nth node to be deleted 
        if(size == n)return head.next;
        ListNode nextNodeToDelete = head ;
        for(int i = 1 ; i < size - n ; i++){
            nextNodeToDelete = nextNodeToDelete.next;
        }
        nextNodeToDelete.next = nextNodeToDelete.next.next;
        return head;


    }
	
	// using the recommended or expected approach 
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	    	// in this approach we will use fast and slow pointers and will not find the size of list
			if(head == null || head.next == null)return null;
			// 1st move the fast pointer to n+1th times
	        // this dumy node helps with edge cases of head node removal
			ListNode dummy = new ListNode(0);
	        dummy.next = head;
			ListNode fast = dummy;
			ListNode slow = dummy;
			
			for(int i = 0 ; i<=n ;i++) {
				fast = fast.next;
			}
			// 2nd now start moving both the pointer till fast reaches null
			while(fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
			// 3rd node to be deleted is at the slow.next index 
	        ListNode nodeToBeDeleted = slow.next;
			slow.next = nodeToBeDeleted.next;
			return dummy.next;
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

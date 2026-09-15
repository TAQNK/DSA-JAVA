//Given the head of a singly linked list. A cycle exists if the last node points back to a previous node, forming a loop. Remove the loop from the linked list if it exists.
//
//Internally, the driver code uses a variable x (1-based indexing) to represent the position of the node to which the last node is connected.
//
//The driver code will print "true" if the linked list is correctly modified, otherwise it will print "false".
//
//Examples:
//
//Input:
//
//Output: true
//Explanation: The linked list contains a loop that begins at node x = 2. After removing the loop, the driver code prints true.
//Input:
//
//Output: true
//Explanation: The linked list does not contain a loop (x = 0).
//Input: 
//
//Output: true
//Explanation: The linked list contains a loop that begins at node x = 1. After removing the loop, the driver code prints true.
//Constraints:
//
//1 ≤ size of linked list ≤ 105
//-105 ≤ node.data ≤ 105
//0 ≤ x ≤ size of binary tree

public class LinkedListCycleDetectionPlusRemovalGG {
	 public static void removeLoop(Node head) {
	        // code here
	        if(head == null || head.next == null)return ;
	        
	        Node fast = head ;
	        Node slow = head ;
	        
	        while(fast != null && fast.next != null){
	            fast = fast.next.next;
	            slow = slow.next;
	            if(slow == fast)break;
	        }
	        if(slow == fast){
	            // cycle detected
	            slow = head;
	            if(slow != fast){
	                // not meeting at first index 
	                while(fast.next != slow.next){
	                    slow = slow.next;
	                    fast = fast.next;
	                }
	                fast.next = null;
	            }else{
	                // meeting at first index
	                while(fast.next != slow){
	                    fast = fast.next;
	                }
	                fast.next =null;
	            }
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

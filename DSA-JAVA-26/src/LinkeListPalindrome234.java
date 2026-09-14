//Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,2,1]
//Output: true
//Example 2:
//
//
//Input: head = [1,2]
//Output: false
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 105].
//0 <= Node.val <= 9
// 
//
//Follow up: Could you do it in O(n) time and O(1) space?
public class LinkeListPalindrome234 {
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next ==  null)return true;
        
        //approach is to divide the list into two part and reversing the second half and check for palindrome
        //1 . find middle node
        ListNode middleNode = findMiddle(head);
        // 2 reverse from middle 
        ListNode secondHalfFirstElement = reverseIterate(middleNode.next);
        // 3. check for palindrome
        ListNode firstHalfFirstElement = head;
        while(secondHalfFirstElement != null) {
        		if(secondHalfFirstElement.val != firstHalfFirstElement.val)return false;

                firstHalfFirstElement = firstHalfFirstElement.next;
                secondHalfFirstElement = secondHalfFirstElement.next;
        }
        return true;
    }
	
	public ListNode findMiddle(ListNode head) {
		// using slow and fast pointers || hair and tortoise approach
		ListNode fast = head ;
		ListNode slow = head ;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	public ListNode reverseIterate(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			// update 
			prev = curr;
			curr = next ;
		}
		return prev;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

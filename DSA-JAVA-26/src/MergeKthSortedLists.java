import java.awt.print.Printable;
import java.util.LinkedList;
import java.util.PriorityQueue;

//You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
//Merge all the linked-lists into one sorted linked-list and return it.
//
// 
//
//Example 1:
//
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted linked list:
//1->1->2->3->4->4->5->6
//Example 2:
//
//Input: lists = []
//Output: []
//Example 3:
//
//Input: lists = [[]]
//Output: []


// Approach 1 :around  O(n cube)Is Just Like Merge Sort mergeing of two linked list 
// Approach 2 : 0 (k logk + N K log k )Is that using a priority queue and making the elemenets pop from priority and attaching them together . 
public class MergeKthSortedLists {
//  Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	public static ListNode merge2(ListNode[] lists) {
		ListNode head = lists[0];
		for(int i = 1 ; i < lists.length ; i++) {
			head = merge(head , lists[i]);
		}
		return head ; 
		
	}
	private static ListNode merge(ListNode l1,ListNode l2) {
			ListNode temp  = new ListNode(0);
			ListNode tail = temp ; 
			while(l1 != null && l2 != null) {
				if(l1.val <= l2.val) {
					temp.next = l1 ;
					l1 = l1.next;
				}else {
					temp.next = l2;
					l2 = l2.next;
				}
				temp = temp.next ;
			}
			if(l1 != null) {
				temp.next = l1 ; 
			}
			if(l2 != null) {
				temp.next = l2;
			}
			return tail.next ;
		
		
		
		
	}
	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		// priority queue
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null)
				pq.add(lists[i]);
		}
		ListNode temp = new ListNode(0);
		ListNode dummy = temp;
		while (!pq.isEmpty()) {

			ListNode ele = pq.poll();
			temp.next = ele;

			if (ele.next != null) {
				pq.add(ele.next);
			}
			temp = temp.next;

		}
		return dummy.next;
	}

	public static ListNode createList(int[] values) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		for (int val : values) {
			current.next = new ListNode(val);
			current = current.next;
		}
		return dummy.next;
	}

	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + (head.next != null ? " -> " : ""));
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode li1 = createList(new int[] { 1, 4, 5 });
		ListNode li2 = createList(new int[] { 1, 3, 4 });
		ListNode li3 = createList(new int[] { 2, 6 });
		printList(li1);
		printList(li2);
		printList(li3);
		ListNode[] lists = { li1, li2, li3 };

		
		 ListNode mergedHead = merge2(lists);
		 System.out.println("Ouput : ");
		 printList(mergedHead);
	}

}

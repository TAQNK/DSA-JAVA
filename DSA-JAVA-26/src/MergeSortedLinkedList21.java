//You are given the heads of two sorted linked lists list1 and list2.
//
//Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//
//Return the head of the merged linked list.
//
// 
//
//Example 1:
//
//
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
//Example 2:
//
//Input: list1 = [], list2 = []
//Output: []
//Example 3:
//
//Input: list1 = [], list2 = [0]
//Output: [0]
// 
//
//Constraints:
//
//The number of nodes in both lists is in the range [0, 50].
//-100 <= Node.val <= 100
//Both list1 and list2 are sorted in non-decreasing order.
public class MergeSortedLinkedList21 {
	public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
		
		// approach of using an array which give t.c = O(n+m * log(n+m)) s.c = O(n+m)
        List<Integer> a = new ArrayList<>();

        while(list1 != null){
            a.add(list1.val);
            list1 = list1.next;
        }
        
        while(list2 != null){
            a.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(a);

        ListNode dummy = new ListNode(-1);
        ListNode curr =  dummy;
        for(int i = 0 ; i < a.size() ; i++){
            curr.next = new ListNode(a.get(i));
            curr = curr.next;
        }
        return dummy.next;
    }
	
	// using recursive merge t.c = O(n+m) s.c = O(n+m)
public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        
        if(list1 == null){
            return list2;
        }

        
        if(list2 == null){
            return list1;
        }

        if(list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next , list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1 , list2.next);
            return list2;
        }
    }
// using an iterative approach where we use the dummy pointers  t.c = O(n+m) s.c = O(1)
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy ;

    while(list1 != null && list2 != null){
        if(list1.val <= list2.val){
            curr.next = list1;
            list1 = list1.next;
        }else{
            curr.next = list2;
            list2 = list2.next;
        }
        curr = curr.next;
    }
    if(list1 != null){
        curr.next = list1;
    }
    if(list2 != null){
        curr.next = list2;
    }
    return dummy.next;
    
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

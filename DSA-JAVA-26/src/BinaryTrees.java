
public class BinaryTrees {
	class Node{
		Node left;
		Node right;
		int data;
		Node(int value){
			data = value;
			left = null;
			right = null;
		}
	}
	static int idx  = -1;
	Node buildTree(int[] arr) {
		idx++;
		if(arr[idx] == -1) {
			return null;
		}
		Node n = new Node(arr[idx]);
		n.left = buildTree(arr);
		n.right = buildTree(arr);
		
		return n;
	}
	public static void main(String[] args) {
		int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTrees bt = new BinaryTrees();
		Node root = bt.buildTree(nodes);
		System.out.println(root.left.right.data);
	}

}

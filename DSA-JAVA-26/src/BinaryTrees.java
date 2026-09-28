import java.util.ArrayDeque;
import java.util.Queue;

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
	void PreOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		System.out.println(root.data);
		PreOrderTraversal(root.left);
		PreOrderTraversal(root.right);
	}
	void PostOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		PostOrderTraversal(root.left);
		PostOrderTraversal(root.right);
		System.out.println(root.data);
	}
	void InOrderTraversal(Node root){
		if(root == null) {
			return;
		}
		InOrderTraversal(root.left);
		System.out.println(root.data);
		InOrderTraversal(root.right);
	}
	void LevelOrderTraversal(Node root) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		while(! q.isEmpty()) {
			Node key = q.poll();
			System.out.println(key.data);
			if(key.left != null)
				q.add(key.left);
			if(key.right != null)
				q.add(key.right);
		}
		
	}
	
	int countNumberOfNodes(Node root) {
		if(root == null) {
			return 0;
		}
		return 1 + countNumberOfNodes(root.left) + countNumberOfNodes(root.right);
	}
	
	int sumOfNodes(Node root) {
		if(root == null) {
			return 0;
		}
		return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
	}
	
	int heightOfTree(Node root) {
		if(root == null) {
			return 0;
		}
		int heightOfLeftSubTree = heightOfTree(root.left);
		int heightOfRightSubTree = heightOfTree(root.right);
		return 1 + (heightOfLeftSubTree > heightOfRightSubTree ? heightOfLeftSubTree : heightOfRightSubTree);
	}
	public static void main(String[] args) {
		int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTrees bt = new BinaryTrees();
		Node root = bt.buildTree(nodes);
		System.out.println(root.left.right.data);
	}

}

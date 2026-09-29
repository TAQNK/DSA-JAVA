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
	//T.C - > O(n^2)
	int diameterOfTree(Node root) {
		if(root == null) {
			return 0;
		}
		
		int diameter1 = diameterOfTree(root.left); // subtree left max diameter
		int diameter2 = diameterOfTree(root.right);// subtree right max diameter
		int diameter3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;
		
		return Math.max(Math.max(diameter2, diameter1), diameter3);
	}
	
	static class TreeInfo {
		int ht ;
		int di ;
		TreeInfo(int h , int d){
			ht = h;
			di = d;
		}
		
	}
	// T.C - > O(n)
	TreeInfo diameterOfTree2(Node root) {
		if(root == null) {
			return new TreeInfo(0,0);
		}
		TreeInfo leftSubtree = diameterOfTree2(root.left);
		TreeInfo rightSubtree = diameterOfTree2(root.right);
		
		int myHeight = 1 + Math.max(leftSubtree.ht , rightSubtree.ht);
		int d1 = leftSubtree.di ;
		int d2 = rightSubtree.di;
		int d3 = 1 + leftSubtree.ht + rightSubtree.ht;
	
		int myDia = Math.max(Math.max(d1, d2), d3);
		
		TreeInfo myInfo = new TreeInfo(myHeight , myDia);
		return myInfo ;
		
	}
	public static void main(String[] args) {
		int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTrees bt = new BinaryTrees();
		Node root = bt.buildTree(nodes);
		System.out.println(root.left.right.data);
	}

}

import java.util.ArrayDeque;
import java.util.Queue;

public class BSTClass {
	class Node{
		Node left;
		int data;
		Node right;
		
		Node(int value){
			left = null;
			data = value;
			right = null;
		}
	}
	Node root;
	int count;
	boolean flag;
	Node insert(Node root, int value) {
		if(root == null) {
			count++;
			return new Node(value);
		}
		if(root.data > value) {
			root.left = insert(root.left,value);
		}else if(root.data < value) {
			root.right = insert(root.right,value);
		}
		return root; // when element is already present
	}
	boolean add(int key) {
		flag = true;
		root = insert(root , key);
		return flag;
	}
	void InorderTraversal(Node root) {
		if(root == null) {
			return;
		}
		//l root r
		InorderTraversal(root.left);
		System.out.print(root.data+"|");
		InorderTraversal(root.right);
	}
	void PreorderTraversal(Node root) {
		if(root == null) {
			return;
		}
		//root l r
		System.out.print(root.data+"|");
		InorderTraversal(root.left);
		InorderTraversal(root.right);
	}
	void PostorderTraversal(Node root) {
		if(root == null) {
			return;
		}
		//l r root
		InorderTraversal(root.left);
		InorderTraversal(root.right);
		System.out.print(root.data+"|");
		
	}
	void InorderTraversal() {
		InorderTraversal(root);
	}
	void PostorderTraversal() {
		PostorderTraversal();
	}
	void PreorderTraversal() {
		PreorderTraversal();
	}
	boolean contains(int key) {
		return contains(key,root);
	}
	boolean contains(int key , Node n) {
		if(n == null) {
			return false;
		}
		if(key == n.data) {
			return true;
		}else if(key < n.data) {
			return contains(key, n.left);
		}
		
		return contains(key , n.right);
		
	}
	void LevelOrderTraversal() {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			// remove an element
			Node n = q.poll();
			System.out.print(n.data+"|");
			// adding the left and right nodes
			if(n.left != null) {
				q.add(n.left);
			}
			if(n.right != null) {
				q.add(n.right);
			}
		}
	}
	public static void main(String[] args) {
		BSTClass b = new BSTClass();
		b.add(10);
		b.add(30);
		b.add(20);
		b.add(9);
		b.add(2);
		b.InorderTraversal(b.root);
		System.out.println("\n");
		b.PostorderTraversal(b.root);
		System.out.println("\n");
		b.PreorderTraversal(b.root);
		
		System.out.println("\n"+b.contains(40));
		b.LevelOrderTraversal();
	}

}

//Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
//
//A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
//
// 
//
//Example 1:
//
//
//Input: root = [3,4,5,1,2], subRoot = [4,1,2]
//Output: true
//Example 2:
//
//
//Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//Output: false
// 
//
//Constraints:
//
//The number of nodes in the root tree is in the range [1, 2000].
//The number of nodes in the subRoot tree is in the range [1, 1000].
//-104 <= root.val <= 104
//-104 <= subRoot.val <= 104
public class subtreeOfAnotherTree572 {
	class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if(subRoot == null) {
			return true;
		}
		if(root == null) {
			return false;
		}
		// checking if roots are matched 
		
			if(isIdentical(root , subRoot)) {
				return true;
			}
		
		
//		else looking in left subtree and right subtree
		return isSubtree(root.left , subRoot) || isSubtree(root.right , subRoot);
	}

	boolean isIdentical(TreeNode root, TreeNode subRoot) {
		if(root == null && subRoot == null) {
			return true; //checking for roots to be null or leaf nodes 
			}
		if(root == null || subRoot == null) {
			return false;		}
		
//		checking for left subtrees and right subtrees to match
		if(root.val == subRoot.val)
			return isIdentical(root.left , subRoot.right) && isIdentical(root.right , subRoot.right);
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

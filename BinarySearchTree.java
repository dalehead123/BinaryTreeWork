// 
// Implements a binary search tree containing int data
// Implement each of the unimplemented methods.
// In the video intro to this lab, I implement add(), both
// recursively and iteratively. Try to write add() on your own,
// but feel free to use my implementation if you want.
// Solve problems recursively or iteratively...your choice.
// Don't use arrays or any other Java collections.

// Dale Savage
// Lab 10 BST


// in this BST, we do not allow duplicates (as is the default case in CSE 274)
public class BinarySearchTree {

    private Node root;
    
    public BinarySearchTree() {
        root = null;
    }
    
    public void add(int n) {
    	root = add(root, n);
    }
    
    // needs to return a node that can be connected 
    // to the tree
    private Node add(Node top, int n) {
    	if (top == null) {
    		return new Node(n);
    	}
    	
    	// if top is not null, figure out whether
    	// to go left or right
    	if (n < top.data) {
    		top.left = add(top.left, n);
    	} else if (n > top.data) {
    		top.right = add(top.right, n);
    	}
 
    	return top;
    }
    
    
    // We'll solve iteratively and recursively
    // add by comparing n to a node, if its bigger
    // move right. if smaller, move left. when we 
    // try to move but hit null, that's where we want
    // the node
    public void iterativeAdd(int n) {
        // loop (Iterative) approach
    	if (root == null) {
    		root = new Node(n);
    		return; // quit so we dont try adding it again
    	}
    	
    	// navigate until I find where to put n
    	Node parent = root;
    	Node curr = root;
    	
    	while(curr != null) {
    		parent = curr;
    		
    		if (n < parent.data) { // n small, move left
    			curr = parent.left;
    		} else if (n > parent.data) { // otherwise move right
    			curr = parent.right;
    		}else { // otherwise if you find a match. stop. dont add duplicate
    			return;
    		}
    		
    	}

    	// at this point, n will be placed either on the left or right
    	// child of parent
    	
    	if (n < parent.data) { // new node to the left
    		parent.left = new Node(n);
    	} else if (n > parent.data){
    		parent.right = new Node(n);
    	}
    	
    	
    }
    
    // prints the inorder traversal of this tree, space-separated
    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }
    
    private void inOrderTraversal(Node top) {
        if (top == null) {
            return;
        }
        inOrderTraversal(top.left);
        System.out.print(top.data + " ");
        inOrderTraversal(top.right);
    }
    
    // Since this is a binary SEARCH tree, you should write
    // an efficient solution to this that takes advantage of the order
    // of the nodes in a BST.  Your algorithm should be, on average,
    // O(log n) where n is the number of nodes in the BST, assuming
    // a well balanced tree.
    public boolean contains(int n) {
        return contains(root, n);
    }
    
    private boolean contains(Node top, int n) {
    	// top is null
    	if (top == null) {
    		return false;
    	}
    	
    	// if there is a match...
    	if (top.data == n) {
    		return true;
    	}
    	
    	// otherwise, go left or right
    	if (n < top.data) {
    		return contains(top.left, n);
    	}else {
    		return contains (top.right, n);
    	}
    	    	
    }
    
    // returns the smallest value in the tree
    // or throws an IllegalStateException() if the
    // tree is empty.  Write an O(h) solution, where
    // h is the height of the tree. 
    // recursive or a loop BUT... keep going left until you find it
    public int min() {
        return min(root);
    }
    
    private int min(Node top) {
    	if (top == null) {
    		return -1;
    	}

    	if (top.left != null) {
    		return min(top.left);
    	}
    	
    	return top.data;
    }
    
    // returns the largest value in the tree
    // or throws an IllegalStateException() if the
    // tree is empty.  Write an O(h) solution, where
    // h is the height of the tree
    // recursive or a loop BUT... keep going right until you find it
    public int max() {
        return max(root);
    }
    
    private int max(Node top) {
    	if (top == null) {
    		return -1;
    	}

    	if (top.right != null) {
    		return max(top.right);
    	}
    	
    	return top.data;
    }
    
    // Returns whether the tree is empty
    public boolean isEmpty() {
        return root == null;
    }
    
    // returns the height of this BST. If a BST is empty, then
    // consider its height to be -1.
    public int getHeight() {
    	if (isEmpty()) {
    		return -1;
    	}
    	
    	if (getHeightLeft(root) > getHeightRight(root)) {
    		return getHeightLeft(root);
    	}else {
    		return getHeightRight(root);
    	}
    	
    	//return getHeight(root);
    	
    	
    }   
    


    private int getHeightLeft(Node top) {
    	
    	if (top == null) {
    		return -1;
    	}
    	
    	if (top.left != null) {
    		return 1 + getHeightLeft(top.left);
    	}
    	
    	return 0;
    }
    
    private int getHeightRight(Node top) {
    	
    	if (top == null) {
    		return -1;
    	}
    	
    	if (top.right != null){
    		return 1 + getHeightRight(top.right);
    	}
    	
    	return 0;
    }
    
    
    
    
    
    // tree is height-balanced if at each node, the heights
    // of the node's two subtrees differs by no more than 1.
    //  Special note about null subtrees:
    //            10
    //              \
    //               20
    // Notice in this example that 10's left subtree is null,
    // and its right subtree has height 0. We would consider this
    // to be a balanced tree. If the tree is empty, return true;
    public boolean isBalanced() {
    	
    	if (root == null) {
    		return true;
    	}
    	
    	int leftHeight = getHeightLeft(root);
    	int rightHeight = getHeightRight(root);
    	
    	if (leftHeight - rightHeight > 1 || leftHeight - rightHeight < -1) {
    		return false;
    	}
    	
        return true;
    }
    
    // computes the sum of the nodes in this BST.  
    public int sum() {
        return sum(root);
    }
    private int sum(Node top) {
    	
    	if (top == null) {
    		return 0;
    	}
    	
    	return top.data + sum(top.left) + sum(top.right);
    }
    
    // returns the largest value of all the leaves
    // If the tree is empty, throw an IllegalStateException()
    public int maxLeaf() {
    	if (isEmpty()) {
    		throw new IllegalStateException("Tree is empty!");
    	}
    	
        return maxLeaf(root);
    }
    
    private int maxLeaf(Node top) {
    	
    	if (top.right != null) {
    		return maxLeaf(top.right);
    	}
    	
    	if (top.right == null && top.left != null) {
    		return maxLeaf(top.left);
    	}
    	
    	return top.data;
    }
    
    
    
    
    // counts the number of nodes in this BST
    public int nodeCount() {
        return nodeCount(root);
    }
    
    private int nodeCount(Node top) {
    	
    	if (top == null) {
    		return 0;
   	    }
    	
    	return 1 + nodeCount(top.left) + nodeCount(top.right);
    	
    }
    
    // returns the "level" of the value in a tree.
    // the root is considered level 0
    // the children of the root are level 1
    // the children of the children of the root are level 2
    // and so on.  If a value does not appear in the tree, return -1
    //              15
    //             /  \
    //            10  28
    //              \   \
    //              12  40
    //                 /
    //                30
    // In the tree above:
    // getLevel(15) would return 0
    // getLevel(10) would return 1
    // getLevel(30) would return 3
    // getLevel(8) would return -1
    public int getLevel(int n) {
        return getLevel(root, n);
    }
    
    private int getLevel(Node top, int n) {
    	
    	if (top == null) {
    		return -1;
    		
    	}
    	
    	if (!contains(n)) {
    		return -1;
    	}
    	
    	if (n > top.data) {
    		return 1 + getLevel(top.right, n);
    	}else if (n < top.data) {
    		return 1 + getLevel(top.left, n);
    	}
    	
    	return 0;
    }
    
    
    
    private class Node {
        private int data;
        private Node left, right;
        
        private Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}

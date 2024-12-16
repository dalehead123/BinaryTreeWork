
public class BSTTester {
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		
		// add some values
		bst.add(10);
		bst.add(5);
		bst.add(17);
		bst.add(99);
		bst.add(1); // 1
		bst.add(8);
		bst.add(6);
		//bst.add(500);
		//bst.add(7);
		//bst.add(9);
		//bst.add(500);
		//bst.add(499);
		
		for (int i = 0; i < 1000; i++) {
			if (bst.contains(i)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();

		System.out.println("Does binary search tree contain 99? " + bst.contains(99)); // true
		System.out.println("Min value: " + bst.min()); // 1
		System.out.println("Max value: " + bst.max()); // 99
		System.out.println("Sum of binary search tree: " + bst.sum()); // 146
		System.out.println("The biggest leaf is: " + bst.maxLeaf()); // 99
		System.out.println("the level of 6 is : " + bst.getLevel(6)); // 3
		System.out.println("The node count for the tree is: " + bst.nodeCount()); // 7
		System.out.println("The height of the binary seach tree is: " + bst.getHeight()); // 3
		
		
		
		//bst.inOrderTraversal(); // 1 5 6 8 10 17 99

	}
	
	
	
}

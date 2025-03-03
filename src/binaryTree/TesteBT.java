package binaryTree;

public class TesteBT {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree("+");
		Node pai = tree.addLeftChild("x", tree.root());
		tree.addLeftChild("2", pai);
		pai = tree.addRightChild("-", pai);
		tree.addLeftChild("a", pai);
		tree.addRightChild("1", pai);
		pai = tree.addRightChild("x", tree.root());
		tree.addLeftChild("3", pai);
		tree.addRightChild("b", pai);
		
		tree.inOrder(tree.root());
		System.out.println();
		tree.postOrder(tree.root());
		System.out.println();
		tree.preOrder(tree.root());
		
	}
}

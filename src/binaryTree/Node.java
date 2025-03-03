package binaryTree;

public class Node {
	private	Object element;
	private Node pai;
	private Node left_child;
	private Node right_child;
	
	public Node(Object o, Node pai) {
		setElement(o);
		this.setPai(pai);
		setLeft_child(null);
		setRight_child(null);
	}
	
	public void removeRightChild() {
		right_child = null;
	}
	
	public void removeLeftChild() {
		left_child = null;
	}

	public Node getLeft_child() {
		return left_child;
	}

	public void setLeft_child(Node left_child) {
		this.left_child = left_child;
	}

	public Node getPai() {
		return pai;
	}

	public void setPai(Node pai) {
		this.pai = pai;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public Node getRight_child() {
		return right_child;
	}

	public void setRight_child(Node right_child) {
		this.right_child = right_child;
	}
	
	
}

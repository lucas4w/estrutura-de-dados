package binaryTree;

public class BinaryTree {
	private int tamanho;
	private Node raiz;
	
	public BinaryTree(Object o) {
		raiz = new Node(o,null);
		this.raiz.setLeft_child(null);
		this.raiz.setRight_child(null);
		tamanho = 1;
	}
	
	public void inOrder(Node v) {
		if (v == null)
			return;
		
		if (isInternal(v))
			inOrder(v.getLeft_child());
		
		System.out.print(v.getElement()+ " ");
		
		if (isInternal(v))
				inOrder(v.getRight_child());
	}
	
	public void postOrder(Node v ) {
		if (v == null)
			return;
		
		if (isInternal(v)) {
			postOrder(v.getLeft_child());
			postOrder(v.getRight_child());
		}
		System.out.print(v.getElement() + " ");
	}
	
	public void preOrder(Node v) {
		if (v == null)
			return;
		System.out.print(v.getElement() + " ");
		if (isInternal(v)) {
			postOrder(v.getLeft_child());
			postOrder(v.getRight_child());
		}
	}
	
	public int height(Node v) {
		if (v == null || isExternal(v)) {
			return 0;
		}
		int l = height(v.getLeft_child());
		int r = height(v.getRight_child());
		
		return 1+Math.max(l, r);
	}
	
	public void printExpression(Node v) {
		if (isInternal(v)) {
			System.out.print("(");
			printExpression(v.getLeft_child());
		}
		System.out.print(v.getElement());
		if (isInternal(v)) {
			printExpression(v.getRight_child());
			System.out.print(")");
		}
	}
	
	public int depth(Node v) {
		if (isRoot(v)) {
			return 0;
		}
		else
			return 1+depth(v.getPai());
	}
	
	public Object replace(Node v, Object o) {
		Object aux = v.getElement();
		v.setElement(o);
		return aux;
	}
	
	
	public boolean isExternal(Node v) {
		return v.getLeft_child() == null && v.getRight_child() == null;
	}
	
	public boolean isInternal(Node v) {
		return v.getLeft_child() != null || v.getRight_child() != null;
	}
	
	public Node addLeftChild(Object o, Node pai) {
		Node no = new Node(o,pai);
		pai.setLeft_child(no);
		tamanho++;
		return no;
	}
	
	public Node addRightChild(Object o, Node pai) {
		Node no = new Node(o,pai);
		pai.setRight_child(no);
		tamanho++;
		return no;
	}
	
	public Node parent(Node v) {
		return v.getPai();
	}
	
	public Node root() {
		return raiz;
	}
	
	public int size() {
		return tamanho;
	}
	
	public boolean isRoot(Node v) {
		return v==raiz;
	}
	
	public boolean hasRight(Node v) {
		return v.getRight_child() != null;
	}
	
	public boolean hasLeft(Node v) {
		return v.getLeft_child() != null;
	}
	
	public Node rightChild(Node v) {
		return v.getRight_child();
	}
	
	public Node leftChild(Node v) {
		return v.getLeft_child();
	}
	
	
}

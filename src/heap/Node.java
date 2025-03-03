package heap;

public class Node {
	private Object item;
	private int key;
	private Node pai;
	private Node left_child;
	private Node right_child;
	
	public Node(Object item, int key, Node pai) {
		this.setItem(item);
		this.setKey(key);
		this.setPai(pai);
		setLeft_child(null);
		setRight_child(null);
	}

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Node getPai() {
		return pai;
	}

	public void setPai(Node pai) {
		this.pai = pai;
	}

	public Node getLeft_child() {
		return left_child;
	}

	public void setLeft_child(Node left_child) {
		this.left_child = left_child;
	}

	public Node getRight_child() {
		return right_child;
	}

	public void setRight_child(Node right_child) {
		this.right_child = right_child;
	}
	
	
	
}

package pilhaLigada;

public class Node {
	private Node next;
	private Object element;
	
	public Node(Object o) {
		element = o;
	}
	
	public void setNext(Node node) {
		next = node;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setElement(Object o) {
		element = o;
	}
	
	public Object getElement() {
		return element;
	}
}

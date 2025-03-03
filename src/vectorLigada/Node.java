package vectorLigada;

public class Node {
	private Node next;
	private Node prev;
	private Object elemento;
	
	public Node(Object o) {
		 elemento = o;
	}
		
	public void setElemento(Object o) {
		elemento = o;
	}
	
	public Object getElemento() {
		return elemento;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setPrev(Node prev) {
		this.prev = prev;	
	}
	
	public Node getPrev() {
		return prev;
	}
}
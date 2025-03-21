package filaLigada;

public class Node {
	private Object elemento;
	private Node next;
	
	
	public Node(Object elemento, Node next) {
		this.elemento = elemento;
		this.next = next;
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
		
}

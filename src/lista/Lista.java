package lista;

public class Lista {
	private Node head;
	private Node tail;
	private int tamanho;
	
	public Lista() {
		head = new Node(null);
		tail = new Node(null);
		head.setPrev(null);
		head.setNext(tail);
		tail.setNext(null);
		tail.setPrev(head);
		tamanho = 0;
	}
	
	public int size() {
		return tamanho;
	}
	
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	public void remove(Node no) {
		if (isEmpty())
			return;
		no.getNext().setPrev(no.getPrev());	
		no.getPrev().setNext(no.getNext());
		no = null;
		tamanho--;
	}
	
	public void insertLast(Object o) {
		Node no = new Node(o);
		no.setNext(tail);
		no.setPrev(tail.getPrev());
		tail.getPrev().setNext(no);
		tail.setPrev(no);
		tamanho++;
	}
	
	public void insertFirst(Object o) {
		Node no = new Node(o);
		no.setPrev(head);
		no.setNext(head.getNext());
		head.getNext().setPrev(no);
		head.setNext(no);
		tamanho++;
	}
	
	public void insertAfter(Node no, Object o) {
		Node node = new Node(o);
		node.setPrev(no);
		node.setNext(no.getNext());
		no.getNext().setPrev(node);
		no.setNext(node);
		tamanho++;
	}
	
	public void insertBefore(Node no, Object o) {
		Node node = new Node(o);
		node.setNext(no);
		node.setPrev(no.getPrev());
		no.getPrev().setNext(node);
		no.setPrev(node);
		tamanho++;
	}
	
	public void swapElement(Node no, Node q) {
		Object aux = no.getElemento();
		no.setElemento(q.getElemento());
		q.setElemento(aux);
	}
	
	public Object replaceElement(Node no, Object o) {
		Object aux = no.getElemento();
		no.setElemento(o);
		return aux;
	}
	
	public Node before(Node no) {
		return no.getPrev();
	}
	
	public Node after(Node no) {
		if (no == tail) return tail.getPrev();
		return no.getNext();
	}
	
	public boolean isFirst(Node no) {
		return no == head.getNext();
	}
	
	public boolean isLast(Node no) {
		return no == tail.getPrev();
	}
	
	public void listar() {
		Node current = head.getNext();
		while (current.getNext() != null) {
			System.out.print(current.getElemento() + " ");
			current = current.getNext();
		}
		System.out.println("");
	}
	
	public Node first() {
		return head.getNext();
	}
	
	public Node last() {
		return tail.getPrev();
	}
	
}

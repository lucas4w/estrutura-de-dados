package sequencia;


public class Sequencia {
	private Node head;
	private Node tail;
	private int tamanho;
	
	public Sequencia() {
		head = new Node(null);
		tail = new Node(null);
		head.setPrev(null);
		head.setNext(tail);
		tail.setNext(null);
		tail.setPrev(head);
		tamanho = 0;
	}
	
	public void makeFirst(Node no) {
		if (no == head)
			return;
		no.getNext().setPrev(no.getPrev());
		no.getPrev().setNext(no.getNext());
		no.setPrev(head);
		no.setNext(head.getNext());
		head.getNext().setPrev(no);
		head.setNext(no);
		
	}
	
	public void listar() {
		Node current = head.getNext();
		while (current.getNext() != null) {
			System.out.print(current.getElemento() + " ");
			current = current.getNext();
		}
		System.out.println("");
	}
	
	public int rankOf(Node node) {
		Node current = head.getNext();
		int i = 0;
		while (current != head) {
			if(current == node)
				return i;
			current = current.getNext();
			i++;
		}
		return -1;
	}
	
	public Node atRank(int r) {
	 	Node current= head.getNext();
		int i = 0;
		while (i < r) {
			current = current.getNext();
			i++;
		}
		return current;
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
	
	public Node first() {
		return head.getNext();
	}
	
	public Node last() {
		return tail.getPrev();
	}
	
	
	public Object removeAtRank(int r) {
		Node current = head.getNext();
		int i = 0;
		while (i<r) {
			 current = current.getNext();
			 i++;
		}
		Object o = current.getElemento();
		current.getPrev().setNext(current.getNext());
		current.getNext().setPrev(current.getPrev());
		tamanho--;
		return o;
	}
	
	public void insertAtRank(int r, Object o) {
		Node n = new Node(o);
		if (isEmpty()) {
			n.setNext(tail);
			n.setPrev(head);
			head.setNext(n);
			tail.setPrev(n);
			tamanho++;
			return;
		}
		Node current = head.getNext();
		int i = 0;
		while(i<r) {
			current = current.getNext();
			i++;
		}
		n.setPrev(current.getPrev());
		n.setNext(current);
		current.getPrev().setNext(n);
		current.setPrev(n);
		tamanho++;
	}
	
	public Object replaceAtRank(int r, Object o) {
		Node current= head.getNext();
		int i = 0;
		while(i < r) {
			current = current.getNext();
			i++;
		}
		Object aux = current.getElemento();
		current.setElemento(o);
		return aux;
	}
	
	public Object elemAtRank(int r) {
		Node current = head.getNext();
		int i = 0;
		while(i < r) {
			current = current.getNext();
			i++;
		}
		return current.getElemento();
	}
	
	public boolean isEmpty() {
		return tamanho == 0;
	}
}

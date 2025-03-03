package vectorLigada;

public class Vector {
	private Node head;
	private Node tail;
	private int tamanho;
	
	public Vector() {
		head = new Node(null);
		tail = new Node(null);
		head.setPrev(null);
		head.setNext(tail);
		tail.setPrev(head);
		tail.setNext(null);
		tamanho = 0;
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
		int i = 0;
		Node current = head.getNext();
		while (i<r) {
			current = current.getNext();
			i++;
		}
		Object aux = current.getElemento();
		current.setElemento(o);
		return aux;
	}
	
	public Object elementAtRank(int r) {
		int i = 0;
		Node current = head.getNext();
		while(i < r) {
			current = current.getNext();
			i++;
		}
		return current.getElemento();
	}
	
	public void listar() {
		Node current = head.getNext();
		while(current.getNext()!=null) {
			System.out.print(current.getElemento()+" ");
			current = current.getNext();
		}
		System.out.println("");
	}
	
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
}


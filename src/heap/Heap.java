package heap;

public class Heap {
	private int tamanho;
	private Node raiz;
	private Node last;
	
	public Heap(Object item, int key) {
		raiz = new Node(item,key,null);
		tamanho = 1;
		last = raiz;
	}
	
	public int size() {
		return tamanho;
	} 
	
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	public Node raiz() {
		return raiz;
	}
	
	public Object min() {
		return raiz.getKey();
	}
	
	private boolean isRoot(Node node) {
		return node.equals(raiz);
	}
	
	public void swapKeys(Node no1, Node no2) {
		int aux = no1.getKey();
		no1.setKey(no2.getKey());
		no2.setKey(aux);
	}
	
	public Node insert(int key) {
		Node pai = nextNode();
		Node newno = new Node("aa",key,pai);
		
		if (pai.getLeft_child() == null)
			pai.setLeft_child(newno);
		else
			pai.setRight_child(newno);
		
		upHeap(newno);
		this.tamanho++;
		this.last = newno;
		return newno;
	}
	
	private void upHeap(Node no) {
		
		while (!isRoot(no) && no.getPai().getKey() > no.getKey()) {
			swapKeys(no,no.getPai());
			no = no.getPai();
		}
	}
	
	private Node nextNode() {
		Node atual = last;
		
		if (isRoot(atual))
			return atual;
		
		while (!isRoot(atual) && !atual.getPai().getLeft_child().equals(atual)) {
			atual = atual.getPai();
		}
		
		if (!isRoot(atual) && atual.getPai().getRight_child() == null) {
			return atual.getPai();
		}
		else if (!isRoot(atual) && atual.getPai().getRight_child() != null)
			atual = atual.getPai().getRight_child();
		
		while (atual.getLeft_child() != null)
			atual = atual.getLeft_child();
		
		return atual;
	}
	
	public boolean isInternal(Node no ) {
		return no.getLeft_child() != null || no.getRight_child() != null;
	}
	
	public boolean isExternal(Node no) {
		return no.getLeft_child() == null && no.getRight_child() == null;
	}
	
	public void inOrder(Node v) {
		if (v == null)
			return;
		
		if (isInternal(v))
			inOrder(v.getLeft_child());
		System.out.print(v.getKey()+ " ");
		if (isInternal(v))
			inOrder(v.getRight_child());
	}
	
	public int removeMin() {
		int min = raiz.getKey();
		swapKeys(raiz,last);
		
		Node newlast = newLastNode();
		if (last.getPai().getRight_child() == null)
			last.getPai().setLeft_child(null);
		else
			last.getPai().setRight_child(null);
		
		downHeap();
		this.tamanho--;
		this.last = newlast;
		 
		return min;
	}
	
	private Node newLastNode() {
		Node atual = last;
		if (isRoot(atual))
			return atual;
		
		while (!isRoot(atual) && atual.getPai().getRight_child()==null)
			atual = atual.getPai();
		
		if (isRoot(atual) && atual.getPai().getLeft_child() == null)
			return atual.getPai();
		else if (!isRoot(atual) && atual.getPai().getLeft_child() != null)
			atual = atual.getPai().getLeft_child();
		
		while (atual.getRight_child() != null)
			atual = atual.getRight_child();
		
		return atual;
	}
	
	private void downHeap() {
		Node no = raiz;
		Node oldno = raiz;
		
		while (!isExternal(no)) {
			no = down(no);
			if (no.getKey() < oldno.getKey())
				swapKeys(oldno,no);
			else
				break;
		}
	}
	private Node down(Node no) {
		if (isInternal(no)) {
			if (no.getLeft_child() == null && no.getRight_child() != null)
				no = no.getRight_child();
			else if (no.getRight_child() == null && no.getLeft_child() != null)
				no = no.getLeft_child();
			else if (no.getLeft_child().getKey() < no.getRight_child().getKey())
				no = no.getLeft_child();
			else
				no = no.getRight_child();
	
		}
		return no;
	}
}













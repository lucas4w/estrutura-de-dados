package bsTree;


public class BStree {
	private Node raiz;
	private int tamanho;
	
	public BStree(Object o) {
		Node raiz = new Node(o, null);
		raiz.setLeft_child(null);
		raiz.setRight_child(null);
		this.raiz = raiz;
		tamanho = 1;
	}
	
	public Node remove(Object key){
		Node no = search(key,raiz);
		
		if (no.getElement() != key || no == null) return null;
		
		if (no.childCount() == 0)
			removeFolha(no);
		else if (no.childCount() == 1)
			removePaiDeUm(no);
		else
			removePaiDeDois(no);
			
		tamanho--;
		return no;
	}
	
	public int altura(Node v) {
		if (v == raiz || v == null)
			return 0;
		int l = altura(v.getLeft_child());
		int r = altura(v.getRight_child());
		
		return 1+ Math.max(l,r);
	}
	
	public void printTree(Node node, int level) {
	    if (node == null) {
	        return;
	    }

	    // Espaçamento para simular níveis
	    for (int i = 0; i < level; i++) {
	        System.out.print("   ");
	    }

	    // Imprime o valor do nó
	    System.out.println(node.getElement());

	    // Recursivamente imprime os filhos esquerdo e direito
	    printTree(node.getLeft_child(), level + 1);
	    printTree(node.getRight_child(), level + 1);
	}
	
	public int profundidade(Node v) {
		if (v == raiz)
			return 0;
		return 1 + profundidade(v.getPai());
	}
	
	private void removePaiDeDois(Node v) {
		Node sucessor = encontraMenor(v.getRight_child());
		v.setElement(sucessor.getElement());
		remove(sucessor);
	}
	
	private void removePaiDeUm(Node no) {
		Node pai = no.getPai();
		
		Node filho = (hasLeft(no)) ? no.getLeft_child() : no.getRight_child();
		
		if (pai == null)
			raiz = filho;
		else if (pai.getLeft_child() == no)
			pai.setLeft_child(filho);
		else
			pai.setRight_child(filho);
		filho.setPai(pai);
	}
	
	private void removeFolha(Node no) {
		Node pai = no.getPai();
		
		if (pai == null)
			raiz = null;
		else if (pai.getLeft_child() == no)
			pai.setLeft_child(null);
		else
			pai.setRight_child(null);
	}
	
	public Node search(Object k, Node v) {
		if (isExternal(v))
			return v;
	
		if ((int) k < (int) v.getElement()) {
			if (v.getLeft_child() == null)
				return v;
			return search(k,v.getLeft_child());
		}
		else if ((int) k == (int) v.getElement())
			return v;
		else {
			if (v.getRight_child() == null)
				return v;
			return search(k,v.getRight_child());
		}
	}
	
	public Node encontraMenor(Node no) {
		if (no == null) return no;
		while (no.getLeft_child() != null)
			no = no.getLeft_child();
		return no;
	}
	
	public Node add(Object key){
		Node pai = search(key, raiz);
		
		Node newnode = new Node(key,pai);
		
		if (pai.getElement()==key) return null;
		
		if ((int) key > (int) pai.getElement()) {
			System.out.println("Adicionando " + key + " como filho de direito de " + pai.getElement());
			pai.setRight_child(newnode);
		}
		else {
			pai.setLeft_child(newnode);
			System.out.println("Adicionando " + key + " como filho de esquerdo de " + pai.getElement());
		}	
		tamanho++;
		return newnode;
	}
	
	public void visiteSe(int element,int a,int b) {
		if (element > a && b > element) {
			System.out.println(element);
		}
	}
	
	public void prova(Node n, int a, int b) {
		if (n==null) {
			return;
		}
		prova(n.getLeft_child(),a,b);
		visiteSe((int) n.getElement(),a,b);
		prova(n.getRight_child(),a,b);
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
	
	public boolean isExternal(Node v) {
		return v.getLeft_child() == null && v.getRight_child() == null;
	}
	
	public boolean isInternal(Node v) {
		return v.getLeft_child() != null || v.getRight_child() != null;
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

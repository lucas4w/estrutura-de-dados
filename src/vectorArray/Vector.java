package vectorArray;

public class Vector {
	private	Object[] array;
	private int tamanho;
	private int capacidade;
	
	public Vector(int capacidade) {
		this.capacidade = capacidade;
		array = new Object[this.capacidade];
		tamanho = 0;
	}
	
	
	//O(n) para deslocar
	public Object removeAtRank(int r) {
		Object o = array[r];
		if (r>=tamanho)
			throw new IndexOutOfBoundsException();
		for (int i = r; i < tamanho;i++) {
			array[i] = array[i+1];
		}
		tamanho--;
		return o;
	}
	
	//O(n)
	public void insertAtRank(int r, Object o) {
		if (tamanho == capacidade) {
			capacidade *= 2;
			Object[] aux = new Object[capacidade];
			for (int i = 0; i < tamanho; i++) 
				aux[i] = array[i];		
			array = aux;
		}
		if (r>tamanho)
			throw new IndexOutOfBoundsException();
		for (int i = tamanho; i > r; i--) {
			array[i] = array[i-1];
		}
		array[r] = o;
		tamanho++;
	}
	
	public Object replaceAtRank(int r, Object o) {
		if (r>=tamanho)
			throw new IndexOutOfBoundsException();
		Object aux = array[r];
		array[r] = o;
		return aux;
	}
	
	public Object elementAtRank(int r){
		if (r>=tamanho)
			throw new IndexOutOfBoundsException();
		return array[r];
	}
	
	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	public void listar() {
		for (int i = 0; i < tamanho; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
		
	}
	
	public int size() {
		return tamanho;
	}
}

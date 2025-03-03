package heap;

public class HeapArray {
	private int[] heap;
	private int size;
	
	public HeapArray(int capacidade) {
		heap = new int[capacidade];
		size = 0;
	}
	
	public void insert(int value) {
		if (heap.length == size) {
			System.out.println("Cheio");
			return;
		}
		heap[size] = value;
		upHeap(size);
		size++;
	}
	
	public int removeMin() {
		if (isEmpty())
			return -1;
		int min = heap[0];
		size--;
		swapKeys(0,size);
		downHeap(0);
		return min;
	}
	
	private void downHeap(int index) {
		int left = get_LeftChild(index);
		int right = get_RightChild(index);
		int smallest = index;
		
		if (left < size && heap[left] < heap[smallest])
			smallest = left;
		
		if (right < size && heap[right] < heap[smallest])
			smallest = right;
		
		if (smallest != index) {
			swapKeys(index,smallest);
			downHeap(smallest);
		}
	}
	
	private void upHeap(int index) {
		while (index > 0  && heap[getPai(index)] > heap[index]) {
			swapKeys(index,getPai(index));
			index = getPai(index);
		}
	}
	
	 private void swapKeys(int i, int k) {
		 int aux = heap[k];
		 heap[k] = heap[i];
		 heap[i] = aux;
	 }
	 
	 public int min() {
		 if (isEmpty())
			 return -1;
		 return heap[0];
	 }
	 
	 public void mostrar() {
		 for (int i = 0;i < size; i++) {
			 System.out.print(heap[i] + " ");
		 }
		 System.out.println();
	 }
	
	 public boolean isEmpty() {
		 return size==0;
	 }
	 
	public int getPai(int i) {
		return (i-1)/2;
	}
	
	public int get_LeftChild(int i) {
		return (2*i)+1;
	}
	
	public int get_RightChild(int i) {
		return (2*i)+2;
	}
	
	public int size() {
		return size;
	}
}

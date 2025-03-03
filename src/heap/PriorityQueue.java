package heap;

public class PriorityQueue {
	private HeapArray heap;
	
	public PriorityQueue(int capacidade) {
		heap = new HeapArray(capacidade);
	}
	
	public void enqueue(int key) {
		heap.insert(key);
	}
	
	public int dequeue() {
		int min = heap.min();
		heap.removeMin();
		return min;
	}
	
	public int peek() {
		return heap.min();
	}
	
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	public void display() {
		heap.mostrar();
	}
}

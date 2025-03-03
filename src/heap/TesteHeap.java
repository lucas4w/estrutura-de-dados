package heap;
import java.util.Random;

public class TesteHeap {
	public static void main(String[] args) {
		Random r = new Random();
		HeapArray ha = new HeapArray(21);
		ha.insert(2);	
		PriorityQueue queue = new PriorityQueue(50);
		
		for (int i = 0; i < 20; i++) {
			queue.enqueue(r.nextInt(400));
		}
		queue.display();
		queue.dequeue();
		System.out.println();
	}	
	private static void print(Node no) {
		System.out.println(no.getKey() + " Tem como filhos:");
		System.out.println(no.getLeft_child().getKey() + " L   R " +no.getRight_child().getKey());
	}
	
	private static void downHeap(int index,int[] arr,int length) {
		int left = (2*index)+1;
		int right = (2*index)+2;
		int smallest = index;
		
		if (left < length && arr[left] < arr[smallest])
			smallest = left;
		
		if (right < length && arr[right] < arr[smallest])
			smallest = right;
		
		if (smallest != index) {
			swapKeys(index,smallest,arr);
			downHeap(smallest,arr,length);
		}
	}
	private static void heapify(int[] arr, int length) {
	    int i = (length / 2) - 1;
	    while (i >= 0) {
	        downHeap(i, arr, length);
	        i--;
	    }
	}
	
	private static void swapKeys(int i, int k,int[] arr) {
		 int aux = arr[k];
		 arr[k] = arr[i];
		 arr[i] = aux;
	 }
}

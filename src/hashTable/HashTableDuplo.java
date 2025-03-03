package hashTable;

public class HashTableDuplo {
	private Item[] table;
	private int size;
	private int capacity;
	
	public HashTableDuplo(int capacity) {
		this.capacity = capacity;
		table = new Item[capacity];
	}
	
	public void insert(int key, Object value) {
		int index = hash(key);
		
		int aux = index;
		
		int d = hashSecondary(key);
		
		int j = 0;
		Item item = table[index];
		while (item != null && item != Item.UNAVAILABLE && item.getKey()!=key) {
			table[index] = new Item(key,value);
			size++;
			if ((double) size/capacity > 0.75) {
				rehash();
			}
			else
				table[index].setValue(value);
		}
	}
	
	private void rehash() {
		Item[] oldTable = table;
		this.capacity = 2*capacity;
		
		while (!isPrimo(capacity))
			capacity++;
		
		table = new Item[capacity];
		size = 0;
		
		for (Item item : oldTable) {
			if (item != null && item != Item.UNAVAILABLE)
				insert(item.getKey(), item.getValue());
		}
	}
	
	public static boolean isPrimo(int numero) {
		for (int i = 2; i<= Math.sqrt(numero);i++) {
			if (numero%i==0)
				return false;
		}
		return true;
	}
	
	private int hash(int x) {
		return x % capacity;
	}
	
	private int hashSecondary(int x) {
		int q = 7;
		return q - (x % q);
	}
}

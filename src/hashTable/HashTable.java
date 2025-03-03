package hashTable;

public class HashTable {
	private Item[] table;
	private int size;
	private int capacity;
	
	public HashTable(int capacity) {
		this.capacity = capacity;
		table = new Item[capacity];
		size = 0;
	}
	
	public Object remove(int key) {
		int index = find(key);
		if (index != -1) {
			Object value = table[index];
			table[index] = Item.UNAVAILABLE;
			size--;
			return value;
		}
		else
			return -1;
	}
	
	public void insert(int key, Object value) {
		int index = hash(key);
		while (table[index] != null && table[index] != Item.UNAVAILABLE && table[index].getKey()!=key) {
			index = (index+1)%capacity;
		} 
		if (table[index] == null || table[index] == Item.UNAVAILABLE) {
			table[index] = new Item(key,value);
			size++;
			
			if ((double) size / capacity > 0.75)
				rehash();
		}
		else
			table[index].setValue(value);
	}
	
	public Object get(int key) {
		int index = find(key);
		if (index != -1)
			return table[index].getValue();
		else
			return -1;
	}
	
	private int find(int key) {
		int index = hash(key);
		int probeCount = 0;
		
		while (probeCount < capacity) {
			Item current = table[index];
			
			if (current == null || current == Item.UNAVAILABLE) {
				return -1;
			}
			else if (current.getKey() == key)
				return index;
			else {
				index = (index+1)%capacity;
				probeCount++;
			}
		}
		return -1;
	}
	
	private void rehash() {
		Item[] oldTable = table;
		table = new Item[2*capacity];
		size = 0;
		
		for (Item item : oldTable) {
			if (item != null && item != Item.UNAVAILABLE) {
				insert(item.getKey(), item.getValue());
			}
		}
	}
	
	private int hash(int x) {
		return x % capacity;
	}
}

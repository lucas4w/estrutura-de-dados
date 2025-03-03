package hashTable;

public class Item {
	private int key;
	private Object value;
	public static final Item UNAVAILABLE = new Item(-1,null);
	
	public Item(int key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	public int getKey() {
		return key;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
}

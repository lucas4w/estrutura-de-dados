package lista;

public class TesteLista {
	public static void main(String[] args) {
		Lista lista = new Lista();
		for (int i = 1; i < 10; i++)
			lista.insertLast(i);
		lista.listar();
		
		Node aux = lista.first();
		for(int i = 0; i < 4; i++)
			aux = lista.after(aux);
		
		System.out.println(aux.getElemento());
		lista.insertAfter(aux, 88);
		lista.listar();
		
		lista.insertFirst(100);
		lista.insertLast(100);
		lista.listar();
		
		lista.remove(lista.first());
		lista.remove(lista.last());
		lista.listar();
		
		lista.swapElement(lista.first(), lista.last());
		lista.listar();
		System.out.println(lista.isFirst(lista.first()));
        System.out.println(lista.isLast(lista.last()));
	}
	
}	

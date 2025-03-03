package FilaArray;

public class Fila implements IFila{
    private int i;
    private	int f;
    private	int N;
    private	int incremento;
    private	int array[];

    public Fila(int tamanho, int incremento){
        N = tamanho;
        this.incremento = incremento;
        array = new int[N];
        i = f = 0;
    }

    public void enqueue(int o){  
        if (size() == N-1){
        	int newN;
            if (incremento == 0){
                newN  = N*2;
            }
            else
                newN = N + incremento;
            int temp[] = new int[newN];
            int k = i;
            for (int j = 0; j < size(); j++){
                temp[j] = array[k]; k = (k + 1) % N;
            }
            array = temp;
            f = size();
            i = 0;
            N = newN;
        }    
        array[f] = o;
        f = (f+1) %N;
        
    }   

    public int dequeue(){
        if (isEmpty())
            throw new FilaVaziaException("Fila vazia");
        int o = array[i];
        i = (i+1) % N;
        return o;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int first(){
        if (isEmpty())
        	throw new FilaVaziaException("Fila vazia");
        return array[i];
    }
    
    public void listar() {
    	if (isEmpty())
    		throw new FilaVaziaException("OKSKO");
    	for (int x = i; x != f; x = (x+1)%N) {
    		System.out.print(array[x]+" ");
    	}
    	System.out.println();
    }

    public int size(){
        return (N - i + f)% N;
    }
}
package Practica3;

public class Cola {
	private long[] arreglo;
    private int inicio;
    private int fin;
    private int n;

    public Cola(int n) {
        this.n = n;
        this.arreglo = new long[n];
        this.inicio = 0;
        this.fin = -1;
    }

    public void insert(long e) {
        if (!isFull()) {
            fin = (fin + 1) % n;
            arreglo[fin] = e;
        } else {
            System.out.println("Cola llena");
        }
    }

    public long remove() {
        if (!isEmpty()) {
            long valor = arreglo[inicio];
            inicio = (inicio + 1) % n;
            return valor;
        } else {
            System.out.println("Cola vacía");
            return -1;
        }
    }

    public long peek() {
        if (!isEmpty()) {
            return arreglo[inicio];
        } else {
            System.out.println("Cola vacía");
            return -1;
        }
    }

    public boolean isEmpty() {
        return inicio == (fin + 1) % n;
    }

    public boolean isFull() {
        return inicio == (fin + 2) % n;
    }

    public int size() {
        return (fin - inicio + n + 1) % n;
    }
}

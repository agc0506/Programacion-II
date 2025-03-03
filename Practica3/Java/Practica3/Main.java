package Practica3;

public class Main {
	public static void main(String[] args) {
        Pila pila = new Pila(5);
        pila.push(10);
        pila.push(20);
        pila.push(30);
        System.out.println("Elemento en la cima: " + pila.peek());
        System.out.println("Elemento eliminado: " + pila.pop());
        System.out.println("Elemento eliminado: " + pila.pop());
        System.out.println("¿Está vacía? " + pila.isEmpty());
        pila.pop();
        System.out.println("¿Está vacía? " + pila.isEmpty());
        pila.pop();
        System.out.println("Prueba de Cola");
        Cola cola = new Cola(5);
        cola.insert(10);
        cola.insert(20);
        cola.insert(30);
        cola.insert(40);
        cola.insert(50);
        System.out.println("¿Cola llena?: " + cola.isFull());
        System.out.println("Elemento en el frente: " + cola.peek());
        System.out.println("Elemento eliminado: " + cola.remove());
        System.out.println("Elemento eliminado: " + cola.remove());
        System.out.println("¿Cola vacía?: " + cola.isEmpty());
        cola.insert(60);
        cola.insert(70);
        System.out.println("Elemento en el frente: " + cola.peek());
        System.out.println("Tamaño de la cola: " + cola.size());
    }
}

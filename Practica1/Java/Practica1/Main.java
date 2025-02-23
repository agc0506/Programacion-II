package Practica1;

public class Main {
	public static void main(String[] args) {
		Punto p1 = new Punto(0,3);
		System.out.println(p1);
		float a[] = p1.coord_cartesianas();
		System.out.println(a[0] + " " + a[1]);
		float b[] = p1.coord_polares();
		System.out.println(b[0] + " " + b[1]);
	}
}
	

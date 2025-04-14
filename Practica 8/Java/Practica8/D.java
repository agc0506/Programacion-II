package Practica8;

public class D extends A {
	private B b;

    public D(int x, int y, int z) {
        super(x, z);
        b = new B(y, z);
    }

    public void incrementaXYZ() {
        x++;
        b.y++;
        z++;
    }

    public void mostrar() {
        System.out.println("x = " + x);
        System.out.println("y = " + b.y);
        System.out.println("z = " + z);
    }
}
	


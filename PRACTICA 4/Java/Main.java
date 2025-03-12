abstract class FiguraGeometrica {
    public abstract double calcularArea();
}

class Circulo extends FiguraGeometrica {
    public double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return 3.1416 * radio * radio;
    }
}

class Rectangulo extends FiguraGeometrica {
    public double base;
    public double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }
}

class Triangulo extends FiguraGeometrica {
    public double base;
    public double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return 0.5 * base * altura;
    }
}

class Trapecio extends FiguraGeometrica {
    public double lado1;
    public double lado2;
    public double altura;

    public Trapecio(double lado1, double lado2, double altura) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return ((lado1 + lado2) * altura) / 2;
    }
}

class Pentagono extends FiguraGeometrica {
    public double lado;
    public double apotema;

    public Pentagono(double lado, double apotema) {
        this.lado = lado;
        this.apotema = apotema;
    }

    @Override
    public double calcularArea() {
        return (5 * lado * apotema) / 2;
    }
}

public class Main {
    public static void main(String[] args) {
        FiguraGeometrica circulo = new Circulo(5);
        FiguraGeometrica rectangulo = new Rectangulo(4, 6);
        FiguraGeometrica triangulo = new Triangulo(4, 6);
        FiguraGeometrica trapecio = new Trapecio(3, 5, 4);
        FiguraGeometrica pentagono = new Pentagono(3, 5);

        System.out.println("Área del círculo: " + circulo.calcularArea());
        System.out.println("Área del rectángulo: " + rectangulo.calcularArea());
        System.out.println("Área del triángulo: " + triangulo.calcularArea());
        System.out.println("Área del trapecio: " + trapecio.calcularArea());
        System.out.println("Área del pentágono: " + pentagono.calcularArea());
    }
}

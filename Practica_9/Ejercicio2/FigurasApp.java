import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.Ellipse2D;

// Interfaz Coloreado
interface Coloreado {
    String comoColorear();
}

// Clase abstracta Figura
abstract class Figura {
    protected String color;

    public Figura(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double area();
    public abstract double perimetro();
    public abstract void dibujar(Graphics2D g, int x, int y);
}

// Cuadrado
class Cuadrado extends Figura implements Coloreado {
    private int lado;

    public Cuadrado(int lado, String color) {
        super(color);
        this.lado = lado;
    }

    public double area() {
        return lado * lado;
    }

    public double perimetro() {
        return 4 * lado;
    }

    public String comoColorear() {
        return "Colorear los cuatro lados";
    }

    public void dibujar(Graphics2D g, int x, int y) {
        g.setColor(Color.decode(color));
        g.fillRect(x, y, lado, lado);
    }

    public String toString() {
        return "Cuadrado - Lado: " + lado + ", Color: " + color;
    }
}

// Círculo
class Circulo extends Figura {
    private int radio;

    public Circulo(int radio, String color) {
        super(color);
        this.radio = radio;
    }

    public double area() {
        return Math.PI * radio * radio;
    }

    public double perimetro() {
        return 2 * Math.PI * radio;
    }

    public void dibujar(Graphics2D g, int x, int y) {
        g.setColor(Color.decode(color));
        g.fill(new Ellipse2D.Double(x, y, 2 * radio, 2 * radio));
    }

    public String toString() {
        return "Círculo - Radio: " + radio + ", Color: " + color;
    }
}

// Panel para dibujar figuras
class PanelDibujo extends JPanel {
    private java.util.List<Figura> figuras;

    public void setFiguras(java.util.List<Figura> figuras) {
        this.figuras = figuras;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (figuras == null) return;
        Graphics2D g2 = (Graphics2D) g;
        int x = 20, y = 20;
        for (Figura f : figuras) {
            f.dibujar(g2, x, y);
            y += 120;
        }
    }
}

// Clase principal
public class FigurasApp extends JFrame {
    private JTextArea texto;
    private PanelDibujo panelDibujo;

    public FigurasApp() {
        setTitle("Figuras Coloreadas");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel dibujo
        panelDibujo = new PanelDibujo();
        panelDibujo.setPreferredSize(new Dimension(400, 600));
        add(panelDibujo, BorderLayout.WEST);

        // Panel info
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BorderLayout());

        JButton generar = new JButton("Generar Figuras");
        panelDerecho.add(generar, BorderLayout.NORTH);

        texto = new JTextArea();
        texto.setEditable(false);
        JScrollPane scroll = new JScrollPane(texto);
        panelDerecho.add(scroll, BorderLayout.CENTER);

        add(panelDerecho, BorderLayout.CENTER);

        // Acción del botón
        generar.addActionListener(e -> generarFiguras());

        setVisible(true);
    }

    private void generarFiguras() {
        java.util.List<Figura> figuras = new ArrayList<>();
        String[] colores = {"#FF0000", "#00FF00", "#0000FF", "#FFFF00", "#000000"};
        Random rand = new Random();
        texto.setText("");

        for (int i = 0; i < 5; i++) {
            int tipo = rand.nextInt(2);
            String color = colores[rand.nextInt(colores.length)];

            if (tipo == 0) {
                int lado = rand.nextInt(60) + 40;
                Cuadrado c = new Cuadrado(lado, color);
                figuras.add(c);
                texto.append(c.toString() + "\nÁrea: " + c.area() + "\nPerímetro: " + c.perimetro() +
                        "\n" + c.comoColorear() + "\n--------------\n");
            }else {
                int radio = rand.nextInt(30) + 20;
                Circulo ci = new Circulo(radio, color);
                figuras.add(ci);
                texto.append(ci.toString() + "\nÁrea: " + ci.area() + "\nPerímetro: " + ci.perimetro() +
                        "\n--------------------------\n");
            }
        }

        panelDibujo.setFiguras(figuras);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FigurasApp());
    }
}





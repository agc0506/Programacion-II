package Practica2;
import javax.swing.*;
import java.awt.*;
public class Main {
	public static void main(String[] args) {
        Punto p1 = new Punto(5, 10);
        Punto p2 = new Punto(100, 20);
        Circulo circulo1 = new Circulo(p1, p1.coord_polares()[0]);
        Circulo circulo2 = new Circulo(p2, p2.coord_polares()[0]);
        JFrame ventana = new JFrame("Dibujo de Línea y Círculos");
        DibujarPanel panel = new DibujarPanel(p1, p2, circulo1, circulo2);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 600);
        ventana.setLocationRelativeTo(null);
        ventana.add(panel);
        ventana.setVisible(true);
    }

    static class DibujarPanel extends JPanel {
        private Punto p1, p2;
        private Circulo circulo1, circulo2;

        public DibujarPanel(Punto p1, Punto p2, Circulo circulo1, Circulo circulo2) {
            this.p1 = p1;
            this.p2 = p2;
            this.circulo1 = circulo1;
            this.circulo2 = circulo2;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int p1X = centerX + (int) p1.x;
            int p1Y = centerY + (int) p1.y;
            int p2X = centerX + (int) p2.x;
            int p2Y = centerY + (int) p2.y;
            g.setColor(Color.BLACK);
            g.drawLine(p1X, p1Y, p2X, p2Y);
            g.drawString("P1" + p1.toString(), p1X + 10, p1Y);
            g.drawString("P2" + p2.toString(), p2X + 10, p2Y);
            circulo1.dibujaCirculo(g, centerX, centerY);
            circulo2.dibujaCirculo(g, centerX, centerY);
        }
    }
}


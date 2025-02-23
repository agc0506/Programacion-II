package Practica2;
import javax.swing.*;
import java.awt.*;
public class Linea {
	public Punto p1;
	public Punto p2;
	public Linea(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
	public String toString() {
        return "Línea de " + p1 + " a " + p2;
    }
	public class dibujaLinea extends JPanel {
        private int x1, y1, x2, y2;
        public dibujaLinea(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.drawLine(x1, y1, x2, y2);
            g.setColor(Color.BLACK);
            g.drawString("P1" + p1.toString(), x1 + 10, y1);
            g.drawString("P2" + p2.toString(), x2 + 10, y2);
        }
    }
}

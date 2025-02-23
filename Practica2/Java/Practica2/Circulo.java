package Practica2;
import javax.swing.*;
import java.awt.*;
public class Circulo {
	public Punto centro;
	public float radio;
	public Circulo(Punto centro, float radio) {
		this.centro=centro;
		this.radio=radio;
	}
	@Override
	public String toString() {
		return String.format("Círculo con centro en %s y radio %.2f", centro, radio);
	}
	public void dibujaCirculo(Graphics g, int centerX, int centerY) {
         int x = centerX + (int) centro.x - (int) radio;
         int y = centerY + (int) centro.y - (int) radio;
         int diameter = (int) (2 * radio);

         g.setColor(Color.RED);
         g.drawOval(x, y, diameter, diameter);
     }
}

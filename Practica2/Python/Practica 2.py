import math
import matplotlib.pyplot as plt
import matplotlib.patches as patches
import matplotlib.pyplot as plt
class Punto:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def coord_cartesianas(self):
        return [self.x, self.y]

    def coord_polares(self):
        radio = (self.x ** 2 + self.y ** 2) ** 0.5
        angulo = math.degrees(math.atan2(self.y, self.x))
        return [radio, angulo]

    def __str__(self):
        return f"({self.x:.2f}, {self.y:.2f})"

class Circulo:
    def __init__(self, centro, radio):
        self.centro = centro
        self.radio = radio

    def __str__(self):
        return f"Círculo con centro en {self.centro} y radio {self.radio:.2f}"

    def dibujaCirculo(self, ax):
        circulo = patches.Circle((self.centro.x, self.centro.y), self.radio, edgecolor='r', facecolor='none')
        ax.add_patch(circulo)
        ax.text(self.centro.x + 10, self.centro.y, f"Centro{self.centro}", color='r')
class Linea:
    def __init__(self, p1, p2):
        self.p1 = p1
        self.p2 = p2

    def __str__(self):
        return f"Línea de {self.p1} a {self.p2}"

    def dibujaLinea(self, ax):
        ax.plot([self.p1.x, self.p2.x], [self.p1.y, self.p2.y], 'k-')
        ax.text(self.p1.x + 10, self.p1.y, f"P1{self.p1}", color='k')
        ax.text(self.p2.x + 10, self.p2.y, f"P2{self.p2}", color='k')

def main():
    p1 = Punto(5, 10)
    p2 = Punto(100, 20)

    circulo1 = Circulo(p1, p1.coord_polares()[0])
    circulo2 = Circulo(p2, p2.coord_polares()[0])

    print(f"P1: {p1}")
    print(f"P2: {p2}")
    linea = Linea(p1, p2)
    print(linea)
    print(circulo1)
    print(circulo2)

    fig, ax = plt.subplots()
    ax.set_aspect('equal')
    ax.set_xlim(-50, 200)
    ax.set_ylim(-50, 200)

    linea.dibujaLinea(ax)
    circulo1.dibujaCirculo(ax)
    circulo2.dibujaCirculo(ax)

    plt.show()

if __name__ == "__main__":
    main()

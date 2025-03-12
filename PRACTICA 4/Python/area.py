class FiguraGeometrica:
    def calcular_area(self):
        pass

class Circulo(FiguraGeometrica):
    def __init__(self, radio):
        self.radio = radio

    def calcular_area(self):
        return 3.1416 * self.radio * self.radio

class Rectangulo(FiguraGeometrica):
    def __init__(self, base, altura):
        self.base = base
        self.altura = altura

    def calcular_area(self):
        return self.base * self.altura

class Triangulo(FiguraGeometrica):
    def __init__(self, base, altura):
        self.base = base
        self.altura = altura

    def calcular_area(self):
        return 0.5 * self.base * self.altura

class Trapecio(FiguraGeometrica):
    def __init__(self, lado1, lado2, altura):
        self.lado1 = lado1
        self.lado2 = lado2
        self.altura = altura

    def calcular_area(self):
        return ((self.lado1 + self.lado2) * self.altura) / 2

class Pentagono(FiguraGeometrica):
    def __init__(self, lado, apotema):
        self.lado = lado
        self.apotema = apotema

    def calcular_area(self):
        return (5 * self.lado * self.apotema) / 2

circulo = Circulo(radio=5)
rectangulo = Rectangulo(base=4, altura=6)
triangulo = Triangulo(base=4, altura=6)
trapecio = Trapecio(lado1=3, lado2=5, altura=4)
pentagono = Pentagono(lado=3, apotema=5)

print("Área del círculo:", circulo.calcular_area())
print("Área del rectángulo:", rectangulo.calcular_area())
print("Área del triángulo:", triangulo.calcular_area())
print("Área del trapecio:", trapecio.calcular_area())
print("Área del pentágono:", pentagono.calcular_area())

import math

class EcuacionCuadratica:
    def __init__(self, a, b, c):
        self.a = a
        self.b = b
        self.c = c

    def getDiscriminante(self):
        return self.b**2 - 4*self.a*self.c

    def getRaiz1(self):
        discriminante = self.getDiscriminante()
        if discriminante >= 0:
            return (-self.b + math.sqrt(discriminante)) / (2 * self.a)
        return None

    def getRaiz2(self):
        discriminante = self.getDiscriminante()
        if discriminante > 0:
            return (-self.b - math.sqrt(discriminante)) / (2 * self.a)
        return None

    def resolver(self):
        discriminante = self.getDiscriminante()

        if discriminante > 0:
            r1, r2 = self.getRaiz1(), self.getRaiz2()
            print(f"La ecuación tiene dos raíces {r1:.5f} y {r2:.5f}")
        elif discriminante == 0:
            r1 = self.getRaiz1()
            print(f"La ecuación tiene una raíz {r1:.5f}")
        else:
            print("La ecuación no tiene raíces reales")

a, b, c = map(float, input("Ingrese a, b, c: ").split())

ecuacion = EcuacionCuadratica(a, b, c)
ecuacion.resolver()

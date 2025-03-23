import math

class promedio:
    def __init__(self, lista_numeros):
        self.lista_numeros = lista_numeros
        self.valor = self.calcular()

    def calcular(self):
        return sum(self.lista_numeros) / len(self.lista_numeros)

class desviacion:
    def __init__(self, lista_numeros, promedio):
        self.lista_numeros = lista_numeros
        self.promedio = promedio
        self.valor = self.calcular()

    def calcular(self):
        suma_cuadrados = sum((x - self.promedio.valor) ** 2 for x in self.lista_numeros)
        return math.sqrt(suma_cuadrados / (len(self.lista_numeros) - 1))

numeros = list(map(float, input("Ingrese 10 números separados por espacio: ").split()))

if len(numeros) != 10:
    print("Debe ingresar exactamente 10 números.")
else:
    promedio = promedio(numeros)
    desviacion = desviacion(numeros, promedio)

    print(f"El promedio es {promedio.valor:.2f}")
    print(f"La desviación estándar es {desviacion.valor:.5f}")

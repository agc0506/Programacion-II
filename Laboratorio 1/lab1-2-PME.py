import math

def promedio(lista_numeros):
    return sum(lista_numeros) / len(lista_numeros)

def desviacion(lista_numeros):
    media = promedio(lista_numeros)
    suma_cuadrados = sum((x - media) ** 2 for x in lista_numeros)
    return math.sqrt(suma_cuadrados / (len(lista_numeros) - 1))

numeros = list(map(float, input("Ingrese 10 números separados por espacio: ").split()))

if len(numeros) != 10:
    print("Debe ingresar exactamente 10 números.")
else:
    print(f"El promedio es {promedio(numeros):.2f}")
    print(f"La desviación estándar es {desviacion(numeros):.5f}")

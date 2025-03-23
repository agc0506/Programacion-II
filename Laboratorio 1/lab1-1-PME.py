import math

def getDiscriminante(a, b, c):
    return b ** 2 - 4 * a * c

def getRaiz1(a, b, discriminante):
    return (-b + math.sqrt(discriminante)) / (2 * a)

def getRaiz2(a, b, discriminante):
    return (-b - math.sqrt(discriminante)) / (2 * a)

def resolver_ecuacion(a, b, c):
    discriminante = getDiscriminante(a, b, c)

    if discriminante > 0:
        r1 = getRaiz1(a, b, discriminante)
        r2 = getRaiz2(a, b, discriminante)
        print(f"La ecuación tiene dos raíces {r1:.5f} y {r2:.5f}")
    elif discriminante == 0:
        r1 = -b / (2 * a)
        print(f"La ecuación tiene una raíz {r1:.5f}")
    else:
        print("La ecuación no tiene raíces reales")

a, b, c = map(float, input("Ingrese a, b, c: ").split())
resolver_ecuacion(a, b, c)

import random

class Juego:
    def __init__(self):
        self.numeroDeVidas = 3
        self.record = 0

    def reiniciaPartida(self):
        self.numeroDeVidas = 3

    def actualizaRecord(self):
        if self.numeroDeVidas > self.record:
            self.record = self.numeroDeVidas
            print(f"¡Nuevo récord! Vidas restantes: {self.record}")

    def quitaVida(self):
        self.numeroDeVidas -= 1
        if self.numeroDeVidas > 0:
            print(f"Te quedan {self.numeroDeVidas} vidas.")
            return True
        else:
            print("¡Has perdido todas tus vidas!")
            return False


class JuegoAdivinaNumero(Juego):
    def __init__(self, numeroDeVidas):
        super().__init__()
        self.numeroDeVidas = numeroDeVidas
        self.numeroAAdivinar = 0

    def juega(self):
        self.reiniciaPartida()
        self.numeroAAdivinar = random.randint(0, 10)
        print("Adivina un número entre 0 y 10.")

        while True:
            try:
                guess = int(input("Introduce tu número: "))
            except ValueError:
                print("Por favor, introduce un número válido.")
                continue

            if guess == self.numeroAAdivinar:
                print("¡Acertaste!")
                self.actualizaRecord()
                break
            else:
                if not self.quitaVida():
                    break
                if guess < self.numeroAAdivinar:
                    print("El número a adivinar es mayor.")
                else:
                    print("El número a adivinar es menor.")


class Aplicacion:
    @staticmethod
    def main():
        juego = JuegoAdivinaNumero(3)
        juego.juega()


if __name__ == "__main__":
    Aplicacion.main()

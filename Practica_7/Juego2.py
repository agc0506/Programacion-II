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

    def validaNumero(self, numero):
        return 0 <= numero <= 10

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

            if not self.validaNumero(guess):
                print("El número debe estar entre 0 y 10.")
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


class JuegoAdivinaPar(JuegoAdivinaNumero):
    def validaNumero(self, numero):
        if super().validaNumero(numero) and numero % 2 == 0:
            return True
        else:
            print("Error: El número debe ser par y estar entre 0 y 10.")
            return False


class JuegoAdivinaImpar(JuegoAdivinaNumero):
    def validaNumero(self, numero):
        if super().validaNumero(numero) and numero % 2 != 0:
            return True
        else:
            print("Error: El número debe ser impar y estar entre 0 y 10.")
            return False


class Aplicacion:
    @staticmethod
    def main():
        juegoNumero = JuegoAdivinaNumero(3)
        juegoPar = JuegoAdivinaPar(3)
        juegoImpar = JuegoAdivinaImpar(3)

        print("\n--- Juego Adivina un Número ---")
        juegoNumero.juega()

        print("\n--- Juego Adivina un Número Par ---")
        juegoPar.juega()

        print("\n--- Juego Adivina un Número Impar ---")
        juegoImpar.juega()


if __name__ == "__main__":
    Aplicacion.main()

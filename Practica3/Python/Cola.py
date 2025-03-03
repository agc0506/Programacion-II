class Cola:
    def __init__(self, n):
        self.n = n
        self.arreglo = [0] * n
        self.inicio = 0
        self.fin = -1

    def insert(self, e):
        if not self.isFull():
            self.fin = (self.fin + 1) % self.n
            self.arreglo[self.fin] = e
        else:
            print("Cola llena")

    def remove(self):
        if not self.isEmpty():
            valor = self.arreglo[self.inicio]
            self.inicio = (self.inicio + 1) % self.n
            return valor
        else:
            print("Cola vacía")
            return -1

    def peek(self):
        if not self.isEmpty():
            return self.arreglo[self.inicio]
        else:
            print("Cola vacía")
            return -1

    def isEmpty(self):
        return self.inicio == (self.fin + 1) % self.n

    def isFull(self):
        return self.inicio == (self.fin + 2) % self.n

    def size(self):
        return (self.fin - self.inicio + self.n + 1) % self.n
if __name__ == "__main__":
    cola = Cola(5)

    cola.insert(10)
    cola.insert(20)
    cola.insert(30)
    cola.insert(40)
    cola.insert(50)

    print("¿Cola llena?:", cola.isFull())

    print("Elemento en el frente:", cola.peek())

    print("Elemento eliminado:", cola.remove())
    print("Elemento eliminado:", cola.remove())

    print("¿Cola vacía?:", cola.isEmpty())

    cola.insert(60)
    cola.insert(70)

    print("Elemento en el frente:", cola.peek())
    print("Tamaño de la cola:", cola.size())

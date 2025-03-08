// Clase que gestiona las reservas de boletos en un teatro utilizando un Árbol Binario de Búsqueda (BST).
class GestorBoletos {
    private Nodo raiz; // Nodo raíz del árbol de reservas.

    // Clase interna para representar cada nodo del árbol (cada reserva).
    private class Nodo {
        Reserva reserva;
        Nodo izquierda, derecha;

        public Nodo(Reserva reserva) {
            this.reserva = reserva;
            this.izquierda = null;
            this.derecha = null;
        }
    }

    // Método para registrar una nueva reserva.
    public void registrarReserva(String nombreCliente, int numeroAsiento) {
        Reserva nuevaReserva = new Reserva(nombreCliente, numeroAsiento);
        raiz = agregarReserva(raiz, nuevaReserva);
        System.out.println("✅ Reserva registrada: " + nuevaReserva);
    }

    // Método auxiliar recursivo para agregar una reserva en el árbol.
    private Nodo agregarReserva(Nodo nodo, Reserva reserva) {
        if (nodo == null) {
            return new Nodo(reserva);
        }
        if (reserva.getNumeroAsiento() < nodo.reserva.getNumeroAsiento()) {
            nodo.izquierda = agregarReserva(nodo.izquierda, reserva);
        } else {
            nodo.derecha = agregarReserva(nodo.derecha, reserva);
        }
        return nodo;
    }

    // Método para eliminar una reserva dado el número de asiento.
    public void eliminarReserva(int numeroAsiento) {
        raiz = eliminarReserva(raiz, numeroAsiento);
    }

    // Método auxiliar recursivo para eliminar una reserva.
    private Nodo eliminarReserva(Nodo nodo, int numeroAsiento) {
        if (nodo == null) {
            System.out.println("❌ No se encontró la reserva con el asiento " + numeroAsiento);
            return null;
        }

        if (numeroAsiento < nodo.reserva.getNumeroAsiento()) {
            nodo.izquierda = eliminarReserva(nodo.izquierda, numeroAsiento);
        } else if (numeroAsiento > nodo.reserva.getNumeroAsiento()) {
            nodo.derecha = eliminarReserva(nodo.derecha, numeroAsiento);
        } else {
            // Caso: Nodo con solo un hijo o sin hijos.
            if (nodo.izquierda == null) return nodo.derecha;
            if (nodo.derecha == null) return nodo.izquierda;

            // Caso: Nodo con dos hijos, se reemplaza con el menor de la derecha.
            nodo.reserva = obtenerMinimo(nodo.derecha).reserva;
            nodo.derecha = eliminarReserva(nodo.derecha, nodo.reserva.getNumeroAsiento());
        }
        return nodo;
    }

    // Método auxiliar para encontrar el nodo con el menor número de asiento en el subárbol derecho.
    private Nodo obtenerMinimo(Nodo nodo) {
        while (nodo.izquierda != null) {
            nodo = nodo.izquierda;
        }
        return nodo;
    }

    // Método para verificar si un asiento específico está ocupado.
    public boolean verificarAsiento(int numeroAsiento) {
        return buscarReserva(raiz, numeroAsiento) != null;
    }

    // Método auxiliar recursivo para buscar una reserva en el árbol.
    private Reserva buscarReserva(Nodo nodo, int numeroAsiento) {
        if (nodo == null) return null;
        if (numeroAsiento == nodo.reserva.getNumeroAsiento()) return nodo.reserva;
        return numeroAsiento < nodo.reserva.getNumeroAsiento()
                ? buscarReserva(nodo.izquierda, numeroAsiento)
                : buscarReserva(nodo.derecha, numeroAsiento);
    }

    // Método para mostrar la lista de reservas en orden de llegada (inorden del BST).
    public void mostrarReservas() {
        System.out.println("\n🎟️ Lista de reservas:");
        mostrarReservasInorden(raiz);
        System.out.println("-----------------------------");
    }

    // Método auxiliar recursivo para recorrer el árbol en inorden.
    private void mostrarReservasInorden(Nodo nodo) {
        if (nodo != null) {
            mostrarReservasInorden(nodo.izquierda);
            System.out.println(nodo.reserva);
            mostrarReservasInorden(nodo.derecha);
        }
    }

    // Método BONUS: Asignar automáticamente el mejor asiento disponible.
    public void asignarMejorAsiento(String nombreCliente) {
        int mejorAsiento = encontrarMejorAsiento(raiz);
        if (mejorAsiento != -1) {
            registrarReserva(nombreCliente, mejorAsiento);
        } else {
            System.out.println("❌ No hay asientos disponibles.");
        }
    }

    // Método auxiliar para encontrar el mejor asiento disponible (más cercano al escenario).
    private int encontrarMejorAsiento(Nodo nodo) {
        int asiento = 1; // Suponemos que los asientos inician en 1
        while (buscarReserva(nodo, asiento) != null) {
            asiento++;
        }
        return asiento;
    }
}

// Clase que representa una reserva para el sistema de boletos del teatro.
public class Reserva {
    private String nombreCliente; // Nombre del cliente que hizo la reserva.
    private int numeroAsiento; // Número de asiento reservado.

    // Constructor de la clase Reserva.
    public Reserva(String nombreCliente, int numeroAsiento) {
        this.nombreCliente = nombreCliente;
        this.numeroAsiento = numeroAsiento;
    }

    // Método para obtener el nombre del cliente.
    public String getNombreCliente() {
        return nombreCliente;
    }

    // Método para obtener el número de asiento reservado.
    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    // Método para representar la reserva en forma de texto.
    @Override
    public String toString() {
        return "Reserva: Cliente: " + nombreCliente + ", Asiento: " + numeroAsiento;
    }
}

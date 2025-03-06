import java.util.LinkedList;
import java.util.List;

// Definición del TDA DiarioAventurero
class DiarioAventurero {
    private List<String> misiones;

    public DiarioAventurero() {
        this.misiones = new LinkedList<>();
    }

    // Registrar una nueva misión
    public void registrarMision(String mision) {
        misiones.add(mision);
        System.out.println("Misión registrada: " + mision);
    }

    // Eliminar la última misión si falló
    public void eliminarUltimaMision() {
        if (!misiones.isEmpty()) {
            String eliminada = misiones.remove(misiones.size() - 1);
            System.out.println("Misión eliminada: " + eliminada);
        } else {
            System.out.println("No hay misiones para eliminar.");
        }
    }

    // Mostrar todas las misiones en orden de finalización
    public void mostrarMisiones() {
        if (misiones.isEmpty()) {
            System.out.println("No hay misiones registradas.");
        } else {
            System.out.println("Misiones completadas:");
            for (String mision : misiones) {
                System.out.println("- " + mision);
            }
        }
    }

    // Buscar si una misión específica fue completada
    public boolean buscarMision(String mision) {
        boolean encontrada = misiones.contains(mision);
        System.out.println(encontrada ? "La misión \"" + mision + "\" ha sido completada." 
                                     : "La misión \"" + mision + "\" no ha sido encontrada.");
        return encontrada;
    }

    /// Editar una misión ya registrada
public void editarMision(String antigua, String nueva) {
    int index = misiones.indexOf(antigua);
    if (index != -1) {
        misiones.set(index, nueva);
        System.out.println("Misión actualizada: \"" + antigua + "\" -> \"" + nueva + "\"");
    } else {
        System.out.println("La misión \"" + antigua + "\" no se encontró.");
    }
}
}


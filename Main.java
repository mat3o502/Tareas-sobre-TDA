public class Main {
    public static void main(String[] args) {
        DiarioAventurero diario = new DiarioAventurero();
        
        // Pruebas de funcionalidad
        diario.registrarMision("Explorar el bosque encantado");
        diario.registrarMision("Derrotar al dragón de fuego");
        diario.registrarMision("Encontrar la espada legendaria");
        
        diario.mostrarMisiones();
        
        diario.eliminarUltimaMision();
        diario.mostrarMisiones();
        
        diario.buscarMision("Derrotar al dragón de fuego");
        diario.buscarMision("Rescatar a la princesa");

        // Prueba de edición de misión
        diario.editarMision("Explorar el bosque encantado", "Explorar la cueva secreta");
        diario.mostrarMisiones();
    }
}

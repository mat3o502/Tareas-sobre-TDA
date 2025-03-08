public class Main {
    public static void main(String[] args) {
        // Crear la playlist y agregar algunas canciones
        Playlist miPlaylist = new Playlist("Mi Playlist Favorita");
        miPlaylist.agregarCancion("Billie Jean", "Michael Jackson", 294);
        miPlaylist.agregarCancion("Pa’ Que Retozen", "Tego Calderón", 218);
        miPlaylist.agregarCancion("El Jefe", "Shakira", 197);
        miPlaylist.agregarCancion("Tragos Amargos", "Los Tigres del Norte", 224);

        // Mostrar la playlist antes de reproducir aleatorio
        miPlaylist.mostrarPlaylist();

        // Reproducir aleatoriamente (bonus)
        miPlaylist.reproducirAleatorio();
    }
}

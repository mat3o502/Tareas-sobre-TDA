import java.util.*;

class Cancion {
    private String titulo;
    private String artista;
    private int duracion; // en segundos

    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public int getDuracion() { return duracion; }

    @Override
    public String toString() {
        return titulo + " - " + artista + " (" + duracion + "s)";
    }
}

class Playlist {
    private String nombre;
    private LinkedList<Cancion> canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new LinkedList<>();
    }

    public String getNombre() { return nombre; }

    public void agregarCancion(String titulo, String artista, int duracion) {
        canciones.add(new Cancion(titulo, artista, duracion));
        System.out.println("\n🎵 Canción agregada a " + nombre + ": " + titulo + "\n");
    }

    public void eliminarCancion(String titulo) {
        boolean encontrada = canciones.removeIf(c -> c.getTitulo().equalsIgnoreCase(titulo));
        if (encontrada) {
            System.out.println("\n Canción eliminada de " + nombre + ": " + titulo + "\n");
        } else {
            System.out.println("\n No se encontró la canción en " + nombre + ": " + titulo + "\n");
        }
    }

    public void reproducirSiguiente() {
        if (!canciones.isEmpty()) {
            Cancion siguiente = canciones.poll();
            System.out.println("\n Reproduciendo ahora en " + nombre + ": " + siguiente);
            System.out.println("----------------------------\n");
        } else {
            System.out.println("\n La playlist " + nombre + " está vacía.\n");
        }
    }

    public void reproducirAleatorio() {
        if (!canciones.isEmpty()) {
            List<Cancion> copiaLista = new ArrayList<>(canciones);
            Collections.shuffle(copiaLista);
            System.out.println("\n Reproduciendo canciones en orden aleatorio de " + nombre + ":");
            System.out.println("----------------------------");
            for (Cancion c : copiaLista) {
                System.out.println("🎶 " + c);
            }
            System.out.println("----------------------------\n");
        } else {
            System.out.println("\n No hay canciones en " + nombre + " para reproducir aleatoriamente.\n");
        }
    }

    public void ordenarPorDuracion() {
        canciones.sort(Comparator.comparingInt(Cancion::getDuracion));
        System.out.println("\n Playlist " + nombre + " ordenada por duración.\n");
        mostrarPlaylist();
    }

    public void ordenarPorArtista() {
        canciones.sort(Comparator.comparing(Cancion::getArtista));
        System.out.println("\n Playlist " + nombre + " ordenada por artista.\n");
        mostrarPlaylist();
    }

    public void mostrarPlaylist() {
        if (canciones.isEmpty()) {
            System.out.println("\n La playlist " + nombre + " está vacía.\n");
        } else {
            System.out.println("\n Playlist: " + nombre);
            System.out.println("----------------------------");
            for (Cancion c : canciones) {
                System.out.println("- " + c);
            }
            System.out.println("----------------------------\n");
        }
    }
}

//  Nueva clase para manejar múltiples playlists
class GestorPlaylists {
    private Map<String, Playlist> playlists;

    public GestorPlaylists() {
        this.playlists = new HashMap<>();
    }

    public void crearPlaylist(String nombre) {
        if (!playlists.containsKey(nombre)) {
            playlists.put(nombre, new Playlist(nombre));
            System.out.println("\n Nueva playlist creada: " + nombre);
        } else {
            System.out.println("\n Ya existe una playlist con el nombre " + nombre);
        }
    }

    public Playlist obtenerPlaylist(String nombre) {
        return playlists.get(nombre);
    }

    public void mostrarTodasLasPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("\n No hay playlists creadas aún.\n");
        } else {
            System.out.println("\n Playlists disponibles:");
            for (String nombre : playlists.keySet()) {
                System.out.println("- " + nombre);
            }
            System.out.println();
        }
    }
}


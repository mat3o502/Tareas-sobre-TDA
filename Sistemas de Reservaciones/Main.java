import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorBoletos gestor = new GestorBoletos();

        int opcion;
        do {
            System.out.println("\n🎭 Bienvenido al sistema de reserva de boletos del teatro 🎟️");
            System.out.println("1️⃣ Registrar una reserva");
            System.out.println("2️⃣ Eliminar una reserva");
            System.out.println("3️⃣ Verificar si un asiento está ocupado");
            System.out.println("4️⃣ Mostrar todas las reservas");
            System.out.println("5️⃣ Asignar automáticamente el mejor asiento disponible");
            System.out.println("0️⃣ Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de nextInt()

            switch (opcion) {
                case 1:
                    System.out.print("\n📝 Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("🎫 Ingrese el número de asiento: ");
                    int asiento = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea después de nextInt()
                    gestor.registrarReserva(nombre, asiento);
                    break;

                case 2:
                    System.out.print("\n🗑️ Ingrese el número de asiento a eliminar: ");
                    int asientoEliminar = scanner.nextInt();
                    scanner.nextLine();
                    gestor.eliminarReserva(asientoEliminar);
                    break;

                case 3:
                    System.out.print("\n🔍 Ingrese el número de asiento a verificar: ");
                    int asientoVerificar = scanner.nextInt();
                    scanner.nextLine();
                    if (gestor.verificarAsiento(asientoVerificar)) {
                        System.out.println("✅ El asiento " + asientoVerificar + " está ocupado.");
                    } else {
                        System.out.println("❌ El asiento " + asientoVerificar + " está disponible.");
                    }
                    break;

                case 4:
                    gestor.mostrarReservas();
                    break;

                case 5:
                    System.out.print("\n🤖 Ingrese el nombre del cliente para asignar el mejor asiento: ");
                    String clienteAuto = scanner.nextLine();
                    gestor.asignarMejorAsiento(clienteAuto);
                    break;

                case 0:
                    System.out.println("\n👋 Gracias por usar el sistema de reservas del teatro. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("⚠️ Opción inválida, intenta nuevamente.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}


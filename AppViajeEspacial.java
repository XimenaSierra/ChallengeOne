
    import java.util.Scanner;
    import java.util.ArrayList;

public class AppViajeEspacial {

    static class Planeta {
        String nombre;
        double distancia; // en millones de kilómetros
        String descripcion;

        Planeta(String nombre, double distancia, String descripcion) {
            this.nombre = nombre;
            this.distancia = distancia;
            this.descripcion = descripcion;
        }

        void mostrarInfo() {
            System.out.println("Planeta: " + nombre);
            System.out.println("Distancia desde la tierra: " + distancia + " millones de km");
            System.out.println("Descripción: " + descripcion);
        }
    }

    // Clase Nave
    static class Nave {
        String nombre;
        double velocidad; // en km por segundo

        Nave(String nombre, double velocidad) {
            this.nombre = nombre;
            this.velocidad = velocidad;
        }

        void mostrarInfo() {
            System.out.println("Nave: " + nombre);
            System.out.println("Velocidad: " + velocidad + " km/s");
        }

        // Método para calcular el tiempo estimado del viaje
        double calcularTiempo(double distancia) {
            
            return distancia * 1_000_000 / velocidad / (60 * 60 * 24);
        }
    }

    // Lista de planetas y naves disponibles
    static ArrayList<Planeta> planetas = new ArrayList<>();
    static ArrayList<Nave> naves = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista de planetas
        planetas.add(new Planeta("Mercurio", 69, "Es el planeta más pequeño del sistema solar y el más cercano al Sol."));
        planetas.add(new Planeta("Venus", 108, "El brillo de Venus es debido a la cercanía con la Tierra, es el planeta que más próximo se encuentra."));
        planetas.add(new Planeta("Marte", 228, "El cuarto planeta desde el Sol, conocido por su color rojo."));
        planetas.add(new Planeta("Jupiter", 79, "El gigante gaseoso, es el planeta más grande del sistema solar."));
        planetas.add(new Planeta("Saturno", 1.400, "El elemento más llamativo son sus 7 anillos."));
        planetas.add(new Planeta("Urano", 2.880, "Está compuesto por una especie de hielo: fluido de agua, amoníaco y metano."));
        planetas.add(new Planeta("Neptuno", 4.500, "Es uno de los gigante de hielo, la mayor parte de su masa corresponde con una especie de hielo."));

        // Lista de naves
        naves.add(new Nave("Prototipo-928", 20.000));
        naves.add(new Nave("Astro-654", 35.000));
        naves.add(new Nave("Galaxia Mistica", 25.000));

        // Menú de inicio
        boolean ejecutarPrograma = true;

        while (ejecutarPrograma) {
            System.out.println("\n**Bienvenid@ a este Viaje Espacial**");
            System.out.println("¡Comencemos!");
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Seleccionar Planeta");
            System.out.println("2. Seleccionar Nave");
            System.out.println("3. Iniciar Viaje");
            System.out.println("4. Salir");

            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    seleccionarPlaneta(scanner);
                    break;
                case 2:
                    seleccionarNave(scanner);
                    break;
                case 3:
                    iniciarViaje(scanner);
                    break;
                case 4:
                    ejecutarPrograma = false;
                    System.out.println("¡Gracias por esta aventura! Finalizando...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
        scanner.close();
    }

    static Planeta planetaSeleccionado = null;
    static Nave naveSeleccionada = null;
    static int pasajeros = 0;

    public static void seleccionarPlaneta(Scanner scanner) {
        System.out.println("\n--- Selección de Planeta ---");
        for (int i = 0; i < planetas.size(); i++) {
            System.out.println((i + 1) + ". " + planetas.get(i).nombre);
        }

        System.out.print("Selecciona un planeta (1-" + planetas.size() + "): ");
        int opcionPlaneta = scanner.nextInt();
        scanner.nextLine(); 

        if (opcionPlaneta >= 1 && opcionPlaneta <= planetas.size()) {
            planetaSeleccionado = planetas.get(opcionPlaneta - 1);
            planetaSeleccionado.mostrarInfo();
        } else {
            System.out.println("Selección inválida.");
        }
    }

    public static void seleccionarNave(Scanner scanner) {
        System.out.println("\n--- Selección de Nave ---");
        for (int i = 0; i < naves.size(); i++) {
            System.out.println((i + 1) + ". " + naves.get(i).nombre);
        }

        System.out.print("Selecciona una nave (1-" + naves.size() + "): ");
        int opcionNave = scanner.nextInt();
        scanner.nextLine(); 

        if (opcionNave >= 1 && opcionNave <= naves.size()) {
            naveSeleccionada = naves.get(opcionNave - 1);
            naveSeleccionada.mostrarInfo();

            // Solicitar la cantidad de pasajeros
            System.out.print("Introduce la cantidad de pasajeros: ");
            pasajeros = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Selección inválida.");
        }
    }

    public static void iniciarViaje(Scanner scanner) {
        if (planetaSeleccionado == null || naveSeleccionada == null) {
            System.out.println("Debes seleccionar un planeta y una nave antes de iniciar el viaje.");
            return;
        }

        double tiempoViaje = naveSeleccionada.calcularTiempo(planetaSeleccionado.distancia);
        System.out.println("\nIniciando viaje a " + planetaSeleccionado.nombre + "...");
        System.out.println("Distancia: " + planetaSeleccionado.distancia + " millones de km");
        System.out.println("Tiempo estimado: " + tiempoViaje + " días");

        // Simulación del viaje
        double progreso = 0;
        while (progreso < 100) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            progreso += 10; // Progreso del 10% cada segundo de simulación
            System.out.println("Progreso del viaje: " + (int) progreso + "%");

            if (progreso == 100) {
                System.out.println("\n¡Hemos llegado a " + planetaSeleccionado.nombre + " exitosamente!");
            }
        }
    }
}



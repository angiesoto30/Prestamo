package Vista;

import controlador.Resultado;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class VistaConsola {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final Scanner entrada = new Scanner(System.in);
    public void mostrarPeticion(int n, String descripcion) {
        System.out.println("\n#" + n + " " + descripcion);
    }

    public void mostrarResultado(Resultado r) {
        String marca = r.isExito() ? "  [OK] " : "  [" + r.getCodigo() + "] ";
        System.out.println(marca + r.getMensaje());
    }

    public void mostrarLista(String titulo, List<String> lineas) {
        System.out.println("\n===== " + titulo + " =====");
        for (String l : lineas) System.out.println(l);
    }
        public int pedirModo() {
        System.out.println("---- Préstamo de equipos del LCI ----");
        System.out.println("1. Procesar las 25 peticiones del mostrador");
        System.out.println("2. Modo interactivo");
        System.out.println("0. Salir");
        return leerOpcion(0, 2);
    }

    public int pedirOpcion() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Prestar un equipo");
        System.out.println("2. Devolver un equipo");
        System.out.println("3. Reservar un equipo");
        System.out.println("4. Ver deuda por persona");
        System.out.println("5. Ver log");
        System.out.println("6. Simular falla en el próximo guardado");
        System.out.println("0. Salir");
        return leerOpcion(0, 6);
    }

    public String pedirCodigo(String mensaje) {
        System.out.print(mensaje);
        return leerLinea().trim().toUpperCase();
    }

    public LocalDate pedirFecha() {
        while (true) {
            System.out.print("Fecha (dd/mm/aaaa): ");
            try {
                return LocalDate.parse(leerLinea().trim(), FMT);
            } catch (DateTimeParseException e) {
                System.out.println("La fecha no es válida. Escríbala de esta manera: 02/03/2026.");
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    private int leerOpcion(int min, int max) {
        while (true) {
            System.out.print("Elija una opción: ");
            try {
                int valor = Integer.parseInt(leerLinea().trim());
                if (valor >= min && valor <= max) return valor;
            } catch (NumberFormatException e) {
            }
            System.out.println("Opción no válida. Escriba un número entre " + min + " y " + max + ".");
        }
    }

    private String leerLinea() {
        if (!entrada.hasNextLine()) {
            System.out.println();
            System.exit(0);
        }
        return entrada.nextLine();
    }
}

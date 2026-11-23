
package biblioteca;

import model.Libro;
import repository.LibroRepository;
import repository.LibroRepositoryMemoria;
import service.LibroService;

public class Biblioteca {

    public static void main(String[] args) {

        LibroRepository repo = new LibroRepositoryMemoria();
        LibroService servicio = new LibroService(repo);

        // REGISTRAR LIBROS
        servicio.registrarLibro(1, "Don Quijote");
        servicio.registrarLibro(2, "Cien anios de soledad");
        servicio.registrarLibro(3, "El Principito");

        // MOSTRAR LIBROS
        System.out.println("=== LISTA DE LIBROS ===");

        for (Libro libro : servicio.listarLibros()) {
            System.out.println(
                libro.getId() + " - " +
                libro.getTitulo() + " - " +
                (libro.isDisponible() ? "Disponible" : "Prestado")
            );
        }

        // CASO CORRECTO: PRESTAR
        System.out.println("\n=== PRESTAMO CORRECTO ===");
        servicio.prestar(1);

        // CASO DE ERROR: PRESTAR DOS VECES
        System.out.println("\n=== ERROR DE PRESTAMO ===");
        servicio.prestar(1);

        // CASO CORRECTO: DEVOLVER
        System.out.println("\n=== DEVOLUCION CORRECTA ===");
        servicio.devolver(1);

        // CASO DE ERROR: DEVOLVER DOS VECES
        System.out.println("\n=== ERROR DE DEVOLUCION ===");
        servicio.devolver(1);

        // CASO DE ERROR: LIBRO INEXISTENTE
        System.out.println("\n=== LIBRO INEXISTENTE ===");
        servicio.prestar(10);

        // ESTADO FINAL
        System.out.println("\n=== ESTADO FINAL ===");

        for (Libro libro : servicio.listarLibros()) {
            System.out.println(
                libro.getId() + " - " +
                libro.getTitulo() + " - " +
                (libro.isDisponible() ? "Disponible" : "Prestado")
            );
        }
    }
}


package service;

import model.Libro;
import repository.LibroRepository;
import java.util.List;
import java.util.Optional;

public class LibroService {

    private final LibroRepository repository;

    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    // Registrar un libro
    public void registrarLibro(int id, String titulo) {
        Libro libro = new Libro(id, titulo, true);
        repository.guardar(libro);
    }

    // Buscar un libro
    public Optional<Libro> buscarLibro(int id) {
        return repository.buscarPorId(id);
    }

    // Listar todos los libros
    public List<Libro> listarLibros() {
        return repository.listarTodos();
    }

    // Prestar un libro
    public void prestar(int id) {

        Optional<Libro> resultado = repository.buscarPorId(id);

        if (resultado.isEmpty()) {
            System.out.println("ERROR: El libro no existe.");
            return;
        }

        Libro libro = resultado.get();

        if (!libro.isDisponible()) {
            System.out.println("ERROR: El libro ya esta prestado.");
            return;
        }

        libro.setDisponible(false);
        System.out.println("Prestamo exitoso: " + libro.getTitulo());
    }

    // Devolver un libro
    public void devolver(int id) {

        Optional<Libro> resultado = repository.buscarPorId(id);

        if (resultado.isEmpty()) {
            System.out.println("ERROR: El libro no existe.");
            return;
        }

        Libro libro = resultado.get();

        if (libro.isDisponible()) {
            System.out.println("ERROR: El libro ya esta disponible.");
            return;
        }

        libro.setDisponible(true);
        System.out.println("Devolucion exitosa: " + libro.getTitulo());
    }
}

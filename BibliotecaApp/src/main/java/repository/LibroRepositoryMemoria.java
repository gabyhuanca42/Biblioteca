
package repository;

import model.Libro;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibroRepositoryMemoria
        implements LibroRepository {

    private final List<Libro> libros = new ArrayList<>();

    @Override
    public void guardar(Libro libro) {
        libros.add(libro);
    }

    @Override
    public Optional<Libro> buscarPorId(int id) {

        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return Optional.of(libro);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Libro> listarTodos() {
        return new ArrayList<>(libros);
    }
}

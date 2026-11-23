
package repository;

import model.Libro;
import java.util.List;
import java.util.Optional;

public interface LibroRepository {

    void guardar(Libro libro);

    Optional<Libro> buscarPorId(int id);

    List<Libro> listarTodos();
}

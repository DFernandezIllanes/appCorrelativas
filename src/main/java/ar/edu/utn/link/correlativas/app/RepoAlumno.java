package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Alumno;
import ar.edu.utn.link.correlativas.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoAlumno {

    public void save(Alumno a) throws AlumnoRepetidoException;

    public List<Alumno> all();

    boolean existeAlumnoDeNombre(String nombre);

    public Page<Alumno> page(Pageable pageable);

    public Alumno porNombre(String nombre);
}

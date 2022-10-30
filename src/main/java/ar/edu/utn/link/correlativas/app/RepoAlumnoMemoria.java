package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Alumno;
import ar.edu.utn.link.correlativas.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepoAlumnoMemoria implements RepoAlumno{

    private List<Alumno> alumnos;

    public RepoAlumnoMemoria(){
        super();
        this.alumnos = new ArrayList<>();
    }

    @Override
    public void save(Alumno a) throws AlumnoRepetidoException {
        if(this.existeAlumnoDeNombre(a.getNombre())){
            throw new AlumnoRepetidoException(a.getNombre());
        }
        this.alumnos.add(a);

    }

    @Override
    public List<Alumno> all() {
        return this.alumnos;
    }

    @Override
    public boolean existeAlumnoDeNombre(String nombre) {
        long count = this.alumnos.stream().filter(alumno -> alumno.getNombre().equals(nombre)).count();
        return count>0;
    }

    @Override
    public Page<Alumno> page(Pageable pageable) {
        int desde = pageable.getPageNumber() * pageable.getPageSize();
        List<Alumno> subList2 = this.alumnos.subList(desde, desde + pageable.getPageSize());
        return new PageImpl<Alumno>(subList2, pageable, this.alumnos.size());
    }

    @Override
    public Alumno porNombre(String nombre) {
        return this.alumnos.stream().filter(alumno -> alumno.getNombre().equals(nombre)).findFirst().get();
    }
}

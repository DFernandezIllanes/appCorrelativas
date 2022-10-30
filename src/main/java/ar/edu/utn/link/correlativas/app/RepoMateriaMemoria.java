package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoMateriaMemoria implements RepoMateria{

    private List<Materia> materias;

    public RepoMateriaMemoria() {
        super();
        this.materias = new ArrayList<>();
    }

    @Override
    public void save(Materia m) {
        this.materias.add(m);
    }

    @Override
    public List<Materia> all() {
        return this.materias;
    }

    @Override
    public Page<Materia> page(Pageable pageable) {
        int desde = pageable.getPageNumber() * pageable.getPageSize();
        List<Materia> subList2 = this.materias.subList(desde, desde + pageable.getPageSize());
        return new PageImpl<Materia>(subList2, pageable, this.materias.size());
    }

    @Override
    public Materia porNombre(String nombre) {
        /* A la coleccion materias convertila en un stream. Filtra cada elemento del stream. De todos los elementos cuyo
        atributo coincidan con el valor del parametro, traeme el primero
         */
        return this.materias.stream().filter(materia -> materia.getNombre().equals(nombre)).findFirst().get();
    }
}

package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriasController {

    @Autowired
    RepoMateria repo;

    @GetMapping(path = {"/", ""})
    public Page<Materia> materias(Pageable page){
        return repo.page(page);
    }

    @GetMapping("/{pepe}")
    public Materia materia(@PathVariable("pepe") String nombre){
        return repo.porNombre(nombre);
    }
}

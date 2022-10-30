package ar.edu.utn.link.correlativas.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// Se activa cuando se produce un error
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MateriaRepetidaException.class) // Cuando salte una exception que nadie agarra, que sea de una materia, que se ejecute este método
    @ResponseBody // Indica que el resultado debe ir en la respuesta del body
    @ResponseStatus(HttpStatus.CONFLICT) // Para convertir esto en un status
    String materiaRepetida(MateriaRepetidaException ex){

        return "la materia " + ex.getNombreMateria() + " ya existe";
    }

    @ExceptionHandler(AlumnoRepetidoException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    String alumnoRepetido(AlumnoRepetidoException ex){
        return "el alumno " + ex.getNombreAlumno() + " ya existe";
    }
}

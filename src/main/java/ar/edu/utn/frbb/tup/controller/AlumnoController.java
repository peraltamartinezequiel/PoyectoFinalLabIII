package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.business.AlumnoService;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.EstadoAsignatura;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import ar.edu.utn.frbb.tup.persistence.exception.AlumnoNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.AsignaturaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> obtenerAlumnos() {
        return alumnoService.obtenerAlumnos();
    }

    @PostMapping
    public Alumno crearAlumno(@RequestBody AlumnoDto alumnoDto) {

        return alumnoService.crearAlumno(alumnoDto);

    }
    @PutMapping("/{idAlumno}")
    public Alumno modificarAlumno(@PathVariable Long idAlumno, @RequestBody AlumnoDto alumnoDto) throws AlumnoNotFoundException {
        return alumnoService.modificarAlumno(idAlumno, alumnoDto);
    }
    @DeleteMapping("/{idAlumno}")
    public boolean eliminarAlumno(@PathVariable Long idAlumno) {
        return alumnoService.eliminarAlumno(idAlumno);
    }
    @GetMapping("/apellido")
    public Alumno buscarAlumno(@RequestParam String apellido) throws AlumnoNotFoundException {

       return alumnoService.buscarAlumno(apellido);

    }
    @PutMapping("/{idAlumno}/asignatura/{idAsignatura}")
    public Alumno gestionarAsignaturas(@PathVariable Long idAlumno, @PathVariable Long idAsignatura, @RequestParam String estado) throws AsignaturaNotFoundException, AlumnoNotFoundException {
        return alumnoService.gestionarEstadoAsignatura(idAlumno, idAsignatura, estado);
    }

}

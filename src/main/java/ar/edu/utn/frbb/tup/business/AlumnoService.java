package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.EstadoAsignatura;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import ar.edu.utn.frbb.tup.model.exception.CorrelatividadesNoAprobadasException;
import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
import ar.edu.utn.frbb.tup.persistence.exception.AlumnoNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.AsignaturaNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {
    void aprobarAsignatura(int materiaId, int nota, long dni) throws EstadoIncorrectoException, CorrelatividadesNoAprobadasException;

    Alumno crearAlumno(AlumnoDto alumno);

    List<Alumno> obtenerAlumnos();

    Alumno modificarAlumno(long id, AlumnoDto alumno) throws AlumnoNotFoundException;

    boolean eliminarAlumno(long id);

    Alumno buscarAlumno(String apellidoAlumno) throws AlumnoNotFoundException;

    Alumno gestionarEstadoAsignatura(long alumnoId, long asignaturaId, String estado) throws AlumnoNotFoundException, AsignaturaNotFoundException;
}

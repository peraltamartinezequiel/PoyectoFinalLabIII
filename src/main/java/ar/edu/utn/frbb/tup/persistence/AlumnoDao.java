package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.persistence.exception.AlumnoNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.DaoException;

import java.util.List;

public interface AlumnoDao {

    Alumno saveAlumno(Alumno a);

    List<Alumno> getAllAlumnos();

    boolean deleteAlumno(long idAlumno);

    Alumno findAlumno(String apellidoAlumno) throws AlumnoNotFoundException;

    Alumno findAlumnoById(long idAlumno) throws AlumnoNotFoundException;

    Alumno loadAlumno(Long dni);
}

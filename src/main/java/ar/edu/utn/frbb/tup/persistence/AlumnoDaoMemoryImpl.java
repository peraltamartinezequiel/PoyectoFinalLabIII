package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.persistence.exception.AlumnoNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class AlumnoDaoMemoryImpl implements AlumnoDao {

    private static final Map<Long, Alumno> repositorioAlumnos = new HashMap<>();

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        return repositorioAlumnos.put(alumno.getId(), alumno);
    }
    @Override
    public List<Alumno> getAllAlumnos() {
        return new ArrayList<>(repositorioAlumnos.values());
    }
    @Override
    public boolean deleteAlumno(long idAlumno) {
        try {
            for (Alumno a : repositorioAlumnos.values()) {
                if (idAlumno == a.getId()) {
                    repositorioAlumnos.remove(idAlumno);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Alumno findAlumno(String apellidoAlumno) throws AlumnoNotFoundException {
        for (Alumno a: repositorioAlumnos.values()) {
            if (a.getApellido().equals(apellidoAlumno)){
                return a;
            }
        }
        throw new AlumnoNotFoundException("No existe el alumno con el apellido" + apellidoAlumno);
    }
    @Override
    public Alumno findAlumnoById(long idAlumno) throws AlumnoNotFoundException {
        for (Alumno a: repositorioAlumnos.values()) {
            if (idAlumno == a.getId()) {
                return a;
            }
        }
        throw new AlumnoNotFoundException("No existe el alumno con el id" + idAlumno);
    }

    @Override
    public Alumno loadAlumno(Long dni) {
        return null;
    }

}

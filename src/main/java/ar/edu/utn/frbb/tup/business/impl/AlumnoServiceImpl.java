package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.AlumnoService;
import ar.edu.utn.frbb.tup.business.AsignaturaService;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.Asignatura;
import ar.edu.utn.frbb.tup.model.EstadoAsignatura;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import ar.edu.utn.frbb.tup.model.exception.CorrelatividadesNoAprobadasException;
import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;
import ar.edu.utn.frbb.tup.persistence.AlumnoDao;
import ar.edu.utn.frbb.tup.persistence.AlumnoDaoMemoryImpl;
import ar.edu.utn.frbb.tup.persistence.exception.AlumnoNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.AsignaturaNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class AlumnoServiceImpl implements AlumnoService {
    private static final AlumnoDao alumnoDao = new AlumnoDaoMemoryImpl();
    private static final AsignaturaService asignaturaService = new AsignaturaServiceImpl();

    @Override
    public void aprobarAsignatura(int materiaId, int nota, long dni) throws EstadoIncorrectoException, CorrelatividadesNoAprobadasException {
        Asignatura a = asignaturaService.getAsignatura(materiaId, dni);
        for (Materia m:
             a.getMateria().getCorrelatividades()) {
            Asignatura correlativa = asignaturaService.getAsignatura(m.getMateriaId(), dni);
            if (!EstadoAsignatura.APROBADA.equals(correlativa.getEstado())) {
                throw new CorrelatividadesNoAprobadasException("La materia " + m.getNombre() + " debe estar aprobada para aprobar " + a.getNombreAsignatura());
            }
        }
        a.aprobarAsignatura(nota);
        asignaturaService.actualizarAsignatura(a);
        Alumno alumno = alumnoDao.loadAlumno(dni);
        alumno.actualizarAsignatura(a);
        alumnoDao.saveAlumno(alumno);
    }

    @Override
    public Alumno crearAlumno(AlumnoDto alumno) {
        Alumno a = new Alumno();
        a.setNombre(alumno.getNombre());
        a.setApellido(alumno.getApellido());
        a.setDni(alumno.getDni());
        Random random = new Random();
        a.setId(random.nextLong());
        alumnoDao.saveAlumno(a);
        return a;
    }
    @Override
    public List<Alumno> obtenerAlumnos() {
        return alumnoDao.getAllAlumnos();
    }
    @Override
    public Alumno modificarAlumno(long id, AlumnoDto alumno) throws AlumnoNotFoundException {
        Alumno a = alumnoDao.findAlumnoById(id);
        if (!alumno.getNombre().isEmpty()) {
            a.setNombre(alumno.getNombre());
        }
        if (!alumno.getApellido().isEmpty()) {
            a.setApellido(alumno.getApellido());
        }
        if (alumno.getDni() != 0) {
            a.setDni(alumno.getDni());
        }
        alumnoDao.saveAlumno(a);
        return a;
    }
    @Override
    public boolean eliminarAlumno(long id) {
        return alumnoDao.deleteAlumno(id);
    }

    @Override
    public Alumno buscarAlumno(String apellido) throws AlumnoNotFoundException {
        return alumnoDao.findAlumno(apellido);
    }

    @Override
    public Alumno gestionarEstadoAsignatura(long alumnoId, long asignaturaId, String estado) throws AlumnoNotFoundException, AsignaturaNotFoundException {
        Alumno alumno = alumnoDao.findAlumnoById(alumnoId);
        Asignatura asignatura = alumno.getAsignaturas().stream().filter(a -> a.getId() == asignaturaId).findAny().orElseThrow(() -> new AsignaturaNotFoundException("No encontramos la asignatura con el id " + asignaturaId));
        asignatura.setEstado(EstadoAsignatura.valueOf(estado.toUpperCase()));
        alumno.actualizarAsignatura(asignatura);
        alumnoDao.saveAlumno(alumno);
        return alumno;
    }
}

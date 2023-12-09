package ar.edu.utn.frbb.tup.model;




import ar.edu.utn.frbb.tup.model.exception.AsignaturaInexistenteException;
import ar.edu.utn.frbb.tup.model.exception.CorrelatividadException;
import ar.edu.utn.frbb.tup.model.exception.EstadoIncorrectoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Alumno {
    private long id;

    private String nombre;
    private String apellido;
    private long dni;

    private List<Asignatura> asignaturas = new ArrayList<>(asignaturasRandom());

    public Alumno() {
    }
    public Alumno(String nombre, String apellido, long dni, List<Asignatura> asignaturas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.asignaturas = asignaturas;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getDni() {
        return dni;
    }

    public void agregarAsignatura(Asignatura a){
        this.asignaturas.add(a);
    }

    public List<Asignatura> asignaturasRandom() {
        Random r1 = new Random();
        Random r2 = new Random();
        Random r3 = new Random();
        Profesor p1 = new Profesor("Sebastian", "Grañan", "programador");
        Carrera c1 = new Carrera("Programacion", 141, 5, 4);
        Materia m1 = new Materia("Laboratorio 4", 2, 4, p1, c1);
        Materia m2 = new Materia("Programacion 4", 2, 4, p1, c1);
        Materia m3 = new Materia("Diseño y Administracion de Bases de Datos", 2, 4, p1, c1);
        Asignatura a1 = new Asignatura(m1);
        a1.setId(r1.nextLong());
        Asignatura a2 = new Asignatura(m2);
        a2.setId(r2.nextLong());
        Asignatura a3 = new Asignatura(m3);
        a3.setId(r3.nextLong());
        List<Asignatura> aRandom = new ArrayList<>();
        aRandom.add(a1);
        aRandom.add(a2);
        aRandom.add(a3);
        return aRandom;
    }

    public List<Asignatura> obtenerListaAsignaturas(){
        return asignaturas;
    }

    public void aprobarAsignatura(Materia materia, int nota) throws EstadoIncorrectoException, CorrelatividadException, AsignaturaInexistenteException {
        Asignatura asignaturaAAprobar = getAsignaturaAAprobar(materia);

        for (Materia correlativa :
                materia.getCorrelatividades()) {
            chequearCorrelatividad(correlativa);
        }
        asignaturaAAprobar.aprobarAsignatura(nota);
    }

    private void chequearCorrelatividad(Materia correlativa) throws CorrelatividadException {
        for (Asignatura a:
                asignaturas) {
            if (correlativa.getNombre().equals(a.getNombreAsignatura())) {
                if (!EstadoAsignatura.APROBADA.equals(a.getEstado())) {
                    throw new CorrelatividadException("La asignatura " + a.getNombreAsignatura() + " no está aprobada");
                }
            }
        }
    }

    private Asignatura getAsignaturaAAprobar(Materia materia) throws AsignaturaInexistenteException {

        for (Asignatura a: asignaturas) {
            if (materia.getNombre().equals(a.getNombreAsignatura())) {
                return a;
            }
        }
        throw new AsignaturaInexistenteException("No se encontró la materia");
    }

    public boolean puedeAprobar(Asignatura asignatura) {
        return true;
    }

    public void actualizarAsignatura(Asignatura asignatura) {
        for (Asignatura a:
             asignaturas) {
            if (a.getNombreAsignatura().equals(asignatura.getNombreAsignatura())) {
                a.setEstado(asignatura.getEstado());
                if (asignatura.getNota().isPresent()) {
                    a.setNota(asignatura.getNota().get());
                }

            }
        }

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

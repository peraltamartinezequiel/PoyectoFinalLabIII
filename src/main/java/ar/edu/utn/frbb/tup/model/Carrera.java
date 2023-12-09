package ar.edu.utn.frbb.tup.model;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private long id;
    private String nombre;
    private int codigoCarrera;
    private int departamento;
    private int cantidadCuatrimestres;
    private List<Materia> materias;
    public Carrera() {
    }
    public Carrera(String nombre, int codigoCarrera, int departamento, int cantidadCuatrimestres){
        this.nombre = nombre;
        this.codigoCarrera = codigoCarrera;
        this.departamento = departamento;
        this.cantidadCuatrimestres = cantidadCuatrimestres;
        materias = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCodigoCarrera() {
        return codigoCarrera;
    }
    public void setCodigoCarrera(int codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }
    public int getDepartamento() {
        return departamento;
    }
    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public int getCantidadCuatrimestres() {
        return cantidadCuatrimestres;
    }

    public void setCantidadCuatrimestres(int cantidadCuatrimestres) {
        this.cantidadCuatrimestres = cantidadCuatrimestres;
    }
    public void agregarMateria(Materia m) {
        this.materias.add(m);
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public List<Materia> getMaterias() {
        return materias;
    }
    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}

package ar.edu.utn.frbb.tup.model.dto;

public class CarreraDto {
    private String nombre;
    private int codigoCarrera;
    private int departamento;
    private int cantidadCuatrimestres;
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
}

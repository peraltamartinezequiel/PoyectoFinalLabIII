package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Carrera;
import ar.edu.utn.frbb.tup.persistence.exception.CarreraNotFoundException;

import java.util.List;
import java.util.Map;

public interface CarreraDao {
    Carrera saveCarrera(Carrera carrera);

    Carrera findById(long idCarrera) throws CarreraNotFoundException;

    boolean deleteCarrera(long idCarrera);

    Carrera get(long id);

    List<Carrera> getCarreras();
}

package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Carrera;
import ar.edu.utn.frbb.tup.model.dto.CarreraDto;
import ar.edu.utn.frbb.tup.persistence.exception.CarreraNotFoundException;

import java.util.List;
import java.util.Map;

public interface CarreraService {
    Carrera crearCarrera(CarreraDto carrera);
    List<Carrera> obtenerCarreras();

    Carrera obtenerCarreraPorId(long carreraId) throws CarreraNotFoundException;

    Carrera modificarCarrera(long id, CarreraDto carrera) throws CarreraNotFoundException;

    boolean eliminarCarrera(long id);

    Carrera buscarCarrera(long carreraId);
}

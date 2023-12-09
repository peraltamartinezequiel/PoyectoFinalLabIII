package ar.edu.utn.frbb.tup.business;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.dto.MateriaDto;
import ar.edu.utn.frbb.tup.persistence.exception.CarreraNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;

import java.util.List;

public interface MateriaService {
    Materia crearMateria(MateriaDto inputData) throws CarreraNotFoundException;

    Materia modificarMateria(int id, MateriaDto materia) throws MateriaNotFoundException, CarreraNotFoundException;

    boolean elminarMateria(int id);

    List<Materia> obtenerMaterias();

    List<Materia> obtenerMateriasPorOrden(String order);

    Materia getMateriaById(int idMateria) throws MateriaNotFoundException;

    Materia getMateriaByNombre(String nombre) throws MateriaNotFoundException;
}

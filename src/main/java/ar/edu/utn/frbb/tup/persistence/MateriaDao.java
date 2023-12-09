package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;

import java.util.List;

public interface MateriaDao {
    List<Materia> getAllMaterias();

    Materia save(Materia materia);

    boolean deleteMateria(int idMateria);

    Materia findById(int idMateria) throws MateriaNotFoundException;

    List<Materia> getMateriasByOrder(String order);

    Materia findByNombre(String nombreMateria) throws MateriaNotFoundException;
}

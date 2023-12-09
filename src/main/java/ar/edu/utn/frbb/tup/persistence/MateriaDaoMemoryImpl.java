package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MateriaDaoMemoryImpl implements MateriaDao {

    private static final Map<Integer, Materia> repositorioMateria = new HashMap<>();
    @Override
    public List<Materia> getAllMaterias() {
        return new ArrayList<>(repositorioMateria.values());
    }
    @Override
    public Materia save(Materia materia) {
        repositorioMateria.put(materia.getMateriaId(), materia);
        return materia;
    }
    @Override
    public boolean deleteMateria(int idMateria) {
        try {
            for (Materia m : repositorioMateria.values()){
                if (idMateria == m.getMateriaId()) {
                    repositorioMateria.remove(idMateria);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Materia findById(int idMateria) throws MateriaNotFoundException {
        for (Materia m:
             repositorioMateria.values()) {
            if (idMateria == m.getMateriaId()) {
                return m;
            }
        }
        throw new MateriaNotFoundException("No se encontró la materia con id " + idMateria);
    }
    @Override
    public List<Materia> getMateriasByOrder(String order) {
        List<Materia> m = new ArrayList<>(repositorioMateria.values());
        if (order.equals("nombre_asc")) {
            m.sort(Comparator.comparing(Materia::getNombre));
        }
        if (order.equals("nombre_desc")) {
            m.sort(Comparator.comparing(Materia::getNombre).reversed());
        }
        if (order.equals("codigo_asc")) {
            m.sort(Comparator.comparing(Materia::getMateriaId));
        }
        if (order.equals("codigo_desc")) {
            m.sort(Comparator.comparing(Materia::getMateriaId).reversed());
        }
        return m;
    }
    @Override
    public Materia findByNombre(String nombreMateria) throws MateriaNotFoundException {
        for (Materia m: repositorioMateria.values()){
            if (m.getNombre().equals(nombreMateria)) {
                return m;
            }
        }
        throw new MateriaNotFoundException("No se encontró la materia con el nombre " + nombreMateria);
    }
}

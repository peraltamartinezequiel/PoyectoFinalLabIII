package ar.edu.utn.frbb.tup.persistence;

import ar.edu.utn.frbb.tup.model.Carrera;
import ar.edu.utn.frbb.tup.persistence.exception.CarreraNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarreraDaoMemoryImpl implements CarreraDao {
    private static final Map<Long, Carrera> repositorioCarrera = new HashMap<>();

    @Override
    public Carrera saveCarrera(Carrera carrera){
        repositorioCarrera.put(carrera.getId(), carrera);
        return carrera;
    }
    @Override
    public Carrera findById(long idCarrera) throws CarreraNotFoundException {
        for (Carrera c: repositorioCarrera.values()) {
            if (idCarrera == c.getId()) {
                return c;
            }
        }
        throw new CarreraNotFoundException("No se encontro la carrera con el id" + idCarrera);
    }
    @Override
    public boolean deleteCarrera(long idCarrera) {
        try {
            for (Carrera c: repositorioCarrera.values()){
                if (idCarrera == c.getId()){
                    repositorioCarrera.remove(idCarrera);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public Carrera get(long id) {
        return new Carrera("Tecnicatura Universitaria en Programacion", 141, 5, 4);
    }
    @Override
    public List<Carrera> getCarreras() {
        return new ArrayList<>(repositorioCarrera.values());
    }
}

package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.CarreraService;
import ar.edu.utn.frbb.tup.model.Carrera;
import ar.edu.utn.frbb.tup.model.dto.CarreraDto;
import ar.edu.utn.frbb.tup.persistence.CarreraDao;
import ar.edu.utn.frbb.tup.persistence.exception.CarreraNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class CarreraServiceImpl implements CarreraService{
    @Autowired
    private CarreraDao carreraDao;
    @Override
    public Carrera crearCarrera(CarreraDto carrera){
        Carrera c = new Carrera();
        Random random = new Random();
        c.setId(random.nextLong());
        c.setNombre(carrera.getNombre());
        c.setCodigoCarrera(carrera.getCodigoCarrera());
        c.setDepartamento(carrera.getDepartamento());
        c.setCantidadCuatrimestres(carrera.getCantidadCuatrimestres());
        carreraDao.saveCarrera(c);
        return c;
    }
    public Carrera buscarCarrera(long carreraId) {
        return carreraDao.get(carreraId);
    }
    @Override
    public List<Carrera> obtenerCarreras() {
        return carreraDao.getCarreras();
    }
    @Override
    public Carrera obtenerCarreraPorId(long carreraId) throws CarreraNotFoundException {
        return carreraDao.findById(carreraId);
    }
    @Override
    public Carrera modificarCarrera(long id, CarreraDto carrera) throws CarreraNotFoundException {
        Carrera c = carreraDao.findById(id);
        if (!carrera.getNombre().isEmpty()) {
            c.setNombre(carrera.getNombre());
        }
        if (carrera.getCodigoCarrera() != 0) {
            c.setCodigoCarrera(carrera.getCodigoCarrera());
        }
        if (carrera.getDepartamento() != 0) {
            c.setDepartamento(carrera.getDepartamento());
        }
        if (carrera.getCantidadCuatrimestres() != 0) {
            c.setCantidadCuatrimestres(carrera.getCantidadCuatrimestres());
        }
        carreraDao.saveCarrera(c);
        return c;
    }
    @Override
    public boolean eliminarCarrera(long id) {
        return carreraDao.deleteCarrera(id);
    }

}

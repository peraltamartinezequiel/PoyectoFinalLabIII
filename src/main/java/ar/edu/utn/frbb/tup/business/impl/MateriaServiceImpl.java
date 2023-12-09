package ar.edu.utn.frbb.tup.business.impl;

import ar.edu.utn.frbb.tup.business.CarreraService;
import ar.edu.utn.frbb.tup.business.MateriaService;
import ar.edu.utn.frbb.tup.business.ProfesorService;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.dto.MateriaDto;
import ar.edu.utn.frbb.tup.persistence.MateriaDao;
import ar.edu.utn.frbb.tup.persistence.exception.CarreraNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MateriaServiceImpl implements MateriaService {
    @Autowired
    private MateriaDao dao;

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private CarreraService carreraService;

    @Override
    public Materia crearMateria(MateriaDto materia) throws CarreraNotFoundException {
        Materia m = new Materia();
        Random random = new Random();
        m.setMateriaId(random.nextInt());
        m.setNombre(materia.getNombre());
        m.setAnio(materia.getAnio());
        m.setCuatrimestre(materia.getCuatrimestre());
        m.setProfesor(profesorService.buscarProfesor(materia.getProfesorId()));
        m.setCarrera(carreraService.obtenerCarreraPorId(materia.getCarreraId()));
        dao.save(m);
        return m;
    }
    @Override
    public Materia modificarMateria(int id, MateriaDto materia) throws MateriaNotFoundException, CarreraNotFoundException {
        Materia m = dao.findById(id);
        if (!materia.getNombre().isEmpty()) {
            m.setNombre(materia.getNombre());
        }
        if (materia.getAnio() != 0) {
            m.setAnio(materia.getAnio());
        }
        if (materia.getCuatrimestre() != 0) {
            m.setCuatrimestre(materia.getCuatrimestre());
        }
        if (profesorService.buscarProfesor(materia.getProfesorId()) != null) {
            m.setProfesor(profesorService.buscarProfesor(materia.getProfesorId()));
        }
        if (carreraService.obtenerCarreraPorId(materia.getCarreraId()) != null) {
            m.setCarrera(carreraService.obtenerCarreraPorId(materia.getCarreraId()));
        }
        dao.save(m);
        return m;
    }
    @Override
    public boolean elminarMateria(int id) {
        return dao.deleteMateria(id);
    }

    @Override
    public List<Materia> obtenerMaterias() {
        return dao.getAllMaterias();
    }
    @Override
    public List<Materia> obtenerMateriasPorOrden(String order) {
        return dao.getMateriasByOrder(order);
    }

    @Override
    public Materia getMateriaById(int idMateria) throws MateriaNotFoundException {
        return dao.findById(idMateria);
    }
    @Override
    public Materia getMateriaByNombre(String nombre) throws MateriaNotFoundException{
        return dao.findByNombre(nombre);
    }
}

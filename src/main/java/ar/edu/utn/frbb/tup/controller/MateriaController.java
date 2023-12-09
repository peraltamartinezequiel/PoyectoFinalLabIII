package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.business.MateriaService;
import ar.edu.utn.frbb.tup.model.Carrera;
import ar.edu.utn.frbb.tup.model.Materia;
import ar.edu.utn.frbb.tup.model.Profesor;
import ar.edu.utn.frbb.tup.model.dto.MateriaDto;
import ar.edu.utn.frbb.tup.persistence.exception.CarreraNotFoundException;
import ar.edu.utn.frbb.tup.persistence.exception.MateriaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("materia")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;
    @GetMapping
    public List<Materia> obtenerMaterias() {
        return materiaService.obtenerMaterias();
    }
    @PostMapping
    public Materia crearMateria(@RequestBody MateriaDto materiaDto) throws CarreraNotFoundException {
        return materiaService.crearMateria(materiaDto);
    }
    @PutMapping("/{idMateria}")
    public Materia modificarMateria(@PathVariable Integer idMateria, @RequestBody MateriaDto materiaDto) throws MateriaNotFoundException, CarreraNotFoundException {
        return materiaService.modificarMateria(idMateria, materiaDto);
    }
    @DeleteMapping("/{idMateria}")
    public boolean eliminarMateria(@PathVariable Integer idMateria) {
        return materiaService.elminarMateria(idMateria);
    }
    @GetMapping("/{idMateria}")
    public Materia getMateriaById(@PathVariable Integer idMateria) throws MateriaNotFoundException {
        return materiaService.getMateriaById(idMateria);
    }
    @GetMapping("/nombre")
    public Materia getMateriaByNombre(@RequestParam String nombre) throws MateriaNotFoundException {
        return materiaService.getMateriaByNombre(nombre);
    }
    @GetMapping("/order")
    public List<Materia> getMateriasByOrder(@RequestParam String order) {
        return materiaService.obtenerMateriasPorOrden(order);
    }
}

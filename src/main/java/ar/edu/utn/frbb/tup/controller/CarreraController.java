package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.business.CarreraService;
import ar.edu.utn.frbb.tup.model.Carrera;
import ar.edu.utn.frbb.tup.model.dto.CarreraDto;
import ar.edu.utn.frbb.tup.persistence.exception.CarreraNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("carrera")
public class CarreraController {
    @Autowired
    private CarreraService carreraService;
    @GetMapping
    public List<Carrera> getAllCarreras(){
        return carreraService.obtenerCarreras();
    }
    @PostMapping
    public Carrera crearCarrera(@RequestBody CarreraDto carreraDto){
        return carreraService.crearCarrera(carreraDto);
    }
    @PutMapping("/{id}")
    public Carrera modificarCarrera(@PathVariable Long id, @RequestBody CarreraDto carreraDto) throws CarreraNotFoundException {
        return carreraService.modificarCarrera(id, carreraDto);
    }
    @DeleteMapping("/{id}")
    public boolean eliminarCarrera(@PathVariable Long id) {
        return carreraService.eliminarCarrera(id);
    }
}

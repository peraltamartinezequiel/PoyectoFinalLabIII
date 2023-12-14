package ar.edu.utn.frbb.tup.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MateriaTest {
    private static Materia m;
    private static Materia m1;
    private static Materia m2;
    private static Materia m3;
    private static Materia m4;
    @BeforeAll
    public static void SetUp() {
        Carrera c1 = new Carrera("Tecnicatura Universitaria en Programacion", 141, 5, 4);
        Profesor p1 = new Profesor("Ezequiel", "Peralta", "Tecnico");
        m = new Materia("Laboratorio 3", 2, 1, p1, c1);
        m1 = new Materia("Laboratorio 2", 1, 2, p1, c1);
        m2 = new Materia("Programacion 2", 1, 2, p1, c1);
        m3 = new Materia("Laboratorio 1", 1, 1, p1, c1);
        m4 = new Materia("Programacion 1", 1, 1, p1, c1);
        m.agregarCorrelatividad(m1);
        m.agregarCorrelatividad(m2);
        m.agregarCorrelatividad(m3);
        m.agregarCorrelatividad(m4);
    }
    @Test
    public void NewMateriaTest() {
        Carrera c1 = new Carrera("Tecnicatura Universitaria en Programacion", 141, 5, 4);
        Profesor p1 = new Profesor("Ezequiel", "Peralta", "Tecnico");
        m = new Materia("Laboratorio 3", 2, 1, p1, c1);
        assertEquals("Laboratorio 3", m.getNombre());
        assertEquals(2, m.getAnio());
        assertEquals(1, m.getCuatrimestre());
    }
    @Test
    public void agregarMateriaConCorrelatividades() {
        List<Materia> correlatividades = new ArrayList<>();
        Carrera c1 = new Carrera("Tecnicatura Universitaria en Programacion", 141, 5, 4);
        Profesor p1 = new Profesor("Ezequiel", "Peralta", "Tecnico");
        m = new Materia("Laboratorio 3", 2, 1, p1, c1);
        m.agregarCorrelatividad(m1);
        m.agregarCorrelatividad(m2);
        m.agregarCorrelatividad(m3);
        m.agregarCorrelatividad(m4);
        assertEquals(4, m.getCorrelatividades().size());
        assertEquals("Laboratorio 2", m.getCorrelatividades().get(0).getNombre());
        assertEquals("Programacion 2", m.getCorrelatividades().get(1).getNombre());
        assertEquals("Laboratorio 1", m.getCorrelatividades().get(2).getNombre());
        assertEquals("Programacion 1", m.getCorrelatividades().get(3).getNombre());
    }
}

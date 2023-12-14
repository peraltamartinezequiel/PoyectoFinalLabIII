package ar.edu.utn.frbb.tup.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarreraTest {
    private static Carrera c;
    private static Profesor p1;
    private static Profesor p2;
    private static Profesor p3;
    private static Profesor p4;
    private static Materia m1;
    private static Materia m2;
    private static Materia m3;
    private static Materia m4;
    @BeforeAll
    public static void SetUp() {
        c = new Carrera("Tecnicatura Universitaria en Programacion", 141, 5, 4);
        m1 = new Materia("Laboratorio 1", 1, 1, p1, c);
        m2 = new Materia("Laboratorio 2", 1, 2, p2, c);
        m3 = new Materia("Laboratorio 3", 1, 1, p3, c);
        m4 = new Materia("Laboratorio 4", 1, 1, p4, c);
        c.agregarMateria(m1);
        c.agregarMateria(m2);
        c.agregarMateria(m3);
        c.agregarMateria(m4);
    }
    @Test
    public void NewCarreraTest() {
        c = new Carrera("Tecnicatura Universitaria en Programacion", 141, 5, 4);
        assertEquals("Tecnicatura Universitaria en Programacion", c.getNombre());
        assertEquals(141, c.getCodigoCarrera());
        assertEquals(5, c.getDepartamento());
        assertEquals(4, c.getCantidadCuatrimestres());
    }
    @Test
    public void agregarCarreraConMaterias() {
        List<Materia> materias = new ArrayList<>();
        c = new Carrera("Tecnicatura Universitaria en Programacion", 141, 5, 4);
        c.agregarMateria(m1);
        c.agregarMateria(m2);
        c.agregarMateria(m3);
        c.agregarMateria(m4);
        assertEquals(4, c.getMaterias().size());
        assertEquals("Laboratorio 1", c.getMaterias().get(0).getNombre());
        assertEquals("Laboratorio 2", c.getMaterias().get(1).getNombre());
        assertEquals("Laboratorio 3", c.getMaterias().get(2).getNombre());
        assertEquals("Laboratorio 4", c.getMaterias().get(3).getNombre());
    }
}

package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.App;
import ar.edu.utn.frbb.tup.business.AlumnoService;
import ar.edu.utn.frbb.tup.model.Alumno;
import ar.edu.utn.frbb.tup.model.dto.AlumnoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.web.context.WebApplicationContext;
import org.junit.jupiter.api.BeforeAll;

@ExtendWith(SpringExtension.class)
public class AlumnoControllerTest {
    @InjectMocks
    AlumnoController alumnoController;
    @Mock
    AlumnoService alumnoService;
    MockMvc mockMvc;
    private static final ObjectMapper mapper = new ObjectMapper();
    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(alumnoController).build();
    }
    @Test
    public void crearAlumnoTest() throws Exception {
        Mockito.when(alumnoService.crearAlumno(any(AlumnoDto.class))).thenReturn(new Alumno());
        AlumnoDto alumnoDto = new AlumnoDto();
        alumnoDto.setNombre("Ezequiel");
        alumnoDto.setApellido("Peralta");
        alumnoDto.setDni(44417824);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/alumno")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(alumnoDto))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andReturn();
    }

}

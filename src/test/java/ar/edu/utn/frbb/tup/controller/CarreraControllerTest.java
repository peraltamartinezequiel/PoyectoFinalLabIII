package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.business.CarreraService;
import ar.edu.utn.frbb.tup.model.Carrera;
import ar.edu.utn.frbb.tup.model.dto.CarreraDto;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
public class CarreraControllerTest {
    @InjectMocks
    CarreraController carreraController;
    @Mock
    CarreraService carreraService;
    MockMvc mockMvc;
    private static final ObjectMapper mapper = new ObjectMapper();
    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(carreraController).build();
    }
    @Test
    public void crearCarreraTest() throws Exception {
        Mockito.when(carreraService.crearCarrera(any(CarreraDto.class))).thenReturn(new Carrera());
        CarreraDto carreraDto = new CarreraDto();
        carreraDto.setNombre("Programacion");
        carreraDto.setCodigoCarrera(141);
        carreraDto.setDepartamento(5);
        carreraDto.setCantidadCuatrimestres(4);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/carrera")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(carreraDto))
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andReturn();
    }

}

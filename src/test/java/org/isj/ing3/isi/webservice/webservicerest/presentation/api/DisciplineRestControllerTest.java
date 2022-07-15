package org.isj.ing3.isi.webservice.webservicerest.presentation.api;

import org.isj.ing3.isi.webservice.webservicerest.model.entities.Discipline;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Email;
import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.DisciplineServiceImpl;
import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.EmailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DisciplineRestControllerTest {
    private static final String ENDPOINT_URL = "/api/discipline";
    @InjectMocks
    private DisciplineRestController disciplineRestController;

    @Mock
    private DisciplineServiceImpl disciplineService;

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    void setUp() {
        this.mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void enregistrer() throws Exception {
        Mockito.when(disciplineService.saveDiscipline(ArgumentMatchers.any(Discipline.class))).thenReturn(1);

        mockMvc.perform(
                MockMvcRequestBuilders.post(ENDPOINT_URL+"/save")
                        .contentType(MediaType.APPLICATION_JSON));
        //.andExpect(MockMvcResultMatchers.status().isCreated());
        // Mockito.verify(emailService, Mockito.times(1)).saveEmail(ArgumentMatchers.any(Email.class));
        Mockito.verifyNoMoreInteractions(disciplineService);
    }

    @Test
    void getDisciplineByCode() {
    }

    @Test
    void getAllDiscipline() throws Exception {
        Mockito.when(disciplineService.listDisciplines()).thenReturn(null);


        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL+"/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
        //      .andExpect(MockMvcResultMatchers.jsonPath("$.code.content", Matchers.hasSize(10)));

        // Mockito.verify(emailService, Mockito.times(1)).listEmails();
        Mockito.verifyNoMoreInteractions(disciplineService);
    }

    @Test
    void deteleDiscipline() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/001"+"/delete")
                        .contentType(MediaType.APPLICATION_JSON));
        //   .andExpect(MockMvcResultMatchers.status().isOk());
        // Mockito.verify(emailService, Mockito.times(1)).deleteEmail(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(disciplineService);
    }
}
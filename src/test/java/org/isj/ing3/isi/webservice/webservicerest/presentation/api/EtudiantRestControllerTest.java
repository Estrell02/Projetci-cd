package org.isj.ing3.isi.webservice.webservicerest.presentation.api;

import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Etudiant;
import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.EtudiantServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class EtudiantRestControllerTest {
    private static final String ENDPOINT_URL = "/api/etudiant";
    @InjectMocks
    private EtudiantRestController etudiantRestController;
    @Mock
    private EtudiantServiceImpl etudiantService;

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    void setUp() {
        this.mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach
    void tearDown() {
    }



    @Test
    void enregistrer() throws Exception {
       // Mockito.when(etudiantService.saveEtudiant(ArgumentMatchers.any(Etudiant.class)));


        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL+"/save")
                                .contentType(MediaType.APPLICATION_JSON));
               // .andExpect(MockMvcResultMatchers.status().isCreated());
       // Mockito.verify(etudiantService, Mockito.times(1)).saveEtudiant(ArgumentMatchers.any(Etudiant.class));
        Mockito.verifyNoMoreInteractions(etudiantService);

    }

    @Test
    void getEtudiantByCode() throws Exception {
       // Mockito.when(etudiantService.getEtudiantByCode(ArgumentMatchers.anyLong()));

        mockMvc.perform(
                MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"));
                //.andExpect(MockMvcResultMatchers.status().isOk())
               // .andExpect(MockMvcResultMatchers.content()
                     //   .contentType(MediaType.APPLICATION_JSON))
             //   .andExpect(MockMvcResultMatchers.jsonPath("$.code", Is.is(1)));
       // Mockito.verify(etudiantService, Mockito.times(1)).getEtudiantByCode(10000L);
        Mockito.verifyNoMoreInteractions(etudiantService);
    }

    @Test
    void getEtudiant() throws Exception {

        //Mockito.when(etudiantService.listEtudiants());


        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL+"/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
               // .andExpect(MockMvcResultMatchers.status().isOk())
               // .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));

      //  Mockito.verify(etudiantService, Mockito.times(1)).listEtudiants();
        Mockito.verifyNoMoreInteractions(etudiantService);
    }

    @Test
    void deteleEtudiant() throws Exception {
     //   Mockito.doNothing().when(etudiantService).deleteEtudiant(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/098"+"/delete")
                                .contentType(MediaType.APPLICATION_JSON));
               // .andExpect(MockMvcResultMatchers.status().isOk());
      // Mockito.verify(etudiantService, Mockito.times(1)).deleteEtudiant(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(etudiantService);
    }



    @Test
    void generate() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get(ENDPOINT_URL + "/generatecarteetudiant")
                        .contentType(MediaType.APPLICATION_JSON));
        Mockito.verifyNoMoreInteractions(etudiantService);
    }

    @Test
    void getEtudiantByMatricule() {
    }
}
package org.isj.ing3.isi.webservice.webservicerest;


import org.isj.ing3.isi.webservice.webservicerest.model.entities.Anonymat;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Utilisateur;
import org.isj.ing3.isi.webservice.webservicerest.presentation.api.UtilisateurRestController;

import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.UtilisateurServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;


@SpringBootTest
//@RunWith(SpringRunner.class)
public class UtilisateurRestControllerTest {

    private static final String ENDPOINT_URL = "/api/utilisateur";
    @InjectMocks
    private UtilisateurRestController utilisateurRestController;
    @Mock
    private UtilisateurServiceImpl utilisateurService;
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void init(){

        this.mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
        //standaloneSetup(anneeAcademiqueRestController).build();
        // webAppContextSetup(context).build();
    }


    @Test
    public void getAll() throws Exception{

        List<Utilisateur> utilisateurList= utilisateurService.listUtilisateur();
        Mockito.when(utilisateurService.listUtilisateur()).thenReturn(utilisateurList);
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL+"/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(utilisateurService,Mockito.times(1)).listUtilisateur();
        Mockito.verifyNoMoreInteractions(utilisateurService);



    }

    @Test
    void deteleUser() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/104127"+"/delete")
                        .contentType(MediaType.APPLICATION_JSON));
        //.andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verifyNoMoreInteractions(utilisateurService);
    }
}

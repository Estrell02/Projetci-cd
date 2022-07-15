package org.isj.ing3.isi.webservice.webservicerest;


import org.isj.ing3.isi.webservice.webservicerest.exception.ErrorInfo;
import org.isj.ing3.isi.webservice.webservicerest.exception.IsjException;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.EstInscrit;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Role;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Utilisateur;
import org.isj.ing3.isi.webservice.webservicerest.presentation.api.EstInscritRestController;
import org.isj.ing3.isi.webservice.webservicerest.repositories.EstInscritRepository;
import org.isj.ing3.isi.webservice.webservicerest.repositories.UtilisateurRepository;
import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.EstInscritServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.List;

@SpringBootTest
public class EstInscritServiceImplTest {
    private static final String ENDPOINT_URL = "/api/est-inscrit";

    @InjectMocks
    private EstInscritRestController estInscritRestController;

    @Mock
    private EstInscritServiceImpl estInscritService;
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;



    @BeforeEach
    public void init()  {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    public static List<String> getIds(){return Collections.singletonList("1");}
    public static EstInscrit getEstInscrit(){
        EstInscrit estInscrit = new EstInscrit();
        estInscrit.setCode(Long.parseLong("106979"));
        return estInscrit;
    }

    @Test
    public void testSaveEstInscrit() throws Exception{
        Mockito.when(estInscritService.saveInscrit(ArgumentMatchers.any(EstInscrit.class))).thenReturn(1);
        mockMvc.perform( MockMvcRequestBuilders.post(ENDPOINT_URL+"/save").contentType(MediaType.APPLICATION_JSON));
        //.andExpect(MockMvcResultMatchers.status().isCreated());
        //Mockito.verify(anonymatService,Mockito.times(1)).saveAnonymat(ArgumentMatchers.any(Anonymat.class));
        Mockito.verifyNoMoreInteractions(estInscritService);
    }

    @Test
    public void testDeleteEstInscrit() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.delete(ENDPOINT_URL+"/106979"+"/delete").contentType(MediaType.APPLICATION_JSON));
        Mockito.verifyNoMoreInteractions(estInscritService);
    }

}

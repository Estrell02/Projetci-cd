package org.isj.ing3.isi.webservice.webservicerest;


import org.isj.ing3.isi.webservice.webservicerest.model.entities.Anonymat;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Candidat;
import org.isj.ing3.isi.webservice.webservicerest.presentation.api.AnonymatRestController;
import org.isj.ing3.isi.webservice.webservicerest.presentation.api.CandidatRestController;
import org.isj.ing3.isi.webservice.webservicerest.repositories.CandidatRepository;
import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.CandidatServiceImpl;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class CandidatRestControllerTest {

    private static final String ENDPOINT_URL = "/api/candidat";
    @InjectMocks
    private CandidatRestController candidatRestController;
    @Mock
    private CandidatServiceImpl candidatService;
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void init(){

        this.mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
        //standaloneSetup(anneeAcademiqueRestController).build();
        // webAppContextSetup(context).build();
    }
//
//    @Test
//    public void testSave() throws Exception{
//        Mockito.when(candidatService.saveCandidat(ArgumentMatchers.any(Candidat.class))).thenReturn(ArgumentMatchers.any(CandidatRepository.class));
//        mockMvc.perform( MockMvcRequestBuilders.post(ENDPOINT_URL+"/save").contentType(MediaType.APPLICATION_JSON));
//        //.andExpect(MockMvcResultMatchers.status().isCreated());
//        //Mockito.verify(candidatService,Mockito.times(1)).saveCandidat(ArgumentMatchers.any(Candidat.class));
//        Mockito.verifyNoMoreInteractions(candidatService);
//    }

    @Test
    public void getAll() throws Exception{
//        Mockito.when(candidatService.listAnonymat()) ;
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL+"/all")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
        List<Candidat> candidatList = candidatService.listCandidats();
        Mockito.when(candidatService.listCandidats()).thenReturn(candidatList);
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL+"/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(candidatService,Mockito.times(1)).listCandidats();
        Mockito.verifyNoMoreInteractions(candidatService);



    }

    @Test
    void deteleCandidat() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/56"+"/delete")
                        .contentType(MediaType.APPLICATION_JSON));
        //.andExpect(MockMvcResultMatchers.status().isOk());
        //Mockito.verify(anneeAccademiqueService, Mockito.times(1)).deleteAnneAcademique(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(candidatService);
    }
}



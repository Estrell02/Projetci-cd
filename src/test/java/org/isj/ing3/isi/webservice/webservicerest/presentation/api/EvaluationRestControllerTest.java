package org.isj.ing3.isi.webservice.webservicerest;


import org.isj.ing3.isi.webservice.webservicerest.model.entities.Evaluation;

import org.isj.ing3.isi.webservice.webservicerest.presentation.api.EvaluationRestController;

import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.EvaluationServiceImpl;
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
public class EvaluationRestControllerTest {


    private static final String ENDPOINT_URL = "/api/evaluation";
    @InjectMocks
    private EvaluationRestController evaluationRestController;
    @Mock
    private EvaluationServiceImpl evaluationService;
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
//        Mockito.when(anonymatService.listAnonymat()) ;
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL+"/all")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
        List<Evaluation> evaluationList = evaluationService.listEvaluation();
        Mockito.when(evaluationService.listEvaluation()).thenReturn(evaluationList);
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL+"/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(evaluationService,Mockito.times(1)).listEvaluation();
        Mockito.verifyNoMoreInteractions(evaluationService);



    }

    @Test
    void deteleEvaluation() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/56"+"/delete")
                        .contentType(MediaType.APPLICATION_JSON));
        //.andExpect(MockMvcResultMatchers.status().isOk());
        //Mockito.verify(anneeAccademiqueService, Mockito.times(1)).deleteAnneAcademique(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(evaluationService);
    }
}


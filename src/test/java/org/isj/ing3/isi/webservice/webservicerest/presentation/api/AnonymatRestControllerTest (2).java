package org.isj.ing3.isi.webservice.webservicerest;

import org.isj.ing3.isi.webservice.webservicerest.exception.IsjException;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.AnneeAcademique;

import org.isj.ing3.isi.webservice.webservicerest.model.entities.Anonymat;
import org.isj.ing3.isi.webservice.webservicerest.presentation.api.AnonymatRestController;

import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.AnonymatServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class AnonymatRestControllerTest {

    private static final String ENDPOINT_URL = "/api/anonymat";
    @InjectMocks
    private AnonymatRestController anonymatRestController;
    @Mock
    private AnonymatServiceImpl anonymatService;
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void init(){

        this.mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
        //standaloneSetup(anneeAcademiqueRestController).build();
        // webAppContextSetup(context).build();
    }
    public static Anonymat getDto() {
        Anonymat dto = new Anonymat();

        return dto;
    }
    @Test
    public void testSave() throws Exception{
        Mockito.when(anonymatService.saveAnonymat(ArgumentMatchers.any(Anonymat.class))).thenReturn(1);
        mockMvc.perform( MockMvcRequestBuilders.post(ENDPOINT_URL+"/save").contentType(MediaType.APPLICATION_JSON));
        //.andExpect(MockMvcResultMatchers.status().isCreated())
        //Mockito.verify(anonymatService,Mockito.times(1)).saveAnonymat(ArgumentMatchers.any(Anonymat.class));
        Mockito.verifyNoMoreInteractions(anonymatService);
    }

    @Test
    public void getAll() throws Exception{
//        Mockito.when(anonymatService.listAnonymat()) ;
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL+"/all")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
        List<Anonymat> anonymatList = anonymatService.listAnonymat();
        Mockito.when(anonymatService.listAnonymat()).thenReturn(anonymatList);
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL+"/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(anonymatService,Mockito.times(1)).listAnonymat();
        Mockito.verifyNoMoreInteractions(anonymatService);



    }

//    @Test
//    public void updateAnonymat() throws Exception{
//        Anonymat ano = new Anonymat();
//        Mockito.when(anonymatService.UpdateAnonymat(ArgumentMatchers.any(Anonymat.class))).thenReturn(ArgumentMatchers.anyInt());
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL+"/update").contentType(MediaType.APPLICATION_JSON));
//        Mockito.verifyNoMoreInteractions(anonymatService);
//    }

//    @Test
//    public void getAnobyNum() throws Exception{
//        Mockito.when(anonymatService.getAnonymatByNumeroAnonymat(ArgumentMatchers.anyString())).thenReturn(ArgumentMatchers.any(Anonymat.class));
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL+"/RéfL149"+"/searchNumAnonymat")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isOk());
//       // Mockito.verify(anonymatService,Mockito.times(1)).getAnonymatByNumeroAnonymat(ArgumentMatchers.anyString());
//        Mockito.verifyNoMoreInteractions(anonymatService);
//    }
//
//    @Test
//    public void listAnoByEvaluation() throws Exception{
//        Mockito.when(anonymatService.ListAnonymatByEvaluation(ArgumentMatchers.anyLong())).thenReturn(ArgumentMatchers.anyList());
//
//    }
//

    @Test
    void deteleAnonymat() throws Exception {
        // Mockito.doNothing().when(anneeAccademiqueService).deleteAnneAcademique(ArgumentMatchers.anyLong());

        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/56"+"/delete")
                        .contentType(MediaType.APPLICATION_JSON));
        //.andExpect(MockMvcResultMatchers.status().isOk());
        //Mockito.verify(anneeAccademiqueService, Mockito.times(1)).deleteAnneAcademique(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(anonymatService);
    }
}

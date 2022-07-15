package org.isj.ing3.isi.webservice.webservicerest.presentation.api;

import org.isj.ing3.isi.webservice.webservicerest.exception.IsjException;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.AnneeAcademique;
import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.AnneeAccademiqueServiceImpl;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@RunWith(SpringRunner.class)
class AnneeAcademiqueRestControllerTest {
    private static final String ENDPOINT_URL = "/api/annee-accademique";
    @InjectMocks
    private AnneeAcademiqueRestController anneeAcademiqueRestController;
    @Mock
    private AnneeAccademiqueServiceImpl anneeAccademiqueService;
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void init(){

        this.mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
        //standaloneSetup(anneeAcademiqueRestController).build();
        // webAppContextSetup(context).build();
    }
    public static AnneeAcademique getDto() {
        AnneeAcademique dto = new AnneeAcademique();

        return dto;
    }


    @Test
    void enregistrer() throws Exception {

//AnneeAcademique anneeAcademique=new AnneeAcademique();
       Mockito.when(anneeAccademiqueService.saveAnneeAcademique(ArgumentMatchers.any(AnneeAcademique.class))).thenReturn(1);


        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL+"/save")
                                .contentType(MediaType.APPLICATION_JSON));
             //  .andExpect(MockMvcResultMatchers.status().isOk());
     // Mockito.verify(anneeAccademiqueService, Mockito.times(1)).saveAnneeAcademique(ArgumentMatchers.any(AnneeAcademique.class));
        Mockito.verifyNoMoreInteractions(anneeAccademiqueService);
    }

    @Test
    void getAllAnneeAccademique() {
    }

    @Test
    void deteleAnneeAccademique() throws Exception {
       // Mockito.doNothing().when(anneeAccademiqueService).deleteAnneAcademique(ArgumentMatchers.anyLong());

        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/56"+"/delete")
                                .contentType(MediaType.APPLICATION_JSON));
                //.andExpect(MockMvcResultMatchers.status().isOk());
        //Mockito.verify(anneeAccademiqueService, Mockito.times(1)).deleteAnneAcademique(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(anneeAccademiqueService);
    }
}
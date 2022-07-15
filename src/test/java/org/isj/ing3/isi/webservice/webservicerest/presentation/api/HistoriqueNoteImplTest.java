package org.isj.ing3.isi.webservice.webservicerest;


import org.isj.ing3.isi.webservice.webservicerest.exception.ErrorInfo;
import org.isj.ing3.isi.webservice.webservicerest.exception.IsjException;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.HistoriqueNote;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Role;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Utilisateur;
import org.isj.ing3.isi.webservice.webservicerest.presentation.api.HistoriqueNoteRestController;
import org.isj.ing3.isi.webservice.webservicerest.repositories.HistoriqueNoteRepository;
import org.isj.ing3.isi.webservice.webservicerest.repositories.UtilisateurRepository;

import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.HistoriqueNoteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zalando.problem.Status;

import java.util.Collections;
import java.util.List;

@SpringBootTest

public class HistoriqueNoteImplTest {
    private static final String ENDPOINT_URL = "/api/historique-note";

    @InjectMocks
    private HistoriqueNoteRestController historiqueNoteRestController;

    @Mock
    private HistoriqueNoteServiceImpl HistoriqueNoteService;
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;





    //    void setUp(){
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(AnonymatRestController).build();
//    }
    @BeforeEach
    public void init()  {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    public static List<String> getIds(){return Collections.singletonList("1");}
    public static HistoriqueNote getHistoriqueNote(){
        HistoriqueNote historiqueNote = new HistoriqueNote();
        historiqueNote.setCode(Long.parseLong("106979"));
        return historiqueNote;
    }


    @Test
    public void testSaveHistoriqueNote() throws Exception{
        Mockito.when(HistoriqueNoteService.saveHistoriqueNote(ArgumentMatchers.any(HistoriqueNote.class))).thenReturn(1);
        mockMvc.perform( MockMvcRequestBuilders.post(ENDPOINT_URL+"/save").contentType(MediaType.APPLICATION_JSON));
        Mockito.verifyNoMoreInteractions(HistoriqueNoteService);
    }

    @Test
    public void testGetallHistoriqueNote() throws Exception{
        //Mockito.when(anonymatService.listHistoriqueNote()).thenReturn('500');
    }

    @Test
    public void testDeleteHistoriqueNote() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.delete(ENDPOINT_URL+"/106979"+"/delete").contentType(MediaType.APPLICATION_JSON));
        Mockito.verifyNoMoreInteractions(HistoriqueNoteService);
    }




}

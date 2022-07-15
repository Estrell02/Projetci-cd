package org.isj.ing3.isi.webservice.webservicerest;


import org.isj.ing3.isi.webservice.webservicerest.exception.ErrorInfo;
import org.isj.ing3.isi.webservice.webservicerest.exception.IsjException;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Note;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Role;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Utilisateur;
import org.isj.ing3.isi.webservice.webservicerest.presentation.api.NoteRestController;
import org.isj.ing3.isi.webservice.webservicerest.repositories.NoteRepository;
import org.isj.ing3.isi.webservice.webservicerest.repositories.UtilisateurRepository;
import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.NoteServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zalando.problem.Status;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class NoteServiceImplTest {
    private static final String ENDPOINT_URL = "/api/note";

    @InjectMocks
    private NoteRestController noteRestController;

    @Mock
    private NoteServiceImpl noteService;
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;
    private Object AnonymatBuilder;


    @BeforeEach
    public void init()  {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    public static List<String> getIds(){return Collections.singletonList("1");}
    public static Note getNote(){
        Note note = new Note();
        note.setCode(Long.parseLong("106979"));
        return note;
    }

    @Test
    public void testSaveNote() throws Exception{
        OngoingStubbing<Integer> integerOngoingStubbing = Mockito.when(noteService.saveNote(ArgumentMatchers.any(Note.class))).thenReturn(1);
        mockMvc.perform( MockMvcRequestBuilders.post(ENDPOINT_URL+"/save").contentType(MediaType.APPLICATION_JSON));
        //.andExpect(MockMvcResultMatchers.status().isCreated());
        //Mockito.verify(anonymatService,Mockito.times(1)).saveAnonymat(ArgumentMatchers.any(Anonymat.class));
        Mockito.verifyNoMoreInteractions(noteService);
    }

    @Test
    public void testGetallNote() throws Exception{
        //Mockito.when(noteService.listNote()).thenReturn('500');
    }

    @Test
    public void testDeleteNote() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.delete(ENDPOINT_URL+"/106979"+"/delete").contentType(MediaType.APPLICATION_JSON));
        //.andExpect(MockMvcResultMatchers.status().isOk());
        //demande a mockito de verifier si dans le service anonymat la methode deleteAnonymat a ete
        // appele exactement une fois avec des attributs de type long
        // Mockito.verify(anonymatService,Mockito.times(1)).deleteAnonymat(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(noteService);
    }

}

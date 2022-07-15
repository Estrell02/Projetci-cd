package org.isj.ing3.isi.webservice.webservicerest;


import org.isj.ing3.isi.webservice.webservicerest.model.entities.Anonymat;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.EnvoiMessage;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Utilisateur;
import org.isj.ing3.isi.webservice.webservicerest.presentation.api.EnvoiMessageRestController;
import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.EnvoimessageServiceImpl;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@SpringBootTest
public class EnvoiMessageRestControllerTest {

    private static final String ENDPOINT_URL = "/api/envoi-message";
    @InjectMocks
    private EnvoiMessageRestController envoiMessageRestController;
    @Mock
    private EnvoimessageServiceImpl envoimessageService;
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void init(){

        this.mockMvc= MockMvcBuilders.webAppContextSetup(context).build();

    }
    @Test
    public void testSave() throws Exception{
        Mockito.when(envoimessageService.saveEnvoiMessage(ArgumentMatchers.any(EnvoiMessage.class))).thenReturn(1);
        mockMvc.perform( MockMvcRequestBuilders.post(ENDPOINT_URL+"/save").contentType(MediaType.APPLICATION_JSON));

        Mockito.verifyNoMoreInteractions(envoimessageService);
    }


    @Test
    public void getAll() throws Exception{

        List<EnvoiMessage> messagesList= envoimessageService.listEnvoiMessage();
        Mockito.when(envoimessageService.listEnvoiMessage()).thenReturn(messagesList);
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL+"/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(envoimessageService,Mockito.times(1)).listEnvoiMessage();
        Mockito.verifyNoMoreInteractions(envoimessageService);



    }

    @Test
    void deteleEnvoimessage() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/001"+"/delete")
                        .contentType(MediaType.APPLICATION_JSON));
        //.andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verifyNoMoreInteractions(envoimessageService);
    }
}

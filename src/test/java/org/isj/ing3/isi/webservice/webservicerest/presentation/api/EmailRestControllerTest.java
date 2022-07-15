package org.isj.ing3.isi.webservice.webservicerest.presentation.api;

import org.hamcrest.Matchers;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Email;
import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.EmailServiceImpl;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class EmailRestControllerTest {

    private static final String ENDPOINT_URL = "/api/email";
    @InjectMocks
    private EmailRestController emailRestController;
    @Mock
    private EmailServiceImpl emailService;

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
        Mockito.when(emailService.saveEmail(ArgumentMatchers.any(Email.class))).thenReturn(1);


        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL+"/save")
                                .contentType(MediaType.APPLICATION_JSON));
              //.andExpect(MockMvcResultMatchers.status().isCreated());
       // Mockito.verify(emailService, Mockito.times(1)).saveEmail(ArgumentMatchers.any(Email.class));
        Mockito.verifyNoMoreInteractions(emailService);
    }

    @Test
    void getEmailCode() {
    }

    @Test
    void getAllEmail() throws Exception {
        List <Email> emailList=emailService.listEmails();
        Mockito.when(emailService.listEmails()).thenReturn(emailList);


        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL+"/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
          //      .andExpect(MockMvcResultMatchers.jsonPath("$.code.content", Matchers.hasSize(10)));

        Mockito.verify(emailService, Mockito.times(1)).listEmails();
        Mockito.verifyNoMoreInteractions(emailService);
    }

    @Test
    void deteleEmail() throws Exception {
     //   Mockito.doNothing().when(emailService).deleteEmail(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/001"+"/delete")
                                .contentType(MediaType.APPLICATION_JSON));
             //   .andExpect(MockMvcResultMatchers.status().isOk());
       // Mockito.verify(emailService, Mockito.times(1)).deleteEmail(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(emailService);
    }
}
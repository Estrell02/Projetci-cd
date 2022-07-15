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
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class SemestreRestControllerTest {


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
    void enregistrerSemestre() throws Exception {
       // Mockito.when(emailService.saveEmail(ArgumentMatchers.any(Email.class)));


        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL+"/save")
                                .contentType(MediaType.APPLICATION_JSON));
         //       .andExpect(MockMvcResultMatchers.status().isCreated());
       // Mockito.verify(emailService, Mockito.times(1)).saveEmail(ArgumentMatchers.any(Email.class));
        Mockito.verifyNoMoreInteractions(emailService);
    }


}



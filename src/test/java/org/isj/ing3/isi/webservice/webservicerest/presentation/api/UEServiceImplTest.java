package org.isj.ing3.isi.webservice.webservicerest;


import org.isj.ing3.isi.webservice.webservicerest.exception.ErrorInfo;
import org.isj.ing3.isi.webservice.webservicerest.exception.IsjException;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Role;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.UE;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Utilisateur;
import org.isj.ing3.isi.webservice.webservicerest.presentation.api.UERestController;
import org.isj.ing3.isi.webservice.webservicerest.repositories.UERepository;
import org.isj.ing3.isi.webservice.webservicerest.repositories.UtilisateurRepository;

import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.UEServiceImpl;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.List;

@SpringBootTest
public class UEServiceImplTest {
    private static final String ENDPOINT_URL = "/api/ue";

    @InjectMocks
    private UERestController ueRestController;

    @Mock
    private UEServiceImpl ueService;
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;
    @BeforeEach
    public void init()  {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    public static List<String> getIds(){return Collections.singletonList("1");}
    public static Role getRole(){
        Role role = new Role();
        role.setCode(Long.parseLong("106979"));
        return role;
    }

    // @Test
//    public void getById() throws Exception {
//        Mockito.when(anonymatService.getAnonymatByCode(ArgumentMatchers.anyLong()))
//                .thenReturn(AnonymatBuilder.getAnonymat());
//          mockMvc.perform(get(ENDPOINT_URL+"/106979"+"/data"))
//                  //.andExpect(status().isOk())
//                  .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//                  //.andExpect(jsonPath("$.date_creation").value("2021-01-28 10:25:42"))
//                  //.andExpect(jsonPath("$.date_modification").value("2021-02-23 12:10:18"));
//
//    }

    @Test
    public void testSaveUe() throws Exception{
        Mockito.when(ueService.saveUE(ArgumentMatchers.any(UE.class))).thenReturn(1);
        mockMvc.perform( MockMvcRequestBuilders.post(ENDPOINT_URL+"/save").contentType(MediaType.APPLICATION_JSON));
        //.andExpect(MockMvcResultMatchers.status().isCreated());
        //Mockito.verify(anonymatService,Mockito.times(1)).saveAnonymat(ArgumentMatchers.any(Anonymat.class));
        Mockito.verifyNoMoreInteractions(ueService);
    }

    @Test
    public void testGetallAnonymat() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete(ENDPOINT_URL+"/106979"+"/delete").contentType(MediaType.APPLICATION_JSON));
        //.andExpect(MockMvcResultMatchers.status().isOk());
        //demande a mockito de verifier si dans le service anonymat la methode deleteAnonymat a ete
        // appele exactement une fois avec des attributs de type long
        // Mockito.verify(anonymatService,Mockito.times(1)).deleteAnonymat(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(ueService);
    }
}

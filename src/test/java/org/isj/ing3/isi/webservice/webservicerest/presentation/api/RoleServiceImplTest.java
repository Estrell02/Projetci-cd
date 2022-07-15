package org.isj.ing3.isi.webservice.webservicerest;


import org.isj.ing3.isi.webservice.webservicerest.model.entities.Role;
import org.isj.ing3.isi.webservice.webservicerest.presentation.api.RoleRestController;
import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.RoleServiceImpl;
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
public class RoleServiceImplTest {
    private static final String ENDPOINT_URL = "/api/role";

    @InjectMocks
    private RoleRestController roleRestController;

    @Mock
    private RoleServiceImpl roleService;
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
    public void testSaveRole() throws Exception{
        Mockito.when(roleService.saveRole(ArgumentMatchers.any(Role.class))).thenReturn(1L);
        mockMvc.perform( MockMvcRequestBuilders.post(ENDPOINT_URL+"/save").contentType(MediaType.APPLICATION_JSON));
        //.andExpect(MockMvcResultMatchers.status().isCreated());
        //Mockito.verify(anonymatService,Mockito.times(1)).saveAnonymat(ArgumentMatchers.any(Anonymat.class));
        Mockito.verifyNoMoreInteractions(roleService);
    }

//    @Test
//    public void testGetallAnonymat() throws Exception{
//        //Mockito.when(anonymatService.listAnonymat()).thenReturn('500');
//    }

    @Test
    public void testDeleteRole() throws Exception{

        //Mockito.doNothing().when(anonymatService).deleteAnonymat(ArgumentMatchers.anyLong());
        mockMvc.perform(MockMvcRequestBuilders.delete(ENDPOINT_URL+"/106979"+"/delete").contentType(MediaType.APPLICATION_JSON));
        //.andExpect(MockMvcResultMatchers.status().isOk());
        //demande a mockito de verifier si dans le service anonymat la methode deleteAnonymat a ete
        // appele exactement une fois avec des attributs de type long
        // Mockito.verify(anonymatService,Mockito.times(1)).deleteAnonymat(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(roleService);
    }




}


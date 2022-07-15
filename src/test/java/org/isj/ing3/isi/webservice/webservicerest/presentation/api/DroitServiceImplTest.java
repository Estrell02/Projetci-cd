package org.isj.ing3.isi.webservice.webservicerest;



import org.isj.ing3.isi.webservice.webservicerest.exception.IsjException;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Droit;
import org.isj.ing3.isi.webservice.webservicerest.presentation.api.DroitRestController;
import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.DroitServiceImpl;
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
public class DroitServiceImplTest {
    private static final String ENDPOINT_URL = "/api/droit";

    @InjectMocks
    private DroitRestController droitRestController;

    @Mock
    private DroitServiceImpl droitService;
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;



    @BeforeEach
    public void init()  {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    public static List<String> getIds(){return Collections.singletonList("1");}
    public static Droit getDroit(){
        Droit droit = new Droit();
        droit.setCode(Long.parseLong("106979"));
        return droit;
    }

    @Test
    public void testSaveDroit() throws Exception{
        Mockito.when(droitService.saveDroit(ArgumentMatchers.any(Droit.class))).thenReturn(1);
        mockMvc.perform( MockMvcRequestBuilders.post(ENDPOINT_URL+"/save").contentType(MediaType.APPLICATION_JSON));
        //.andExpect(MockMvcResultMatchers.status().isCreated());
        //Mockito.verify(anonymatService,Mockito.times(1)).saveAnonymat(ArgumentMatchers.any(Anonymat.class));
        Mockito.verifyNoMoreInteractions(droitService);
    }

    @Test
    public void testGetallDroit() throws Exception{
        //Mockito.when(droitService.listDroit()).thenReturn('500');
    }

    @Test
    public void testDeleteDroit() throws Exception{

        //Mockito.doNothing().when(droitService).deleteDroit(ArgumentMatchers.anyLong());
        mockMvc.perform(MockMvcRequestBuilders.delete(ENDPOINT_URL+"/106979"+"/delete").contentType(MediaType.APPLICATION_JSON));
        Mockito.verifyNoMoreInteractions(droitService);
    }


//    @Test
//    public void testgetDroitByCode(Long code) throws IsjException {
//        //Mockito.when(droitService.listDroit()).thenReturn('500');
//    }


}

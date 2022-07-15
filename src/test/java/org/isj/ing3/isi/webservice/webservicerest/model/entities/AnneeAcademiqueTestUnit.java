package org.isj.ing3.isi.webservice.webservicerest.model.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.isj.ing3.isi.webservice.webservicerest.presentation.api.AnneeAcademiqueRestController;
import org.isj.ing3.isi.webservice.webservicerest.repositories.UtilisateurRepository;
import org.isj.ing3.isi.webservice.webservicerest.serviceImpl.AnneeAccademiqueServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest

class AnneeAcademiqueTestUnit {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private AnneeAccademiqueServiceImpl anneeAccademiqueService;

    @Autowired
    UtilisateurRepository utilisateurRepository;


    ObjectMapper mapper = new ObjectMapper();
    String resultContent = null;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AnneeAcademique dao;










}

package org.isj.ing3.isi.webservice.webservicerest.service;


import org.isj.ing3.isi.webservice.webservicerest.exception.IsjException;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.EstInscrit;

import java.util.List;


public interface IEstInscrit {
    int saveInscrit(EstInscrit estInscrit) throws IsjException;
    int deleteInscrit(Long code) throws IsjException;
    int updateEstInscrit(EstInscrit estInscrit ) throws IsjException;
    List<EstInscrit> listInscrit();

    EstInscrit ListeDesInscrit(Long code) throws  IsjException;

    EstInscrit getInscritByCode(Long code) throws IsjException;
    EstInscrit getInscritByCandidatInscritAndEnseignement (Long CodeCandidat,Long CodeEnseignement) throws  IsjException;
}

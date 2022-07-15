package org.isj.ing3.isi.webservice.webservicerest.service;


import org.isj.ing3.isi.webservice.webservicerest.exception.IsjException;
import org.isj.ing3.isi.webservice.webservicerest.model.entities.Evaluation;

import java.util.List;

public interface IEvaluation {

    int saveEvaluation(Evaluation evaluation) throws IsjException;
    int deleteEvaluation(Long code) throws IsjException;
   int updateEvaluation(Evaluation evaluation ) throws IsjException;
    List<Evaluation> listEvaluation();
    Evaluation getEvaluationByCode(Long code) throws IsjException;


   Evaluation searchTypeEtudiant(String TypeEv, String codeUe, Long an) throws  IsjException;
     Evaluation searchTypeEvaluation(Long code) throws  IsjException ;

}

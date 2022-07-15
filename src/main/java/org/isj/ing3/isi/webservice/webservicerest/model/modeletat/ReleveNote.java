package org.isj.ing3.isi.webservice.webservicerest.model.modeletat;

import lombok.Data;

@Data
public class ReleveNote {
    private Long codeClasse;
    private String decision;
    private String typeReleve;
    private int anneeDebut;
    private Long codeUser;
}

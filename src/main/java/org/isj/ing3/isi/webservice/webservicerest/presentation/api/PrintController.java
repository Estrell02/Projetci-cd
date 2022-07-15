package org.isj.ing3.isi.webservice.webservicerest.presentation.api;

import org.isj.ing3.isi.webservice.webservicerest.model.modeletat.*;
import org.isj.ing3.isi.webservice.webservicerest.service.IEtudiant;
import org.isj.ing3.isi.webservice.webservicerest.service.IPrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;

@RestController
@RequestMapping("/api/print")
public class PrintController {
    @Autowired
    private IEtudiant iEtudiant;
    @Autowired
    private IPrintService iPrintService;

    @PostMapping("/generatecarteetudiant")
    public ResponseEntity<?> generateCarteEtudiant(@RequestBody CarteEtudiant carteEtudiant) throws Exception {/*
        try {

        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }*/
        return new ResponseEntity<byte[]>(Files.readAllBytes(iPrintService.generateCarteEtudiant(carteEtudiant).toPath()), HttpStatus.CREATED);
    }

    @PostMapping("/generateatestation")
    public ResponseEntity<?> generateAttestation(@RequestBody AttestationEtDiplome attestation) throws Exception {
        try {
            return new ResponseEntity<byte[]>(iPrintService.generateAttestationReusite(attestation), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CREATED);
        }
    }


    @PostMapping("/generatediplome")
    public ResponseEntity<?> generateDiplome(@RequestBody AttestationEtDiplome diplome) throws Exception {

        try {
            return new ResponseEntity<byte[]>(iPrintService.generateDiplome(diplome), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CREATED);
        }
    }

    @GetMapping("/generateficheabsence")
    public ResponseEntity<?> generateFicheAbsence(@RequestBody FicheAbsence ficheAbsence) throws Exception {
        try {
            return new ResponseEntity<byte[]>(iPrintService.generateFicheAbsences(ficheAbsence), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CREATED);
        }
    }

    @PostMapping("/generatePv")
    public ResponseEntity<?> generatePv(@RequestBody Pv pv) throws Exception {
        try {
            return new ResponseEntity<byte[]>(iPrintService.generatePv(pv), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CREATED);
        }


    }

    @GetMapping("/generateNotes")
    public ResponseEntity<?> generateNotes() throws Exception {
        try {
            return new ResponseEntity<byte[]>(iPrintService.generateNotes(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CREATED);
        }
    }

    @GetMapping("/generateReleve")
    public ResponseEntity<?> generateReleveNotes(@RequestBody ReleveNote releveNote) throws Exception {
        try {
            return new ResponseEntity<byte[]>(iPrintService.generateReleveNote(releveNote), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CREATED);
        }
    }
}

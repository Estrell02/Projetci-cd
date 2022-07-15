package org.isj.ing3.isi.webservice.webservicerest.model.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class SmsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
        assertEquals(toString(), "Sms{} " + super.toString(), " Fonction toString correcte");
    }

    @Test
    void setSignature() {
        assertSame(setSignature(), setSignature(String.valueOf(hashCode())), "Signature correcte");
    }

    @Test
    void testHashCode() {
        assertSame(hashCode(), Objects.hash(super.hashCode()),"Hashcode valide");
    }

    @Test
    char getLibelle() {
        assertEquals(getLibelle(),"sms","Le libelle du message est correcte.");
        return 0;
    }
}
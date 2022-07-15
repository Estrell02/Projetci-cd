package org.isj.ing3.isi.webservice.webservicerest.model.entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import javax.persistence.Column;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @AfterEach
    void tearDown() {
    }

    @Test
    void setSignature() {
        assertSame(setSignature(), setSignature(String.valueOf(hashCode())), "Signature correcte");
    }

    @Test
    void testHashCode() {
        assertEquals(hashCode(),Objects.hash());
        }

    @Test
    public void testToString()   {
        /*assertEquals("Configuration du message incorrecte",toString(),"Message{" + "contenu='" + getContenu() + '\'' + ", destinataire='" + getMessage() + '\'' + ", emetteur='" + getEmetteur() + '\'' + "} ");*/
    assertEquals(toString(),"Message{" +
            "contenu='" + contenu + '\'' +
            ", destinataire='" + destinataire + '\'' +
            ", emetteur='" + emetteur + '\'' +
            "} ","Configuration du message incorrecte");
    }



}
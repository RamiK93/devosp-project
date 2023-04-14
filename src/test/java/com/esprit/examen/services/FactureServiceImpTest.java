package com.esprit.examen.services;

import com.esprit.examen.entities.Facture;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class FactureServiceImpTest {
    @Autowired
    IFactureService iFactureService;


    @Test
    public void testAddFacture() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCreation = dateFormat.parse("30/09/2000");
        Date dateModif = dateFormat.parse("30/10/2000");
        Facture f = new Facture(1234567890L,100.0f, 500.0f, dateCreation, dateModif, false, null, null, null);
        Facture facture = iFactureService.addFacture(f);
        log.info("facture {}", facture);
        assertNotNull(facture.getIdFacture());
        assertNotNull(facture.getDateCreationFacture());
        assertNotNull(facture.getDateDerniereModificationFacture());
        assertNotNull(facture.getArchivee());

    }
    @Test
    public void testDeleteFacture() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCreation = dateFormat.parse("30/09/2000");
        Date dateModif = dateFormat.parse("30/10/2000");
        Facture f = new Facture(1234567890L,100.0f, 500.0f, dateCreation, dateModif, false, null, null, null);
        Facture facture = iFactureService.addFacture(f);
        iFactureService.cancelFacture(facture.getIdFacture());
        assertNotNull(facture.getIdFacture());
        System.out.println(facture.getArchivee());
    }

    @Test
    public void testRetrieveAllFactures() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCreation = dateFormat.parse("30/09/2000");
        Date dateModif = dateFormat.parse("30/10/2000");
        List<Facture> factures = iFactureService.retrieveAllFactures();
        int expected = factures.size();
        Facture f = new Facture(1234567890L,100.0f, 500.0f, dateCreation, dateModif, false, null, null, null);
        iFactureService.addFacture(f);
        assertEquals(expected + 1, iFactureService.retrieveAllFactures().size());

    }
}

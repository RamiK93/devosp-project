/*package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.util.Set;


import com.esprit.examen.entities.DetailFacture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.Facture;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ClientServiceImplTest {
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
		assertNotNull(facture.getMontantFacture());
		assertNotNull(facture.getMontantRemise());
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
	/*@Test
	public void testGetClientsByDateNaissance() throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date startDate = dateFormat.parse("28/09/2000");
		Date endDate = dateFormat.parse("30/09/2005");
		List<Client> clients = clientService.getClientsByDateNaissance(startDate, endDate);
		log.info(" count" + clients.size());
		for (Client client : clients) {
			log.info(" client : " + client.getNom()+ " né le "+client.getDateNaissance());

		}
	}

}*/

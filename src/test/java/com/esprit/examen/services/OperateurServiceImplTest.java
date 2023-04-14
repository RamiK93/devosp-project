package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Operateur;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OperateurServiceImplTest {

    @Autowired
    private IOperateurService operateurService;

    @Test
    public void testAddOperateur() {
        Operateur op = new Operateur(1L,"hamza", "rahali","12345678",null);
        Operateur operateur = operateurService.addOperateur(op);
        assertNotNull(operateur.getIdOperateur());
        assertTrue(operateur.getNom().length() > 0);
        operateurService.deleteOperateur(operateur.getIdOperateur());
    }

    @Test
    public void testDeleteOperateur() {
        Operateur op = new Operateur(2L,"hamza", "rahali","12345678",null);
        Operateur operateur = operateurService.addOperateur(op);
        operateurService.deleteOperateur(operateur.getIdOperateur());
        assertNull(operateurService.retrieveOperateur(operateur.getIdOperateur()));
    }

    @Test
    public void testRetrieveAllOperateurs() {
        List<Operateur> operateurs = operateurService.retrieveAllOperateurs();
        int expected = operateurs.size();
        Operateur op = new Operateur(3L,"hamza", "rahali","12345678",null);
        Operateur operateur = operateurService.addOperateur(op);
        assertEquals(expected + 1, operateurService.retrieveAllOperateurs().size());
        operateurService.deleteOperateur(operateur.getIdOperateur());
    }

    @Test
    public void testUpdateOperateur() {
        Operateur op = new Operateur(4L,"hamza", "rahali","12345678",null);
        Operateur operateur = operateurService.addOperateur(op);
        operateur.setNom("New Telecom");
        operateurService.updateOperateur(operateur);
        assertEquals("New Telecom", operateurService.retrieveOperateur(operateur.getIdOperateur()).getNom());
        operateurService.deleteOperateur(operateur.getIdOperateur());
    }
}
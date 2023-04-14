package com.esprit.examen.services;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.OperateurRepository;
import com.esprit.examen.services.FactureServiceImpl;
import com.esprit.examen.services.OperateurServiceImpl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OperateurServiceMock {

    @Mock
    FactureRepository factureRepository;

    @Mock
    OperateurRepository operateurRepository;

    @InjectMocks
    FactureServiceImpl factureService;

    @InjectMocks
    OperateurServiceImpl operateurService;

    @Test
    void testRetrieveOperateur() {

        Operateur operateur = new Operateur(1L,"Hamza", "Rahali","Hamza123",null);
        operateur.setIdOperateur(1L);
        Mockito.when(operateurRepository.findById(1L)).thenReturn(Optional.of(operateur));
        operateurService.retrieveOperateur(1L);
        Assertions.assertNotNull(operateur);

        System.out.println(operateur);
        System.out.println(" Retrieve is working correctly...!!");

    }


    @Test
     void createOperateurTest() {
        Operateur operateur = new Operateur(3L,"Hamza", "Rahali","Hamza123",null);
        operateur.setIdOperateur(2L);
        operateurService.addOperateur(operateur);
        verify(operateurRepository, times(1)).save(operateur);
        System.out.println(operateur);
        System.out.println(" Create is working correctly...!!");
    }


    @Test
     void getAllOperateurTest() {
        List<Operateur> operateurlist = new ArrayList<Operateur>() {
            {
                add(new Operateur(3L, "azizo", "douraydos","pass123", null));
                add(new Operateur(4L, "azizz", "dridii","pass1234", null));
                add(new Operateur(5L, "azizi", "dridos","pass12345", null));
            }
        };


        when(operateurService.retrieveAllOperateurs()).thenReturn(operateurlist);
        //test
        List<Operateur> operateurList = operateurService.retrieveAllOperateurs();
        assertEquals(3, operateurList.size());
        System.out.println(" Retrieve all is working correctly...!!");

    }
}

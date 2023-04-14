package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import com.esprit.examen.entities.SecteurActivite;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SecteurActiviteServiceImplTest {

    @Autowired
    private SecteurActiviteServiceImpl secteurActiviteService;

    private List<SecteurActivite> secteurActivites = new ArrayList<>();




    @Test
    public void testAddSecteurActivite() {
        SecteurActivite sa = new SecteurActivite(12545585588l,"C3","Libelle 3",null);
        SecteurActivite addedSecteurActivite = secteurActiviteService.addSecteurActivite(sa);
        assertNotNull(addedSecteurActivite);
    }

    @Test
    public void testDeleteSecteurActivite() {
        SecteurActivite sa = secteurActiviteService.addSecteurActivite(secteurActivites.get(0));
        Long id = sa.getIdSecteurActivite();
        secteurActiviteService.deleteSecteurActivite(id);
        SecteurActivite deletedSecteurActivite = secteurActiviteService.retrieveSecteurActivite(id);
        assertEquals(null, deletedSecteurActivite);
    }

    @Test
    public void testUpdateSecteurActivite() {
        SecteurActivite sa = secteurActiviteService.addSecteurActivite(secteurActivites.get(0));
        sa.setLibelleSecteurActivite("Libelle modifié");
        SecteurActivite updatedSecteurActivite = secteurActiviteService.updateSecteurActivite(sa);
        assertEquals("Libelle modifié", updatedSecteurActivite.getLibelleSecteurActivite());
    }

}
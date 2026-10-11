package ma.enset.ikram.tp4;

import ma.enset.ikram.tp4.joined.UtilitaireLogistique;
import ma.enset.ikram.tp4.joined.VehiculeFlotte;
import ma.enset.ikram.tp4.joined.VoitureDirection;
import ma.enset.ikram.tp4.singletable.CompteBancaire;
import ma.enset.ikram.tp4.singletable.CompteCourant;
import ma.enset.ikram.tp4.singletable.CompteEpargne;
import ma.enset.ikram.tp4.tableperclass.ChefDeProjetTech;
import ma.enset.ikram.tp4.tableperclass.DeveloppeurFullstack;
import ma.enset.ikram.tp4.tableperclass.IntervenantProjet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("  TP4 JPA - STRATEGIES D'HERITAGE AVEC HIBERNATE ORM      ");
        System.out.println("               (IKRAM MELLAKH - ENSET)                   ");
        System.out.println("==========================================================");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ikramTP4_PU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            System.out.println("\n[1] STRATEGIE SINGLE_TABLE (Comptes Bancaires)");
            CompteCourant cc = new CompteCourant("RIB-MA-9881-001", 15400.0, "Ikram Mellakh", 5000.0, 25.0);
            CompteEpargne ce = new CompteEpargne("RIB-MA-9881-002", 48200.0, "Ikram Mellakh", 3.75, 100000.0);
            em.persist(cc);
            em.persist(ce);

            System.out.println("\n[2] STRATEGIE JOINED (Vehicules Flotte)");
            VoitureDirection vd = new VoitureDirection("12345-A-1", "Tesla Model 3 Performance", 2024, 5, true);
            UtilitaireLogistique ul = new UtilitaireLogistique("67890-B-1", "Mercedes-Benz Sprinter 317", 2023, 3.5, 14.0);
            em.persist(vd);
            em.persist(ul);

            System.out.println("\n[3] STRATEGIE TABLE_PER_CLASS (Intervenants Projet)");
            DeveloppeurFullstack dev = new DeveloppeurFullstack("DEV-IKRAM", "Ikram Mellakh", 550.0, "Spring Boot, Angular, JPA", 4);
            ChefDeProjetTech cdp = new ChefDeProjetTech("CDP-YASSINE", "Yassine Mansouri", 750.0, "Scrum Master PSM II", 120.0);
            em.persist(dev);
            em.persist(cdp);

            em.getTransaction().commit();
            System.out.println("-> Toutes les entites polymorphiques ont ete persistees avec succes.");

            System.out.println("\n[4] REQUETES POLYMORPHES");
            List<CompteBancaire> comptes = em.createQuery("SELECT c FROM CompteBancaire c", CompteBancaire.class).getResultList();
            System.out.println("-> Total Comptes Bancaires (SINGLE_TABLE) : " + comptes.size());
            for (CompteBancaire c : comptes) {
                System.out.println("   * RIB: " + c.getNumeroRib() + " | Solde: " + c.getSoldeActuel() + " DH | Type: " + c.getClass().getSimpleName());
            }

            List<VehiculeFlotte> vehicules = em.createQuery("SELECT v FROM VehiculeFlotte v", VehiculeFlotte.class).getResultList();
            System.out.println("-> Total Vehicules Flotte (JOINED) : " + vehicules.size());
            for (VehiculeFlotte v : vehicules) {
                System.out.println("   * Immatriculation: " + v.getImmatriculation() + " | Modele: " + v.getMarqueModele());
            }

            List<IntervenantProjet> intervenants = em.createQuery("SELECT i FROM IntervenantProjet i", IntervenantProjet.class).getResultList();
            System.out.println("-> Total Intervenants (TABLE_PER_CLASS) : " + intervenants.size());
            for (IntervenantProjet i : intervenants) {
                System.out.println("   * Intervenant: " + i.getNomPrenom() + " | TJM: " + i.getTarifJournalier() + " EUR");
            }

        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
            emf.close();
            System.out.println("\n==========================================================");
            System.out.println("  EXECUTION DU TP4 TERMINEE AVEC SUCCES (BUILD SUCCESS)");
            System.out.println("==========================================================");
        }
    }
}
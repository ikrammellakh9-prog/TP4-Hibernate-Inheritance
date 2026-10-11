package ma.enset.ikram.tp4.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EPARGNE")
public class CompteEpargne extends CompteBancaire {
    @Column(name = "taux_rendement_annuel")
    private Double tauxRendementAnnuel;

    @Column(name = "plafond_depot")
    private Double plafondDepot;

    public CompteEpargne() {}
    public CompteEpargne(String numeroRib, Double soldeActuel, String titulaire, Double tauxRendementAnnuel, Double plafondDepot) {
        super(numeroRib, soldeActuel, titulaire);
        this.tauxRendementAnnuel = tauxRendementAnnuel;
        this.plafondDepot = plafondDepot;
    }

    public Double getTauxRendementAnnuel() { return tauxRendementAnnuel; }
    public void setTauxRendementAnnuel(Double tauxRendementAnnuel) { this.tauxRendementAnnuel = tauxRendementAnnuel; }
    public Double getPlafondDepot() { return plafondDepot; }
    public void setPlafondDepot(Double plafondDepot) { this.plafondDepot = plafondDepot; }
}
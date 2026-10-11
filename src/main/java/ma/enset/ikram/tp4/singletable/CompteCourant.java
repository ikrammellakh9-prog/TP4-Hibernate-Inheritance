package ma.enset.ikram.tp4.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("COURANT")
public class CompteCourant extends CompteBancaire {
    @Column(name = "decouvert_max_autorise")
    private Double decouvertMaxAutorise;

    @Column(name = "frais_tenue_mensuel")
    private Double fraisTenueMensuel;

    public CompteCourant() {}
    public CompteCourant(String numeroRib, Double soldeActuel, String titulaire, Double decouvertMaxAutorise, Double fraisTenueMensuel) {
        super(numeroRib, soldeActuel, titulaire);
        this.decouvertMaxAutorise = decouvertMaxAutorise;
        this.fraisTenueMensuel = fraisTenueMensuel;
    }

    public Double getDecouvertMaxAutorise() { return decouvertMaxAutorise; }
    public void setDecouvertMaxAutorise(Double decouvertMaxAutorise) { this.decouvertMaxAutorise = decouvertMaxAutorise; }
    public Double getFraisTenueMensuel() { return fraisTenueMensuel; }
    public void setFraisTenueMensuel(Double fraisTenueMensuel) { this.fraisTenueMensuel = fraisTenueMensuel; }
}
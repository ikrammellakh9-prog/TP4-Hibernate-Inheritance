package ma.enset.ikram.tp4.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "utilitaires_logistique_joined")
@PrimaryKeyJoinColumn(name = "vehicule_id")
public class UtilitaireLogistique extends VehiculeFlotte {
    @Column(name = "charge_utile_tonnes")
    private Double chargeUtileTonnes;

    @Column(name = "volume_chargement_m3")
    private Double volumeChargementM3;

    public UtilitaireLogistique() {}
    public UtilitaireLogistique(String immatriculation, String marqueModele, Integer anneeMiseEnService, Double chargeUtileTonnes, Double volumeChargementM3) {
        super(immatriculation, marqueModele, anneeMiseEnService);
        this.chargeUtileTonnes = chargeUtileTonnes;
        this.volumeChargementM3 = volumeChargementM3;
    }

    public Double getChargeUtileTonnes() { return chargeUtileTonnes; }
    public void setChargeUtileTonnes(Double chargeUtileTonnes) { this.chargeUtileTonnes = chargeUtileTonnes; }
    public Double getVolumeChargementM3() { return volumeChargementM3; }
    public void setVolumeChargementM3(Double volumeChargementM3) { this.volumeChargementM3 = volumeChargementM3; }
}
package ma.enset.ikram.tp4.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "voitures_direction_joined")
@PrimaryKeyJoinColumn(name = "vehicule_id")
public class VoitureDirection extends VehiculeFlotte {
    @Column(name = "nb_places_assises")
    private Integer nbPlaces;

    @Column(name = "motorisation_hybride")
    private Boolean motorisationHybride;

    public VoitureDirection() {}
    public VoitureDirection(String immatriculation, String marqueModele, Integer anneeMiseEnService, Integer nbPlaces, Boolean motorisationHybride) {
        super(immatriculation, marqueModele, anneeMiseEnService);
        this.nbPlaces = nbPlaces;
        this.motorisationHybride = motorisationHybride;
    }

    public Integer getNbPlaces() { return nbPlaces; }
    public void setNbPlaces(Integer nbPlaces) { this.nbPlaces = nbPlaces; }
    public Boolean getMotorisationHybride() { return motorisationHybride; }
    public void setMotorisationHybride(Boolean motorisationHybride) { this.motorisationHybride = motorisationHybride; }
}
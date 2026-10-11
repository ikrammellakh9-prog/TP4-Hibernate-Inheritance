package ma.enset.ikram.tp4.joined;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicules_flotte_joined")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class VehiculeFlotte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "immatriculation", nullable = false, unique = true, length = 30)
    private String immatriculation;

    @Column(name = "marque_modele", nullable = false)
    private String marqueModele;

    @Column(name = "annee_mise_service")
    private Integer anneeMiseEnService;

    public VehiculeFlotte() {}
    public VehiculeFlotte(String immatriculation, String marqueModele, Integer anneeMiseEnService) {
        this.immatriculation = immatriculation;
        this.marqueModele = marqueModele;
        this.anneeMiseEnService = anneeMiseEnService;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getImmatriculation() { return immatriculation; }
    public void setImmatriculation(String immatriculation) { this.immatriculation = immatriculation; }
    public String getMarqueModele() { return marqueModele; }
    public void setMarqueModele(String marqueModele) { this.marqueModele = marqueModele; }
    public Integer getAnneeMiseEnService() { return anneeMiseEnService; }
    public void setAnneeMiseEnService(Integer anneeMiseEnService) { this.anneeMiseEnService = anneeMiseEnService; }
}
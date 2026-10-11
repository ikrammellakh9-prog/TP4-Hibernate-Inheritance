package ma.enset.ikram.tp4.singletable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comptes_bancaires_st")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_compte", discriminatorType = DiscriminatorType.STRING, length = 20)
public abstract class CompteBancaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_rib", nullable = false, unique = true, length = 34)
    private String numeroRib;

    @Column(name = "solde_actuel", nullable = false)
    private Double soldeActuel;

    @Column(name = "titulaire_compte", nullable = false)
    private String titulaire;

    public CompteBancaire() {}
    public CompteBancaire(String numeroRib, Double soldeActuel, String titulaire) {
        this.numeroRib = numeroRib;
        this.soldeActuel = soldeActuel;
        this.titulaire = titulaire;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumeroRib() { return numeroRib; }
    public void setNumeroRib(String numeroRib) { this.numeroRib = numeroRib; }
    public Double getSoldeActuel() { return soldeActuel; }
    public void setSoldeActuel(Double soldeActuel) { this.soldeActuel = soldeActuel; }
    public String getTitulaire() { return titulaire; }
    public void setTitulaire(String titulaire) { this.titulaire = titulaire; }
}
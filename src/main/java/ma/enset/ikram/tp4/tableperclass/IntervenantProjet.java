package ma.enset.ikram.tp4.tableperclass;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class IntervenantProjet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "matricule_pro", nullable = false, length = 30)
    private String matriculePro;

    @Column(name = "nom_prenom", nullable = false)
    private String nomPrenom;

    @Column(name = "tarif_journalier")
    private Double tarifJournalier;

    public IntervenantProjet() {}
    public IntervenantProjet(String matriculePro, String nomPrenom, Double tarifJournalier) {
        this.matriculePro = matriculePro;
        this.nomPrenom = nomPrenom;
        this.tarifJournalier = tarifJournalier;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMatriculePro() { return matriculePro; }
    public void setMatriculePro(String matriculePro) { this.matriculePro = matriculePro; }
    public String getNomPrenom() { return nomPrenom; }
    public void setNomPrenom(String nomPrenom) { this.nomPrenom = nomPrenom; }
    public Double getTarifJournalier() { return tarifJournalier; }
    public void setTarifJournalier(Double tarifJournalier) { this.tarifJournalier = tarifJournalier; }
}
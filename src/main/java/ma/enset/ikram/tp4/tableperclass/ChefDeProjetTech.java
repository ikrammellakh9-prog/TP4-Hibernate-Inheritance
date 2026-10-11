package ma.enset.ikram.tp4.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "chefs_projet_tech_tpc")
public class ChefDeProjetTech extends IntervenantProjet {
    @Column(name = "certification_agile")
    private String certificationAgile;

    @Column(name = "budget_gere_keuros")
    private Double budgetGere;

    public ChefDeProjetTech() {}
    public ChefDeProjetTech(String matriculePro, String nomPrenom, Double tarifJournalier, String certificationAgile, Double budgetGere) {
        super(matriculePro, nomPrenom, tarifJournalier);
        this.certificationAgile = certificationAgile;
        this.budgetGere = budgetGere;
    }

    public String getCertificationAgile() { return certificationAgile; }
    public void setCertificationAgile(String certificationAgile) { this.certificationAgile = certificationAgile; }
    public Double getBudgetGere() { return budgetGere; }
    public void setBudgetGere(Double budgetGere) { this.budgetGere = budgetGere; }
}
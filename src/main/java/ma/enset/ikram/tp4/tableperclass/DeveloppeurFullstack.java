package ma.enset.ikram.tp4.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "developpeurs_fullstack_tpc")
public class DeveloppeurFullstack extends IntervenantProjet {
    @Column(name = "frameworks_favoris")
    private String frameworksFavoris;

    @Column(name = "annees_experience")
    private Integer anneesExperience;

    public DeveloppeurFullstack() {}
    public DeveloppeurFullstack(String matriculePro, String nomPrenom, Double tarifJournalier, String frameworksFavoris, Integer anneesExperience) {
        super(matriculePro, nomPrenom, tarifJournalier);
        this.frameworksFavoris = frameworksFavoris;
        this.anneesExperience = anneesExperience;
    }

    public String getFrameworksFavoris() { return frameworksFavoris; }
    public void setFrameworksFavoris(String frameworksFavoris) { this.frameworksFavoris = frameworksFavoris; }
    public Integer getAnneesExperience() { return anneesExperience; }
    public void setAnneesExperience(Integer anneesExperience) { this.anneesExperience = anneesExperience; }
}
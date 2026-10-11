# TP 4 : StratÃ©gies de Mapping de l'HÃ©ritage JPA (Ikram Mellakh)

Mise en Å“uvre comparative des 3 stratÃ©gies majeures d'hÃ©ritage objet-relationnel :
1. **SINGLE_TABLE** : `CompteBancaire`, `CompteCourant`, `CompteEpargne` avec `@DiscriminatorColumn`
2. **JOINED** : `VehiculeFlotte`, `VoitureDirection`, `UtilitaireLogistique` avec jointures SQL
3. **TABLE_PER_CLASS** : `IntervenantProjet`, `DeveloppeurFullstack`, `ChefDeProjetTech`

---

## Captures d'Ã‰cran IntelliJ IDEA & Terminal CMD

### 1. StratÃ©gie SINGLE_TABLE avec @DiscriminatorColumn (IntelliJ IDEA)
![Single Table](docs/images/01-intellij-single-table.png)

### 2. StratÃ©gie JOINED Table (IntelliJ IDEA)
![Joined Table](docs/images/02-intellij-joined-table.png)

### 3. RÃ©sultat des Tests et ExÃ©cution (CMD / PowerShell)
![RÃ©sultat ExÃ©cution CMD](docs/images/03-cmd-test-result.png)

---

## Lancement
```bash
mvn clean compile exec:java -Dexec.mainClass=ma.enset.ikram.tp4.App
```
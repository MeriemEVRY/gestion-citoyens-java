public class ComptePersonnel {

    public String nom;
    public String prenom;
    public String identifiant;
    public String motDePasse;
    public String nomMairie;

    public ComptePersonnel(String nom, String prenom, String identifiant, String motDePasse, String nomMairie) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        this.nomMairie = nomMairie;
    }

    public boolean verifierMotDePasse(String mdp) {
        return motDePasse.equals(mdp);
    }

    public String afficher() {
        return nom + " " + prenom + " - " + identifiant + " - " + nomMairie;
    }
}
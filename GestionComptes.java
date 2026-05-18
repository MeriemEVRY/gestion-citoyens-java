import java.util.*;

public class GestionComptes {

    public Vector<ComptePersonnel> listeComptes = new Vector<>();

    public void ajouterCompte(ComptePersonnel compte) {
        listeComptes.add(compte);
    }

    public ComptePersonnel rechercherCompte(String identifiant, String nomMairie) {
        for (ComptePersonnel c : listeComptes) {
            if (c.identifiant.equals(identifiant) && c.nomMairie.equals(nomMairie)) {
                return c;
            }
        }
        return null;
    }

    public boolean connexionValide(String identifiant, String motDePasse, String nomMairie) {
        ComptePersonnel compte = rechercherCompte(identifiant, nomMairie);

        if (compte == null) {
            return false;
        }

        return compte.verifierMotDePasse(motDePasse);
    }
}
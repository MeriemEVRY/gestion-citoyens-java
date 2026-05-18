
import java.io.*;
import java.util.*;


public class PERSONNE {


    public PERSONNE() {
    }
    public int idPersonne;
    public String nomPersonne;
    public String prenomPersonne;
    public Date dateNaissacePersonne;
    public String etatCivilPersonne;
    public String nationalitePersonne;
    public String lieuPersonne;
    public String addressPersonne;

 public PERSONNE conjoint; 


// 🔹 Méthodes

 public void seMarier(PERSONNE p) {

        if (this != p && this.conjoint == null && p.conjoint == null
                && !"decede".equals(this.etatCivilPersonne)
                && !"decede".equals(p.etatCivilPersonne)) {

            this.conjoint = p;
            p.conjoint = this;

            this.etatCivilPersonne = "marie";
            p.etatCivilPersonne = "marie";

        } else {
            System.out.println("Mariage impossible !");
        }
    }

public void divorcer() {

if (this.conjoint != null) {

PERSONNE ex = this.conjoint;

this.conjoint = null;

ex.conjoint = null;


this.etatCivilPersonne = "divorce";

ex.etatCivilPersonne = "divorce";

}

}

public String afficher() {
    return "ID: " + idPersonne +
            " | Nom: " + nomPersonne +
            " | Prénom: " + prenomPersonne +
            " | Date naissance: " + (dateNaissacePersonne != null ? dateNaissacePersonne : "N/A") +
            " | Etat civil: " + etatCivilPersonne +
            " | Nationalité: " + nationalitePersonne +
            " | Région: " + lieuPersonne +
            " | Adresse: " + addressPersonne;
}

}

import java.io.*;
import java.util.*;


public class NAISSANCE {

    public NAISSANCE() {
    }
    public int idNaissance;
    public Date dateNaissance;
    public String lieuNaissance;
    public double poids;
    public PERSONNE enfant;
    public HOMME pere;
    public FEMME mere;

    public void declarerNaissance() {

        if (enfant != null) {
            enfant.etatCivilPersonne = "celibataire";
        }
    }




}

import java.io.*;
import java.util.*;

public class DECES {

    public DECES() {
    }

    public int idDeces;
    public Date dateDeces;
    public String lieuDeces;
    public String causeDeces;
    
public PERSONNE personne;


 public void declarer() {

        if (personne != null) {
            personne.etatCivilPersonne = "decede";
        }
    }


}
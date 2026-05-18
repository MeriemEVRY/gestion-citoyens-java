
import java.io.*;
import java.util.*;

public class MARIAGE {

    public MARIAGE() {
    }

    public int idMariage;
    public Date dateMariage;
    public String lieuMariage;

public HOMME homme;
 public FEMME femme;

 public PERSONNE temoin1;
 public PERSONNE temoin2;


public void celebrer() {

        if (homme != null && femme != null) {
            homme.seMarier(femme);
        }
    }

}
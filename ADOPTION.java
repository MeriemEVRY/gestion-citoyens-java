
import java.io.*;
import java.util.*;

public class ADOPTION {

    public int idAdoption;
    public Date dateAdoption;
    public String nomTribunal;
    public String typeAdoption;

    public PERSONNE enfant;
   
   public HOMME pereAdoptif;
   public FEMME mereAdoptive;

     public void adopter() {

        if (enfant != null && pereAdoptif != null && mereAdoptive != null) {

            System.out.println(pereAdoptif.nomPersonne + " et " +
                    mereAdoptive.nomPersonne + " adoptent " +
                    enfant.nomPersonne +
                    " (Tribunal: " + nomTribunal + ")");
        }
    }
}
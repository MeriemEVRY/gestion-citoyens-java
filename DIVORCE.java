
import java.io.*;
import java.util.*;

public class DIVORCE {

   
    public DIVORCE() {
    }

    public int idDivorce;
    public Date dateDivorce;
    public String motifDivorce;
    public String tribunalDivorce;

    public HOMME homme;
    public FEMME femme;

    public void prononcer() {

        if (homme != null) {
            homme.divorcer();
        }
    }

}
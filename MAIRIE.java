import java.util.*;

public class MAIRIE {

    public String nomMairie;
    public String adressMairie;
    public String telephoneMairie;
    public String nomMaire;
    public int codePostale;

    public Vector<PERSONNE> ListePersonne = new Vector<>();
    public Vector<MARIAGE> ListeMariage = new Vector<>();
    public Vector<NAISSANCE> ListeNaissance = new Vector<>();
    public Vector<ADOPTION> ListeAdoption = new Vector<>();
    public Vector<DECES> ListeDeces = new Vector<>();
    public Vector<DIVORCE> ListeDivorce = new Vector<>();

    public MAIRIE() {
    }

    public void ajouterPersonne(PERSONNE p) {
        ListePersonne.add(p);
    }

    public void ajouterMariage(MARIAGE m) {
        ListeMariage.add(m);
    }

    public void ajouterNaissance(NAISSANCE n) {
        ListeNaissance.add(n);
    }

    public void ajouterAdoption(ADOPTION a) {
        ListeAdoption.add(a);
    }

    public void ajouterDeces(DECES d) {
        ListeDeces.add(d);
    }

    public void ajouterDivorce(DIVORCE d) {
        ListeDivorce.add(d);
    }

    public PERSONNE rechercher(int id) {
        for (PERSONNE p : ListePersonne) {
            if (p.idPersonne == id) {
                return p;
            }
        }
        return null;
    }

    public HOMME rechercherHomme(int id) {
        PERSONNE p = rechercher(id);

        if (p instanceof HOMME) {
            return (HOMME) p;
        }

        return null;
    }

    public FEMME rechercherFemme(int id) {
        PERSONNE p = rechercher(id);

        if (p instanceof FEMME) {
            return (FEMME) p;
        }

        return null;
    }

    public void marier(int idHomme, int idFemme) {
        HOMME h = rechercherHomme(idHomme);
        FEMME f = rechercherFemme(idFemme);

        if (h != null && f != null) {
            h.seMarier(f);
        } else {
            System.out.println("Mariage impossible : homme ou femme introuvable.");
        }
    }

    public void divorcer(int idHomme) {
        HOMME h = rechercherHomme(idHomme);

        if (h != null) {
            h.divorcer();
        } else {
            System.out.println("Divorce impossible : homme introuvable.");
        }
    }

    public void afficherPersonnes() {
        for (PERSONNE p : ListePersonne) {
            System.out.println(p.afficher());
        }
    }
	
	public boolean identifiantExiste(int id) {

    for (PERSONNE p : ListePersonne) {
        if (p.idPersonne == id) {
            return true;
        }
    }

    return false;
}
      public int nombreCitoyens() {
    return ListePersonne.size();
}

public int nombreMaries() {
    int c = 0;

    for (PERSONNE p : ListePersonne) {
        if ("marie".equalsIgnoreCase(p.etatCivilPersonne)) {
            c++;
        }
    }

    return c;
}

public int nombreDivorces() {
    int c = 0;

    for (PERSONNE p : ListePersonne) {
        if ("divorce".equalsIgnoreCase(p.etatCivilPersonne)) {
            c++;
        }
    }

    return c;
}

public int nombreDecedes() {
    int c = 0;

    for (PERSONNE p : ListePersonne) {
        if ("decede".equalsIgnoreCase(p.etatCivilPersonne)) {
            c++;
        }
    }

    return c;
}

public int nombreCelibataires() {
    int c = 0;

    for (PERSONNE p : ListePersonne) {
        if ("celibataire".equalsIgnoreCase(p.etatCivilPersonne)) {
            c++;
        }
    }

    return c;
}
}
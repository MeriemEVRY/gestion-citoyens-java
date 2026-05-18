import java.awt.event.*;

public class ControleurAfficher implements ActionListener {

    MAIRIE mairie;
    VueAfficher vue;

    public ControleurAfficher(MAIRIE mairie, VueAfficher vue) {
        this.mairie = mairie;
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent e) {
        String choix = vue.filtre.getSelectedItem().toString();
        String valeur = vue.txtRecherche.getText();
        String resultat = "";

        for (PERSONNE p : mairie.ListePersonne) {
            if (choix.equals("Tous")) {
                resultat += p.afficher() + "\n";
            } else if (choix.equals("Mariés") && "marie".equals(p.etatCivilPersonne)) {
                resultat += p.afficher() + "\n";
            } else if (choix.equals("Divorcés") && "divorce".equals(p.etatCivilPersonne)) {
                resultat += p.afficher() + "\n";
            } else if (choix.equals("Décédés") && "decede".equals(p.etatCivilPersonne)) {
                resultat += p.afficher() + "\n";
            } else if (choix.equals("Par région") && p.lieuPersonne.equalsIgnoreCase(valeur)) {
                resultat += p.afficher() + "\n";
            } else if (choix.equals("Par nationalité") && p.nationalitePersonne.equalsIgnoreCase(valeur)) {
                resultat += p.afficher() + "\n";
            } else if (choix.equals("Par date naissance")
                    && p.dateNaissacePersonne != null
                    && p.dateNaissacePersonne.toString().equals(valeur)) {
                resultat += p.afficher() + "\n";
            }
        }

        if (resultat.equals("")) {
            resultat = "Aucun résultat trouvé.";
        }

        vue.zoneAffichage.setText(resultat);
    }
}
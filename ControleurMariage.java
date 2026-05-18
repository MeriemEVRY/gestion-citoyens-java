import java.awt.event.*;
import javax.swing.*;

public class ControleurMariage implements ActionListener {

    MAIRIE mairie;
    VueMariage vue;

    public ControleurMariage(MAIRIE mairie, VueMariage vue) {
        this.mairie = mairie;
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int idHomme = Integer.parseInt(vue.txtIdConjoint1.getText());
            int idFemme = Integer.parseInt(vue.txtIdConjoint2.getText());

            HOMME homme = mairie.rechercherHomme(idHomme);
            FEMME femme = mairie.rechercherFemme(idFemme);

            PERSONNE temoin1 = mairie.rechercher(Integer.parseInt(vue.txtIdTemoin1.getText()));
            PERSONNE temoin2 = mairie.rechercher(Integer.parseInt(vue.txtIdTemoin2.getText()));

            if (homme == null || femme == null) {
                JOptionPane.showMessageDialog(vue, "Homme ou femme introuvable.");
                return;
            }

            if (temoin1 == null || temoin2 == null) {
                JOptionPane.showMessageDialog(vue, "Témoin introuvable.");
                return;
            }

            MARIAGE m = new MARIAGE();

            m.idMariage = Integer.parseInt(vue.txtIdMariage.getText());
            m.dateMariage = java.sql.Date.valueOf(vue.txtDateMariage.getText());
            m.lieuMariage = vue.txtLieuMariage.getText();

            m.homme = homme;
            m.femme = femme;
            m.temoin1 = temoin1;
            m.temoin2 = temoin2;

            m.celebrer();
            mairie.ajouterMariage(m);

            JOptionPane.showMessageDialog(vue, "Mariage déclaré avec succès !");
            vue.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vue, "Erreur : vérifie les champs.");
        }
    }
}
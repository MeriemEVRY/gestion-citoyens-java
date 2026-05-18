import java.awt.event.*;
import javax.swing.*;

public class ControleurDivorce implements ActionListener {

    MAIRIE mairie;
    VueDivorce vue;

    public ControleurDivorce(MAIRIE mairie, VueDivorce vue) {
        this.mairie = mairie;
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int idHomme = Integer.parseInt(vue.txtIdPersonne.getText());

            HOMME homme = mairie.rechercherHomme(idHomme);

            if (homme == null) {
                JOptionPane.showMessageDialog(vue, "Homme introuvable.");
                return;
            }

            if (homme.conjoint == null) {
                JOptionPane.showMessageDialog(vue, "Cette personne n'est pas mariée.");
                return;
            }

            DIVORCE d = new DIVORCE();

            d.idDivorce = Integer.parseInt(vue.txtIdDivorce.getText());
            d.dateDivorce = java.sql.Date.valueOf(vue.txtDateDivorce.getText());
            d.tribunalDivorce = vue.txtTribunalDivorce.getText();
            d.motifDivorce = vue.txtMotifDivorce.getText();

            d.homme = homme;
            d.femme = (FEMME) homme.conjoint;

            d.prononcer();
            mairie.ajouterDivorce(d);

            JOptionPane.showMessageDialog(vue, "Divorce déclaré avec succès !");
            vue.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vue, "Erreur : vérifie les champs.");
        }
    }
}
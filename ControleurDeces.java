import java.awt.event.*;
import javax.swing.*;

public class ControleurDeces implements ActionListener {

    MAIRIE mairie;
    VueDeces vue;

    public ControleurDeces(MAIRIE mairie, VueDeces vue) {
        this.mairie = mairie;
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            PERSONNE p = mairie.rechercher(Integer.parseInt(vue.txtIdPersonne.getText()));

            if (p == null) {
                JOptionPane.showMessageDialog(vue, "Personne introuvable.");
                return;
            }

            DECES d = new DECES();

            d.idDeces = Integer.parseInt(vue.txtIdDeces.getText());
            d.dateDeces = java.sql.Date.valueOf(vue.txtDateDeces.getText());
            d.lieuDeces = vue.txtLieuDeces.getText();
            d.causeDeces = vue.txtCauseDeces.getText();

            d.personne = p;

            d.declarer();
            mairie.ajouterDeces(d);

            JOptionPane.showMessageDialog(vue, "Décès déclaré avec succès !");
            vue.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vue, "Erreur : vérifie les champs.");
        }
    }
}
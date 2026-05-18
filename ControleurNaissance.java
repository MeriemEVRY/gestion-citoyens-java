import java.awt.event.*;
import javax.swing.*;

public class ControleurNaissance implements ActionListener {

    MAIRIE mairie;
    VueNaissance vue;

    public ControleurNaissance(MAIRIE mairie, VueNaissance vue) {
        this.mairie = mairie;
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            PERSONNE enfant = mairie.rechercher(Integer.parseInt(vue.txtIdEnfant.getText()));
            HOMME pere = mairie.rechercherHomme(Integer.parseInt(vue.txtIdPere.getText()));
            FEMME mere = mairie.rechercherFemme(Integer.parseInt(vue.txtIdMere.getText()));

            if (enfant == null || pere == null || mere == null) {
                JOptionPane.showMessageDialog(vue, "Enfant, père ou mère introuvable.");
                return;
            }

            NAISSANCE n = new NAISSANCE();

            n.idNaissance = Integer.parseInt(vue.txtIdNaissance.getText());
            n.dateNaissance = java.sql.Date.valueOf(vue.txtDateNaissance.getText());
            n.lieuNaissance = vue.txtLieuNaissance.getText();
            n.poids = Double.parseDouble(vue.txtPoids.getText());

            n.enfant = enfant;
            n.pere = pere;
            n.mere = mere;

            n.declarerNaissance();
            mairie.ajouterNaissance(n);

            JOptionPane.showMessageDialog(vue, "Naissance déclarée avec succès !");
            vue.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vue, "Erreur : vérifie les champs.");
        }
    }
}
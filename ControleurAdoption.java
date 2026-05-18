import java.awt.event.*;
import javax.swing.*;

public class ControleurAdoption implements ActionListener {

    MAIRIE mairie;
    VueAdoption vue;

    public ControleurAdoption(MAIRIE mairie, VueAdoption vue) {
        this.mairie = mairie;
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            PERSONNE enfant = mairie.rechercher(Integer.parseInt(vue.txtIdEnfant.getText()));
            HOMME pere = mairie.rechercherHomme(Integer.parseInt(vue.txtIdParent1.getText()));
            FEMME mere = mairie.rechercherFemme(Integer.parseInt(vue.txtIdParent2.getText()));

            if (enfant == null || pere == null || mere == null) {
                JOptionPane.showMessageDialog(vue, "Enfant, père adoptif ou mère adoptive introuvable.");
                return;
            }

            ADOPTION a = new ADOPTION();

            a.idAdoption = Integer.parseInt(vue.txtIdAdoption.getText());
            a.dateAdoption = java.sql.Date.valueOf(vue.txtDateAdoption.getText());
            a.nomTribunal = vue.txtNomTribunal.getText();
            a.typeAdoption = vue.txtTypeAdoption.getText();

            a.enfant = enfant;
            a.pereAdoptif = pere;
            a.mereAdoptive = mere;

            a.adopter();
            mairie.ajouterAdoption(a);

            JOptionPane.showMessageDialog(vue, "Adoption déclarée avec succès !");
            vue.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vue, "Erreur : vérifie les champs.");
        }
    }
}
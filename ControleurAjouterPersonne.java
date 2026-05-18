import java.awt.event.*;
import javax.swing.*;

public class ControleurAjouterPersonne implements ActionListener {

    MAIRIE mairie;
    VueAjouterPersonne vue;

    public ControleurAjouterPersonne(MAIRIE mairie, VueAjouterPersonne vue) {
        this.mairie = mairie;
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            PERSONNE p;

            String type = vue.comboSexe
                          .getSelectedItem()
                          .toString();

            if (type.equalsIgnoreCase("homme")) {
                p = new HOMME();
            } else if (type.equalsIgnoreCase("femme")) {
                p = new FEMME();
            } else {
                JOptionPane.showMessageDialog(vue, "Sexe invalide : écris homme ou femme");
                return;
            }

            int id = Integer.parseInt(vue.txtId.getText());
			// 🔹 vérification identifiant unique
               if (mairie.identifiantExiste(id)) {

                   JOptionPane.showMessageDialog(vue, "Identifiant déjà utilisé !");

               return;
               }

               // 🔹 affectation
            p.idPersonne = id;
            p.nomPersonne = vue.txtNom.getText();
            p.prenomPersonne = vue.txtPrenom.getText();
            p.dateNaissacePersonne = java.sql.Date.valueOf(vue.txtDateNaissance.getText());
            p.etatCivilPersonne = vue.comboEtatCivil
                                     .getSelectedItem()
                                     .toString();
            p.nationalitePersonne = vue.txtNationalite.getText();
            p.lieuPersonne = vue.txtRegion.getText();
            p.addressPersonne = vue.txtAdresse.getText();

            mairie.ajouterPersonne(p);

            JOptionPane.showMessageDialog(vue, "Personne ajoutée avec succès !");
            vue.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vue, "Erreur : vérifie les champs.");
        }
    }
}
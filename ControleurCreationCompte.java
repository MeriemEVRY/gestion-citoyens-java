import javax.swing.*;
import java.awt.event.*;

public class ControleurCreationCompte implements ActionListener {

    // 🔹 Vue
    private VueCreationCompte vue;

    // 🔹 Model
    private GestionComptes gestion;

    // 🔹 Constructeur
    public ControleurCreationCompte(VueCreationCompte vue,
                                    GestionComptes gestion) {

        this.vue = vue;
        this.gestion = gestion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // 🔹 Récupération données
        String mairie =
                vue.comboMairie.getSelectedItem().toString();

        String nom =
                vue.txtNom.getText();

        String prenom =
                vue.txtPrenom.getText();

        String identifiant =
                vue.txtIdentifiant.getText();

        String mdp =
                new String(vue.txtMotDePasse.getPassword());

        String confirmation =
                new String(vue.txtConfirmation.getPassword());

        // 🔹 Vérification champs vides
        if (nom.isEmpty() ||
            prenom.isEmpty() ||
            identifiant.isEmpty() ||
            mdp.isEmpty() ||
            confirmation.isEmpty()) {

            JOptionPane.showMessageDialog(
                    vue,
                    "Veuillez remplir tous les champs."
            );

            return;
        }

        // 🔹 Vérification mot de passe
        if (!mdp.equals(confirmation)) {

            JOptionPane.showMessageDialog(
                    vue,
                    "Les mots de passe ne correspondent pas."
            );

            return;
        }

        // 🔹 Vérifier identifiant déjà utilisé
        if (gestion.rechercherCompte(identifiant, mairie) != null) {

            JOptionPane.showMessageDialog(
                    vue,
                    "Identifiant déjà utilisé."
            );

            return;
        }

        // 🔹 Création compte
        ComptePersonnel compte =
                new ComptePersonnel(
                        nom,
                        prenom,
                        identifiant,
                        mdp,
                        mairie
                );

        // 🔹 Ajout
        gestion.ajouterCompte(compte);

        JOptionPane.showMessageDialog(
                vue,
                "Compte créé avec succès !"
        );

        // 🔹 Fermer fenêtre
        vue.dispose();
    }
}
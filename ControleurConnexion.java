import javax.swing.*;
import java.awt.event.*;

public class ControleurConnexion implements ActionListener {

    // 🔹 Vue
    private VueConnexion vue;

    // 🔹 Model
    private GestionComptes gestion;

    // 🔹 Constructeur
    public ControleurConnexion(VueConnexion vue,
                               GestionComptes gestion) {

        this.vue = vue;
        this.gestion = gestion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // 🔹 récupération données
        String mairie =
                vue.comboMairie.getSelectedItem().toString();

        String identifiant =
                vue.txtIdentifiant.getText();

        String mdp =
                new String(vue.txtMotDePasse.getPassword());

        // 🔹 champs vides
        if (identifiant.isEmpty() || mdp.isEmpty()) {

            JOptionPane.showMessageDialog(
                    vue,
                    "Veuillez remplir tous les champs."
            );

            return;
        }

        // 🔹 vérification connexion
        boolean ok =
                gestion.connexionValide(
                        identifiant,
                        mdp,
                        mairie
                );

        if (ok) {

            JOptionPane.showMessageDialog(
                    vue,
                    "Connexion réussie !"
            );

            // 🔹 ouverture menu principal
            MAIRIE m = new MAIRIE();

            new VuePrincipale(m);
            // 🔹 fermer connexion
            vue.dispose();

        } else {

            JOptionPane.showMessageDialog(
                    vue,
                    "Identifiant ou mot de passe incorrect."
            );
        }
    }
}
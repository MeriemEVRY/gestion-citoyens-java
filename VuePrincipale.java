import javax.swing.*;
import java.awt.*;

public class VuePrincipale extends JFrame {

    JButton btnAjouter = new JButton("Saisie des personnes");
    JButton btnMariage = new JButton("Déclarer Mariage");
    JButton btnDivorce = new JButton("Déclarer Divorce");
    JButton btnNaissance = new JButton("Déclarer Naissance");
    JButton btnAdoption = new JButton("Déclarer Adoption");
    JButton btnDeces = new JButton("Déclarer Décès");
	JButton btnStatistiques = new JButton("Statistiques");
    JButton btnAfficher = new JButton("Afficher / Rechercher");
    JButton btnQuitter = new JButton("Quitter");

    public VuePrincipale(MAIRIE mairie) {

        setTitle("Gestion de la Mairie");
        setSize(450, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(9, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        panel.add(btnAjouter);
        panel.add(btnMariage);
        panel.add(btnDivorce);
        panel.add(btnNaissance);
        panel.add(btnAdoption);
        panel.add(btnDeces);
		panel.add(btnStatistiques);
        panel.add(btnAfficher);
        panel.add(btnQuitter);

        add(panel);

        btnAjouter.addActionListener(e -> new VueAjouterPersonne(mairie));
        btnMariage.addActionListener(e -> new VueMariage(mairie));
        btnDivorce.addActionListener(e -> new VueDivorce(mairie));
        btnNaissance.addActionListener(e -> new VueNaissance(mairie));
        btnAdoption.addActionListener(e -> new VueAdoption(mairie));
        btnDeces.addActionListener(e -> new VueDeces(mairie));
        btnAfficher.addActionListener(e -> new VueAfficher(mairie));
        btnQuitter.addActionListener(e -> System.exit(0));
		btnStatistiques.addActionListener(e -> {

        String stats = "";

        stats += "Nombre total citoyens : "
            + mairie.nombreCitoyens() + "\n";

        stats += "Mariés : "
            + mairie.nombreMaries() + "\n";

        stats += "Divorcés : "
            + mairie.nombreDivorces() + "\n";

        stats += "Décédés : "
            + mairie.nombreDecedes() + "\n";

        stats += "Célibataires : "
            + mairie.nombreCelibataires() + "\n";

        JOptionPane.showMessageDialog(
            null,
            stats
        );
       });

        setVisible(true);
    }
}
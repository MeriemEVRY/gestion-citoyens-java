import javax.swing.*;
import java.awt.*;

public class VueAfficher extends JFrame {

    JComboBox<String> filtre = new JComboBox<>(new String[]{
            "Tous",
            "Mariés",
            "Divorcés",
            "Décédés",
            "Par région",
            "Par date naissance",
            "Par nationalité"
    });

    JTextField txtRecherche = new JTextField();

    JTextArea zoneAffichage = new JTextArea();

    JButton btnAfficher = new JButton("Afficher");
    JButton btnRetour = new JButton("Fermer");

    public VueAfficher(MAIRIE mairie) {

        setTitle("Afficher / Rechercher");
        setSize(650, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel haut = new JPanel(new GridLayout(2, 2, 8, 8));

        haut.add(new JLabel("Filtre :"));
        haut.add(filtre);
        haut.add(new JLabel("Valeur recherche :"));
        haut.add(txtRecherche);

        JPanel bas = new JPanel();
        bas.add(btnAfficher);
        bas.add(btnRetour);

        zoneAffichage.setEditable(false);

        add(haut, BorderLayout.NORTH);
        add(new JScrollPane(zoneAffichage), BorderLayout.CENTER);
        add(bas, BorderLayout.SOUTH);

        btnRetour.addActionListener(e -> dispose());

        btnAfficher.addActionListener(new ControleurAfficher(mairie, this));

        setVisible(true);
    }
}
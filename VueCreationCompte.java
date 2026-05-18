import javax.swing.*;
import java.awt.*;

public class VueCreationCompte extends JFrame {

    // 🔹 Composants
    public JComboBox<String> comboMairie;

    public JTextField txtNom;
    public JTextField txtPrenom;
    public JTextField txtIdentifiant;

    public JPasswordField txtMotDePasse;
    public JPasswordField txtConfirmation;

    public JButton btnCreerCompte;

    // 🔹 Constructeur
    public VueCreationCompte(GestionComptes gestion) {

        setTitle("Création Compte Personnel");

        setSize(550, 450);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        // 🔹 Titre
        JLabel titre = new JLabel("Créer un Compte", SwingConstants.CENTER);

        titre.setFont(new Font("Arial", Font.BOLD, 24));

        add(titre, BorderLayout.NORTH);

        // 🔹 Panel centre
        JPanel panelCentre = new JPanel();

        panelCentre.setLayout(new GridLayout(7, 2, 10, 10));

        panelCentre.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 🔹 Mairie
        panelCentre.add(new JLabel("Mairie :"));

        comboMairie = new JComboBox<>();

        comboMairie.addItem("Mairie Paris");
        comboMairie.addItem("Mairie Lyon");
        comboMairie.addItem("Mairie Marseille");

        panelCentre.add(comboMairie);

        // 🔹 Nom
        panelCentre.add(new JLabel("Nom :"));

        txtNom = new JTextField();

        panelCentre.add(txtNom);

        // 🔹 Prenom
        panelCentre.add(new JLabel("Prénom :"));

        txtPrenom = new JTextField();

        panelCentre.add(txtPrenom);

        // 🔹 Identifiant
        panelCentre.add(new JLabel("Identifiant :"));

        txtIdentifiant = new JTextField();

        panelCentre.add(txtIdentifiant);

        // 🔹 Mot de passe
        panelCentre.add(new JLabel("Mot de passe :"));

        txtMotDePasse = new JPasswordField();

        panelCentre.add(txtMotDePasse);

        // 🔹 Confirmation
        panelCentre.add(new JLabel("Confirmation :"));

        txtConfirmation = new JPasswordField();

        panelCentre.add(txtConfirmation);

        // 🔹 Bouton
        btnCreerCompte = new JButton("Créer le compte");

        panelCentre.add(btnCreerCompte);

        add(panelCentre, BorderLayout.CENTER);
		// 🔹 Controleur
        btnCreerCompte.addActionListener(
        new ControleurCreationCompte(this, gestion)
       );

        setVisible(true);
    }
}
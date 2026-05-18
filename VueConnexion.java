import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VueConnexion extends JFrame {

    // 🔹 Composants
    public JComboBox<String> comboMairie;

    public JTextField txtIdentifiant;

    public JPasswordField txtMotDePasse;

    public JButton btnConnexion;
    public JButton btnCreerCompte;
    public JButton btnMotDePasseOublie;
	private GestionComptes gestion;

    // 🔹 Constructeur
    public VueConnexion(GestionComptes gestion) {
		
          this.gestion = gestion;
		  
        setTitle("Connexion Personnel Mairie");

        setSize(500, 350);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // 🔹 Titre
        JLabel titre = new JLabel("Connexion Personnel", SwingConstants.CENTER);

        titre.setFont(new Font("Arial", Font.BOLD, 22));

        add(titre, BorderLayout.NORTH);

        // 🔹 Panel centre
        JPanel panelCentre = new JPanel();

        panelCentre.setLayout(new GridLayout(6, 2, 10, 10));

        panelCentre.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 🔹 Mairie
        panelCentre.add(new JLabel("Mairie :"));

        comboMairie = new JComboBox<>();

        comboMairie.addItem("Mairie Paris");
        comboMairie.addItem("Mairie Lyon");
        comboMairie.addItem("Mairie Marseille");

        panelCentre.add(comboMairie);

        // 🔹 Identifiant
        panelCentre.add(new JLabel("Identifiant :"));

        txtIdentifiant = new JTextField();

        panelCentre.add(txtIdentifiant);

        // 🔹 Mot de passe
        panelCentre.add(new JLabel("Mot de passe :"));

        txtMotDePasse = new JPasswordField();

        panelCentre.add(txtMotDePasse);

        // 🔹 Boutons
        btnConnexion = new JButton("Connexion");

        btnCreerCompte = new JButton("Créer un compte");

        btnMotDePasseOublie = new JButton("Mot de passe oublié");

        panelCentre.add(btnConnexion);

        panelCentre.add(btnCreerCompte);

        panelCentre.add(btnMotDePasseOublie);

        add(panelCentre, BorderLayout.CENTER);
		
		btnConnexion.addActionListener(
        new ControleurConnexion(this, gestion)
        );
		
		// 🔹 ouvrir création compte
       btnCreerCompte.addActionListener(new ActionListener() {

       @Override
       public void actionPerformed(ActionEvent e) {

        new VueCreationCompte(gestion);
    }
	
   });

        setVisible(true);
    }
}
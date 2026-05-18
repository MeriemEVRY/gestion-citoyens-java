import javax.swing.*;
import java.awt.*;

public class VueAjouterPersonne extends JFrame {

    JTextField txtId = new JTextField();
    JTextField txtNom = new JTextField();
    JTextField txtPrenom = new JTextField();
    JTextField txtDateNaissance = new JTextField();
	JComboBox<String> comboSexe;
    JComboBox<String> comboEtatCivil; 
    JTextField txtNationalite = new JTextField();
    JTextField txtRegion = new JTextField();
    JTextField txtAdresse = new JTextField();

    JButton btnValider = new JButton("Ajouter");
    JButton btnRetour = new JButton("Fermer");

    public VueAjouterPersonne(MAIRIE mairie) {

        setTitle("Saisie des personnes");
        setSize(450, 500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10, 2, 8, 8));
		
		comboSexe = new JComboBox<>();
        comboSexe.addItem("Homme");
        comboSexe.addItem("Femme");

        comboEtatCivil = new JComboBox<>();
        comboEtatCivil.addItem("celibataire");
        comboEtatCivil.addItem("marie");
        comboEtatCivil.addItem("divorce");
        comboEtatCivil.addItem("veuf");
        comboEtatCivil.addItem("decede");

        add(new JLabel("ID :")); add(txtId);
        add(new JLabel("Nom :")); add(txtNom);
        add(new JLabel("Prénom :")); add(txtPrenom);
        add(new JLabel("Date naissance YYYY-MM-DD :")); add(txtDateNaissance);
        add(new JLabel("Sexe :")); add(comboSexe);
        add(new JLabel("État civil :")); add(comboEtatCivil);
        add(new JLabel("Nationalité :")); add(txtNationalite);
        add(new JLabel("Région :")); add(txtRegion);
        add(new JLabel("Adresse :")); add(txtAdresse);

        add(btnValider);
        add(btnRetour);

        btnRetour.addActionListener(e -> dispose());
        
        btnValider.addActionListener(new ControleurAjouterPersonne(mairie, this));


        setVisible(true);
    }
}
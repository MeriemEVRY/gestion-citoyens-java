import javax.swing.*;
import java.awt.*;

public class VueNaissance extends JFrame {

    JTextField txtIdNaissance = new JTextField();
    JTextField txtDateNaissance = new JTextField();
    JTextField txtLieuNaissance = new JTextField();
    JTextField txtPoids = new JTextField();

    JTextField txtIdEnfant = new JTextField();
    JTextField txtIdPere = new JTextField();
    JTextField txtIdMere = new JTextField();

    JButton btnValider = new JButton("Déclarer naissance");
    JButton btnRetour = new JButton("Fermer");

    public VueNaissance(MAIRIE mairie) {

        setTitle("Déclarer Naissance");
        setSize(450, 430);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 8, 8));

        add(new JLabel("ID Naissance :")); add(txtIdNaissance);
        add(new JLabel("Date naissance YYYY-MM-DD :")); add(txtDateNaissance);
        add(new JLabel("Lieu naissance :")); add(txtLieuNaissance);
        add(new JLabel("Poids :")); add(txtPoids);

        add(new JLabel("ID Enfant :")); add(txtIdEnfant);
        add(new JLabel("ID Père :")); add(txtIdPere);
        add(new JLabel("ID Mère :")); add(txtIdMere);

        add(btnValider);
        add(btnRetour);

        btnRetour.addActionListener(e -> dispose());

        btnValider.addActionListener(new ControleurNaissance(mairie, this));

        setVisible(true);
    }
}
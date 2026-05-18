import javax.swing.*;
import java.awt.*;

public class VueDeces extends JFrame {

    JTextField txtIdDeces = new JTextField();
    JTextField txtDateDeces = new JTextField();
    JTextField txtLieuDeces = new JTextField();
    JTextField txtCauseDeces = new JTextField();

    JTextField txtIdPersonne = new JTextField();

    JButton btnValider = new JButton("Déclarer décès");
    JButton btnRetour = new JButton("Fermer");

    public VueDeces(MAIRIE mairie) {

        setTitle("Déclarer Décès");
        setSize(430, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 8, 8));

        add(new JLabel("ID Décès :")); add(txtIdDeces);
        add(new JLabel("Date décès YYYY-MM-DD :")); add(txtDateDeces);
        add(new JLabel("Lieu décès :")); add(txtLieuDeces);
        add(new JLabel("Cause décès :")); add(txtCauseDeces);
        add(new JLabel("ID Personne décédée :")); add(txtIdPersonne);

        add(btnValider);
        add(btnRetour);

        btnRetour.addActionListener(e -> dispose());

        btnValider.addActionListener(new ControleurDeces(mairie, this));

        setVisible(true);
    }
}
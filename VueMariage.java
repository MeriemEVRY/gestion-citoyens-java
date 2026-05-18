import javax.swing.*;
import java.awt.*;

public class VueMariage extends JFrame {

    JTextField txtIdMariage = new JTextField();
    JTextField txtDateMariage = new JTextField();
    JTextField txtLieuMariage = new JTextField();

    JTextField txtIdConjoint1 = new JTextField();
    JTextField txtIdConjoint2 = new JTextField();

    JTextField txtIdTemoin1 = new JTextField();
    JTextField txtIdTemoin2 = new JTextField();

    JButton btnValider = new JButton("Déclarer mariage");
    JButton btnRetour = new JButton("Fermer");

    public VueMariage(MAIRIE mairie) {

        setTitle("Déclarer Mariage");
        setSize(450, 430);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 8, 8));

        add(new JLabel("ID Mariage :")); add(txtIdMariage);
        add(new JLabel("Date mariage YYYY-MM-DD :")); add(txtDateMariage);
        add(new JLabel("Lieu mariage :")); add(txtLieuMariage);

        add(new JLabel("ID Conjoint 1 :")); add(txtIdConjoint1);
        add(new JLabel("ID Conjoint 2 :")); add(txtIdConjoint2);

        add(new JLabel("ID Témoin 1 :")); add(txtIdTemoin1);
        add(new JLabel("ID Témoin 2 :")); add(txtIdTemoin2);

        add(btnValider);
        add(btnRetour);

        btnRetour.addActionListener(e -> dispose());

        btnValider.addActionListener(new ControleurMariage(mairie, this));

        setVisible(true);
    }
}
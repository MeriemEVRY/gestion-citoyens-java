import javax.swing.*;
import java.awt.*;

public class VueDivorce extends JFrame {

    JTextField txtIdDivorce = new JTextField();
    JTextField txtDateDivorce = new JTextField();
    JTextField txtTribunalDivorce = new JTextField();
    JTextField txtMotifDivorce = new JTextField();

    JTextField txtIdPersonne = new JTextField();

    JButton btnValider = new JButton("Déclarer divorce");
    JButton btnRetour = new JButton("Fermer");

    public VueDivorce(MAIRIE mairie) {

        setTitle("Déclarer Divorce");
        setSize(430, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 8, 8));

        add(new JLabel("ID Divorce :")); add(txtIdDivorce);
        add(new JLabel("Date divorce YYYY-MM-DD :")); add(txtDateDivorce);
        add(new JLabel("Tribunal divorce :")); add(txtTribunalDivorce);
        add(new JLabel("Motif divorce :")); add(txtMotifDivorce);
        add(new JLabel("ID Personne :")); add(txtIdPersonne);

        add(btnValider);
        add(btnRetour);

        btnRetour.addActionListener(e -> dispose());

        btnValider.addActionListener(new ControleurDivorce(mairie, this));

        setVisible(true);
    }
}
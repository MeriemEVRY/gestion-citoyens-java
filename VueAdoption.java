import javax.swing.*;
import java.awt.*;

public class VueAdoption extends JFrame {

    JTextField txtIdAdoption = new JTextField();
    JTextField txtDateAdoption = new JTextField();
    JTextField txtNomTribunal = new JTextField();
    JTextField txtTypeAdoption = new JTextField();

    JTextField txtIdEnfant = new JTextField();
    JTextField txtIdParent1 = new JTextField();
    JTextField txtIdParent2 = new JTextField();

    JButton btnValider = new JButton("Déclarer adoption");
    JButton btnRetour = new JButton("Fermer");

    public VueAdoption(MAIRIE mairie) {

        setTitle("Déclarer Adoption");
        setSize(450, 430);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 8, 8));

        add(new JLabel("ID Adoption :")); add(txtIdAdoption);
        add(new JLabel("Date adoption YYYY-MM-DD :")); add(txtDateAdoption);
        add(new JLabel("Nom tribunal :")); add(txtNomTribunal);
        add(new JLabel("Type adoption :")); add(txtTypeAdoption);

        add(new JLabel("ID Enfant :")); add(txtIdEnfant);
        add(new JLabel("ID Parent 1 :")); add(txtIdParent1);
        add(new JLabel("ID Parent 2 :")); add(txtIdParent2);

        add(btnValider);
        add(btnRetour);

        btnRetour.addActionListener(e -> dispose());

        btnValider.addActionListener(new ControleurAdoption(mairie, this));

        setVisible(true);
    }
}
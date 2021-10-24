import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Am creat o fereastra in care o persoana isi poate introduce datele si crea un profil in cadrul unei banci
public class Form {
    private JLabel lblText;
    private JPanel rootPanel;
    private JLabel lblText1;
    private JButton creatiProfilNouButton;
    private JButton btnEliminare;
    public Form() {
        //aici am Creat variabila frame2 si am apelat constructorii din Form2
        creatiProfilNouButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2=new JFrame("Introduceti data client nou");
                frame2.setContentPane(new Form2().rootPanel2);
                frame2.pack();
                frame2.setSize(800,600);
                frame2.setVisible(true);
                JFrame frame3=new JFrame("Introduceti data client nou");
                frame3.setContentPane(new Form2(frame2,frame3).Panel2);
                frame3.pack();
                frame3.setVisible(true);
            }
        });
    }
    //Prima fereastra afiseaza doar un text si un buton pe care daca il apasam,se va deschide alta fereastra
    public static void main(String[] args) {
        JFrame frame=new JFrame("Banca");
        frame.setContentPane(new Form().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(200,150);
        frame.setVisible(true);
    }
}

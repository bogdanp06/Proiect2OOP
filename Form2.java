import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Form2{
    public JPanel rootPanel2;
    private JLabel lblDateClient;
    private JLabel lblNume;
    private JLabel lblPrenume;
    private JLabel lblCNP;
    private JLabel lblSuma;
    private JTextField txtNume;
    private JTextField txtPrenume;
    private JTextField txtCNP;
    public JTextField txtBani;
    public JButton btnCreare;
    private JLabel lblAfisareDate;
    private JLabel lblAdaugare;
    private JTextField txtSumaAdaugata;
    private JLabel lblRetragere;
    private JTextField txtRetragere;
    private JButton btnAdaugare;
    private JButton btnRetragere;
    private JLabel AfisareSumaNoua;
    private JButton btnInterogare;
    private JButton btnSterge;
    private JLabel lblInterogare;
    private JLabel lblSterge;
    private JButton btnInchhidere;
    public JPanel Panel2;
    protected final int sumaMinima=50;
    protected int j;
    protected final int lungimeCNP=13;
    //In constructorul form2() am realizat mai multe evenimente
    public Form2() {
        lblAdaugare.setVisible(false);lblRetragere.setVisible(false);txtSumaAdaugata.setVisible(false);txtRetragere.setVisible(false);
        btnAdaugare.setVisible(false);btnRetragere.setVisible(false);lblAfisareDate.setVisible(false);btnInterogare.setVisible(false);
        btnSterge.setVisible(false);lblSterge.setVisible(false);lblInterogare.setVisible(false);btnInchhidere.setVisible(false);
        ArrayList<String> date = new ArrayList<String>();
        //Daca butonul "Creati profil nou" este apasat, atunci datele vor fi stocate intr-un ArrayList si vor fi afisate cu metoda toString() pe ecran
        btnCreare.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnCreare.setBackground(Color.gray);
                    lblAfisareDate.setVisible(true);
                    String s = txtCNP.getText();
                    j = Integer.parseInt(txtBani.getText());
                    date.add(txtNume.getText());
                    date.add(txtPrenume.getText());
                    date.add(txtCNP.getText());
                    date.add(txtBani.getText());
                    if (((int) (txtNume.getText().charAt(0)) > 65)
                            && ((int) txtNume.getText().charAt(0) < 90)
                            && ((int) (txtPrenume.getText().charAt(0)) > 65)
                            && ((int) txtPrenume.getText().charAt(0) < 90)
                            && (s.length() == lungimeCNP)
                            && (j > sumaMinima)) {
                        lblAfisareDate.setText(toString());
                        lblAdaugare.setVisible(true);
                        lblRetragere.setVisible(true);
                        txtSumaAdaugata.setVisible(true);
                        txtRetragere.setVisible(true);
                        btnAdaugare.setVisible(true);
                        btnRetragere.setVisible(true);
                        btnInterogare.setVisible(true);
                        btnSterge.setVisible(true);
                        lblSterge.setVisible(true);
                        lblInterogare.setVisible(true);
                        btnInchhidere.setVisible(false);


                        //Aici daca apasam butonul "Adaugare" la suma de bani curenta, se va adauga inca o suma si se va tiparui pe ecran soldul final
                        btnAdaugare.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String str = txtSumaAdaugata.getText().toString();
                                int i = Integer.parseInt(str);
                                int j = Integer.parseInt(txtBani.getText());
                                txtSumaAdaugata.setText(String.valueOf(getSuma(i, j)));
                                txtBani.setText(String.valueOf(i + j));
                                AfisareSumaNoua.setText(txtSumaAdaugata.getText() + " de lei se afla in cont");
                            }
                        });

                    //Prin apasarea butonului "Retragere" se va introduce o suma de bani si daca aceasta indeplineste conditia,se va retrage din soldul curent
                    btnRetragere.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           String str=txtRetragere.getText().toString();
                           int i=Integer.parseInt(str);
                           int j = Integer.parseInt(txtBani.getText());
                           if(j>=i) {
                           int g=j-i;
                           AfisareSumaNoua.setText(String.valueOf(g)+" de lei se afla in cont");
                           txtBani.setText(String.valueOf(g));
                           }
                           else AfisareSumaNoua.setText("Nu se poate realiza aceasta actiune");
                        }
                    });

                //Daca apasam acest buton, vor aparea pe ecran datele contului persoanei respective.
                btnInterogare.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                lblInterogare.setText("Nume:"+date.get(0)+",   Prenume:"+date.get(1)+",  CNP:"+date.get(2)+",   Suma depusa:"+date.get(3));
                                lblSterge.setText("");
                            }
                            catch(Exception d) {
                                lblInterogare.setText("Introduceti noile date ale contului!");
                                lblSterge.setText("");
                            }


                        }
                    });

                //Daca dorim sa stergem datele si sa cream un profil nou,putem face acest lucru prin apasarea butonului "Sterge"
                btnSterge.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            date.clear();
                            lblSterge.setText("Datele contului au fost sterse!");
                        }
                    });
                    }
                    else lblAfisareDate.setText("Date incorecte");
                }

                //Functia toString() afiseaza datele clientului,atunci cand este apelata. Pentru a o realiza am apelat la o variabila de tip StringBuffer
                public String toString() {
                    StringBuffer sb = new StringBuffer();
                    sb.append("Nume " + txtNume.getText());
                    sb.append(" Prenume " + txtPrenume.getText());
                    sb.append(" CNP: " + txtCNP.getText());
                    sb.append(" Suma depusa: " + txtBani.getText());
                    return sb.toString();
                }
            });

    }
    public int getSuma(int i,int j)
    {
        return i+j;
    }
    //In constructorul 2 am creat un eveniment pentru un Buton care inchide ferestrele daca este apasat
    public Form2(JFrame frame,JFrame frame2)
    {
        btnInchhidere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                frame2.dispose();
            }
        });
    }
}


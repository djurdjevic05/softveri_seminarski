/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.usluga;

import domen.Administrator;
import domen.Clan;
import domen.StatusUsluge;
import domen.Usluga;
import domen.VrstaUsluge;
import forme.FGlavna;
import forme.FormMode;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import kontroler.Kontroler;
import transfer.ServerskiOdgovor;
import validacija.FormValidator;

/**
 *
 * @author USER
 */
public class FUsluga extends javax.swing.JDialog {

    private Border defaultBorderTxtField;
    private Border defaultBorderTxtArea;

    /**
     * Creates new form FUsluga
     */
    private FUsluga(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        podesiFormu();

    }

    public FUsluga(FGlavna parent, boolean modal, FormMode rezim) {
        this(parent, modal);
        prilagodiFormu(rezim);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCurrentUser = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblNazivUsluge = new javax.swing.JLabel();
        txtNazivUsluge = new javax.swing.JTextField();
        lblOpisUsluge = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOpisUsluge = new javax.swing.JTextArea();
        lblVrstaUsluge = new javax.swing.JLabel();
        lblUslugaID = new javax.swing.JLabel();
        txtUslugaID = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        cmbStatusUsluge = new javax.swing.JComboBox();
        cmbVrstaUsluge = new javax.swing.JComboBox();
        btnIzaberi = new javax.swing.JButton();
        btnPonisti = new javax.swing.JButton();
        btnAzuriraj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Trenutni korisnik:");

        txtCurrentUser.setEditable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Usluga"));

        lblNazivUsluge.setText("Naziv usluge: ");

        lblOpisUsluge.setText("Opis usluge: ");

        txtOpisUsluge.setColumns(20);
        txtOpisUsluge.setRows(5);
        jScrollPane1.setViewportView(txtOpisUsluge);

        lblVrstaUsluge.setText("Vrsta usluge: ");

        lblUslugaID.setText("ID: ");

        txtUslugaID.setEnabled(false);

        lblStatus.setText("Status:");

        cmbStatusUsluge.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbVrstaUsluge.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnIzaberi.setText("Izaberi");
        btnIzaberi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzaberiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNazivUsluge)
                                    .addComponent(lblOpisUsluge)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lblUslugaID)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNazivUsluge)
                            .addComponent(txtUslugaID)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbStatusUsluge, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVrstaUsluge)
                .addGap(18, 18, 18)
                .addComponent(cmbVrstaUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIzaberi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUslugaID)
                    .addComponent(txtUslugaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNazivUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNazivUsluge))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblOpisUsluge))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVrstaUsluge)
                    .addComponent(cmbVrstaUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIzaberi))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(cmbStatusUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCurrentUser, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCurrentUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnPonisti.setText("Ponisti");
        btnPonisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonistiActionPerformed(evt);
            }
        });

        btnAzuriraj.setText("Azuriraj");
        btnAzuriraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzurirajActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPonisti)
                .addGap(8, 8, 8)
                .addComponent(btnAzuriraj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIzmeni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSacuvaj)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnIzmeni)
                    .addComponent(btnPonisti)
                    .addComponent(btnAzuriraj))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPonistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonistiActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnPonistiActionPerformed

    private void btnAzurirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzurirajActionPerformed
        postaviBorder();
        boolean validniComboBox = FormValidator.getInstance().validateComboSelection(cmbStatusUsluge, cmbVrstaUsluge);
        boolean validnaTextPolja = FormValidator.getInstance().validateEmpty(txtNazivUsluge, txtOpisUsluge);
        if (!validnaTextPolja || !validniComboBox) {
            JOptionPane.showMessageDialog(this, FormValidator.getInstance().getValidationMessage());
            return;
        }
        int id = Integer.parseInt(txtUslugaID.getText());
        String nazivUsluge = txtNazivUsluge.getText();
        String opisUsluge = txtOpisUsluge.getText();
        VrstaUsluge vrsta = (VrstaUsluge) cmbVrstaUsluge.getSelectedItem();
        StatusUsluge status = (StatusUsluge) cmbStatusUsluge.getSelectedItem();

        Usluga u = new Usluga(id, nazivUsluge, opisUsluge, status, vrsta);
        ServerskiOdgovor so = Kontroler.getInstance().izmeniUslugu(u);
        if(!so.isUspesno()){
            JOptionPane.showMessageDialog(this, so.getPoruka(),"Greska",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(this, so.getPoruka(), "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
        dispose();

    }//GEN-LAST:event_btnAzurirajActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        postaviBorder();
        boolean validnaTextPolja = FormValidator.getInstance().validateEmpty(txtNazivUsluge, txtOpisUsluge);
        boolean validniComboBox = FormValidator.getInstance().validateComboSelection(cmbStatusUsluge, cmbVrstaUsluge);
        if (!validnaTextPolja || !validniComboBox) {
            JOptionPane.showMessageDialog(this, FormValidator.getInstance().getValidationMessage());
            return;
        }
        String nazivUsluge = txtNazivUsluge.getText();
        String opisUsluge = txtOpisUsluge.getText();
        VrstaUsluge vrsta = (VrstaUsluge) cmbVrstaUsluge.getSelectedItem();
        StatusUsluge status = (StatusUsluge) cmbStatusUsluge.getSelectedItem();

        ServerskiOdgovor so = Kontroler.getInstance().unesiUslugu(new Usluga(nazivUsluge, opisUsluge, status, vrsta));
        if(!so.isUspesno()){
            JOptionPane.showMessageDialog(this, so.getPoruka(),"Greska",JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, so.getPoruka(), "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
        int result = JOptionPane.showConfirmDialog(this, "Nova usluga", "Pitanje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            prikazUsluge(new Usluga());
            ukloniOsluskivaceZaNovUnos();
        } else {
            dispose();
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        prilagodiFormu(FormMode.EDIT);
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnIzaberiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzaberiActionPerformed
        new FSelektovanjeVrstaUsluge(null, true).setVisible(true);
        VrstaUsluge vu = (VrstaUsluge) Kontroler.getInstance().getMapa().get("izabrana_vrsta");
        cmbVrstaUsluge.setSelectedItem(vu);
    }//GEN-LAST:event_btnIzaberiActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAzuriraj;
    private javax.swing.JButton btnIzaberi;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnPonisti;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbStatusUsluge;
    private javax.swing.JComboBox cmbVrstaUsluge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNazivUsluge;
    private javax.swing.JLabel lblOpisUsluge;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUslugaID;
    private javax.swing.JLabel lblVrstaUsluge;
    private javax.swing.JTextField txtCurrentUser;
    private javax.swing.JTextField txtNazivUsluge;
    private javax.swing.JTextArea txtOpisUsluge;
    private javax.swing.JTextField txtUslugaID;
    // End of variables declaration//GEN-END:variables

    private void podesiFormu() {
        setLocationRelativeTo(null);
        Administrator a = (Administrator) Kontroler.getInstance().getMapa().get("admin");
        txtCurrentUser.setText(a.toString());
        popuniKomboVrsta();
        popuniKomboStatus();
        podesiIndekseKomboa();
        defaultBorderTxtField = txtNazivUsluge.getBorder();
        defaultBorderTxtArea = txtOpisUsluge.getBorder();
        FormValidator.getInstance().setDefaultBorder(defaultBorderTxtArea);
    }

    private void prilagodiFormu(FormMode rezim) {
        switch (rezim) {
            case NEW:
                setTitle("Nova usluga");
                lblUslugaID.setVisible(false);
                txtUslugaID.setVisible(false);
                btnAzuriraj.setVisible(false);
                btnIzmeni.setVisible(false);
                btnIzaberi.setVisible(true);

                break;

            case EDIT:
                setTitle("Izmena usluge");
                lblUslugaID.setVisible(true);
                txtUslugaID.setVisible(true);
                btnIzmeni.setVisible(false);
                btnAzuriraj.setVisible(true);
                btnSacuvaj.setVisible(false);

                txtNazivUsluge.setEditable(true);
                txtOpisUsluge.setEditable(true);
                cmbVrstaUsluge.setEnabled(true);
                cmbStatusUsluge.setEnabled(true);
                btnIzaberi.setVisible(true);
                this.pack();

                break;

            case VIEW:
                setTitle("Prikaz usluge");
                lblUslugaID.setVisible(true);
                txtUslugaID.setVisible(true);
                btnIzmeni.setVisible(true);
                btnAzuriraj.setVisible(false);
                btnSacuvaj.setVisible(false);

                txtNazivUsluge.setEditable(false);
                txtOpisUsluge.setEditable(false);
                cmbVrstaUsluge.setEnabled(false);
                cmbStatusUsluge.setEnabled(false);
                btnIzaberi.setVisible(false);
                postaviUslugu();
                this.pack();
                break;
        }
    }

    private void popuniKomboVrsta() {
        List<VrstaUsluge> lista = Kontroler.getInstance().vratiVrsteUsluga();
        cmbVrstaUsluge.setModel(new DefaultComboBoxModel(lista.toArray()));

    }

    private void postaviUslugu() {
        Usluga u = (Usluga) Kontroler.getInstance().getMapa().get("izabrana_usluga");
        prikazUsluge(u);
    }

    private void prikazUsluge(Usluga u) {
        txtUslugaID.setText(String.valueOf(u.getUslugaID()));
        txtNazivUsluge.setText(u.getNaziv());
        txtOpisUsluge.setText(u.getOpis());
        cmbVrstaUsluge.setSelectedItem(u.getVrstaUsluge() == null ? null : u.getVrstaUsluge());
        cmbStatusUsluge.setSelectedItem(u.getStatus() == null ? null : u.getStatus());
    }

    private void popuniKomboStatus() {
        cmbStatusUsluge.removeAllItems();
        for (StatusUsluge s : StatusUsluge.values()) {
            cmbStatusUsluge.addItem(s);
        }
    }

    private void podesiIndekseKomboa() {
        cmbStatusUsluge.setSelectedIndex(-1);
        cmbVrstaUsluge.setSelectedIndex(-1);
    }

    private List<JTextComponent> tekstPolja() {
        List<JTextComponent> lista = new ArrayList<>();
        lista.add(txtNazivUsluge);
        lista.add(txtOpisUsluge);
        return lista;
    }

    private void ukloniOsluskivaceZaNovUnos() {
        for (JTextComponent jtc : tekstPolja()) {
            for (KeyListener k : jtc.getKeyListeners()) {
                if (k instanceof KeyAdapter) {
                    jtc.removeKeyListener(k);
                }
            }
        }
    }

    private void postaviBorder() {
        txtNazivUsluge.setBorder(defaultBorderTxtField);
        txtOpisUsluge.setBorder(defaultBorderTxtArea);
    }

}

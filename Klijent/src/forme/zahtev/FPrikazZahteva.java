/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.zahtev;

import domen.Clan;
import domen.Usluga;
import domen.Zahtev;
import forme.FormMode;
import java.util.List;
import kontroler.Kontroler;
import modeli.ModelTabeleZahtev;
import niti.NitOsvezi;

/**
 *
 * @author USER
 */
public class FPrikazZahteva extends javax.swing.JDialog { // OBRATI PAZNJU MOZDA TREBA ISTO ADMIN I CLAN!!!!

    /**
     * Creates new form FPrikazZahteva
     */
    public FPrikazZahteva(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        podesiFormu();
        srediTabeluZahteva();
        popuniTabeluZahtevaNaOsnovuClana();
        //pokreniNit();
    }
    private void srediTabeluZahteva(){
        ModelTabeleZahtev mtz = new ModelTabeleZahtev();
        tblZahtev.setModel(mtz);
    }
    private void popuniTabeluZahtevaNaOsnovuClana(){
        ModelTabeleZahtev mtz = (ModelTabeleZahtev) tblZahtev.getModel();
        Zahtev z = new Zahtev();
        Clan c = (Clan) Kontroler.getInstance().getMapa().get("clan");
        z.setClan(c);
        List<Zahtev> lista = Kontroler.getInstance().vratiZahteve(z);
        mtz.setZahtevi(lista);
        
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblZahtev = new javax.swing.JTable();
        btnIzaberiZahtev = new javax.swing.JButton();
        btnPonisti = new javax.swing.JButton();
        txtFilter = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Trenutni korisnik:");

        txtCurrentUser.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCurrentUser, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCurrentUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tblZahtev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblZahtev);

        btnIzaberiZahtev.setText("Izaberi");
        btnIzaberiZahtev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzaberiZahtevActionPerformed(evt);
            }
        });

        btnPonisti.setText("Ponisti");
        btnPonisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonistiActionPerformed(evt);
            }
        });

        txtFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFilterKeyReleased(evt);
            }
        });

        jLabel2.setText("Filter(po nazivu usluge):");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnPonisti, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIzaberiZahtev, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzaberiZahtev)
                    .addComponent(btnPonisti))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPonistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonistiActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnPonistiActionPerformed

    private void btnIzaberiZahtevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzaberiZahtevActionPerformed
        int row = tblZahtev.getSelectedRow();
        if(row!=-1){
            ModelTabeleZahtev mtz = (ModelTabeleZahtev)tblZahtev.getModel();
            Zahtev z = mtz.getZahtevi().get(row);
            
            Kontroler.getInstance().getMapa().put("izabrani_zahtev", z);
            new FZahtev(null, true, FormMode.VIEW).setVisible(true);
        }
    }//GEN-LAST:event_btnIzaberiZahtevActionPerformed

    private void txtFilterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFilterKeyReleased
        String filter = txtFilter.getText().trim();
        Zahtev z = new Zahtev();
        Clan c = (Clan) Kontroler.getInstance().getMapa().get("clan");
        Usluga u = new Usluga();
        u.setNaziv(filter);
        z.setUsluga(u);
        z.setClan(c);

        List<Zahtev> lista = Kontroler.getInstance().vratiZahteve(z);
        ModelTabeleZahtev mtz = (ModelTabeleZahtev) tblZahtev.getModel();
        mtz.setZahtevi(lista);
    }//GEN-LAST:event_txtFilterKeyReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        azurirajZahteve();
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzaberiZahtev;
    private javax.swing.JButton btnPonisti;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblZahtev;
    private javax.swing.JTextField txtCurrentUser;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables

    private void podesiFormu() {
        setLocationRelativeTo(null);
        Clan c = (Clan) Kontroler.getInstance().getMapa().get("clan");
        txtCurrentUser.setText(c.toString());
    }

    public void azurirajZahteve() {
        popuniTabeluZahtevaNaOsnovuClana();
    }

    private void pokreniNit() {
        NitOsvezi nit = new NitOsvezi(this);
        nit.start();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.usluga;

import domen.VrstaUsluge;
import java.util.List;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import modeli.ModelTabeleVrstaUsluga;

/**
 *
 * @author USER
 */
public class FSelektovanjeVrstaUsluge extends javax.swing.JDialog {

    /**
     * Creates new form FSelektovanjeVrstaUsluge
     */
    public FSelektovanjeVrstaUsluge(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        srediFormu();
    }

    private void srediFormu() {
        setLocationRelativeTo(null);
        srediTabeluVrsta();
        popuniTabeluVrsta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVrstaUsluge = new javax.swing.JTable();
        btnPonisti = new javax.swing.JButton();
        btnIzaberi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblVrstaUsluge.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblVrstaUsluge);

        btnPonisti.setText("Ponisti");
        btnPonisti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonistiActionPerformed(evt);
            }
        });

        btnIzaberi.setText("Izaberi");
        btnIzaberi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzaberiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnPonisti, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnIzaberi, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzaberi)
                    .addComponent(btnPonisti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPonistiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonistiActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnPonistiActionPerformed

    private void btnIzaberiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzaberiActionPerformed
        int row = tblVrstaUsluge.getSelectedRow();
        if(row != -1){
            ModelTabeleVrstaUsluga mtm = (ModelTabeleVrstaUsluga)tblVrstaUsluge.getModel();
            VrstaUsluge vu = mtm.getVrste().get(row);
            Kontroler.getInstance().getMapa().put("izabrana_vrsta", vu);
            JOptionPane.showMessageDialog(this, "ID izabrane vrste: "+vu.getVrstaID());
            dispose();
            
        }
    }//GEN-LAST:event_btnIzaberiActionPerformed
    private void srediTabeluVrsta(){
        ModelTabeleVrstaUsluga mtv = new ModelTabeleVrstaUsluga();
        tblVrstaUsluge.setModel(mtv);
    }
    private void popuniTabeluVrsta(){
        ModelTabeleVrstaUsluga mtv = (ModelTabeleVrstaUsluga)tblVrstaUsluge.getModel();
        List<VrstaUsluge> lista = Kontroler.getInstance().vratiVrsteUsluga();
        mtv.setVrste(lista);
        
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzaberi;
    private javax.swing.JButton btnPonisti;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVrstaUsluge;
    // End of variables declaration//GEN-END:variables
}
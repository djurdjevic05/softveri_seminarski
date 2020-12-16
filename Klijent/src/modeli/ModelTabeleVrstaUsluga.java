/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.VrstaUsluge;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import kontroler.Kontroler;

/**
 *
 * @author USER
 */
public class ModelTabeleVrstaUsluga extends AbstractTableModel{
    private List<VrstaUsluge> vrste;
    private final String[] kolone = new String[]{"ID", "Naziv vrste"};
    
    public ModelTabeleVrstaUsluga(){
        vrste = new ArrayList<>();
    }

    public List<VrstaUsluge> getVrste() {
        return vrste;
    }

    public void setVrste(List<VrstaUsluge> vrste) {
        this.vrste = vrste;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return vrste.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VrstaUsluge v = vrste.get(rowIndex);
        switch(columnIndex){
            case 0: return v.getVrstaID();
            case 1: return v.getNazivVrste();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return false;
        }
        return true;
    }
    
    public void dodajVrstu(VrstaUsluge vu){
        vrste.add(vu);
        fireTableDataChanged();
    }
    
    
    
}

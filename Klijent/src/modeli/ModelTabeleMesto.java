/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Mesto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelTabeleMesto extends AbstractTableModel{
    private List<Mesto> mesta;
    private final String[] kolone = new String[]{"Redni broj","Naziv","Postanski broj"};
    
    public ModelTabeleMesto(){
        mesta = new ArrayList<>();
        
    }
    public ModelTabeleMesto(List<Mesto> mesta){
        this.mesta = mesta;
    }
    @Override
    public int getRowCount() {
        return mesta.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }
    public void setMesta(List<Mesto> mesta){
        this.mesta = mesta;
        fireTableDataChanged();
    }
    public List<Mesto> getMesta(){
        return mesta;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mesto m = mesta.get(rowIndex);
        switch(columnIndex){
            case 0: return m.getMestoID();
            case 1: return m.getNaziv();
            case 2: return m.getPostanskiBroj();
            default: return "";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex!=0;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void dodajMesto(Mesto m){
        mesta.add(m);
        fireTableDataChanged();
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Usluga;
import domen.VrstaUsluge;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import kontroler.Kontroler;

/**
 *
 * @author USER
 */
public class ModelTabeleUsluga extends AbstractTableModel{

    private List<Usluga> listaUsluga;
    String[] kolone = new String[]{"ID","Naziv","Opis","Status","Vrsta usluge"};
    
    public ModelTabeleUsluga(){
        listaUsluga = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return listaUsluga.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usluga u = listaUsluga.get(rowIndex);
        switch(columnIndex){
            case 0: return u.getUslugaID();
            case 1: return u.getNaziv();
            case 2: return u.getOpis();
            case 3: return u.getStatus();//obrati paznju na povratnu vrednost
            case 4: return u.getVrstaUsluge();
            default: return "";
        }
    }

    public List<Usluga> getListaUsluga() {
        return listaUsluga;
    }

    public void setListaUsluga(List<Usluga> listaUsluga) {
        this.listaUsluga = listaUsluga;
        fireTableDataChanged();
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
    
    public void dodajUslugu(Usluga u){
        listaUsluga.add(u);
        fireTableDataChanged();
    }
    
    /*public void ucitajUslugeNaOsnovuVrste(VrstaUsluge vu) throws Exception{
        List<Usluga> usluge = Kontroler.getInstance().vratiSveUsluge();
        List<Usluga> novaLista = new ArrayList<>();
        for(Usluga u : usluge){
            if(u.getVrstaUsluge().equals(vu)){
                novaLista.add(u);
            }
        }
        setListaUsluga(novaLista);
    }*/
    
    
    
}

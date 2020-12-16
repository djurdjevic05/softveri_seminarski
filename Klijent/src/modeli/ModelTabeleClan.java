/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Clan;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelTabeleClan extends AbstractTableModel {
    private List<Clan> listaClanova;
    String []kolone = new String[]{"ID","Ime","Prezime","JMBG","Pol","Adresa","Datum rodjenja","Username","Password","Mesto"};

    public ModelTabeleClan() {
        listaClanova = new ArrayList<>();
    }
    
    

    @Override
    public int getRowCount() {
        return listaClanova.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clan clan = listaClanova.get(rowIndex);
        switch(columnIndex){
            case 0: return clan.getClanID();
            case 1: return clan.getIme();
            case 2: return clan.getPrezime();
            case 3: return clan.getJmbg();
            case 4: return clan.getPol();
            case 5: return clan.getAdresa();
            case 6: return new SimpleDateFormat("dd.MM.yyyy").format(clan.getDatumRodjenja());
            case 7: return clan.getUsername();
            case 8: return clan.getPassword();
            case 9: return clan.getMesto();
            
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

    public List<Clan> getListaClanova() {
        return listaClanova;
    }

    public void setListaClanova(List<Clan> listaClanova) {
        this.listaClanova = listaClanova;
        fireTableDataChanged();
    }
    
    public void obrisiClana(int row){
        listaClanova.remove(row);
        fireTableDataChanged(); // DA LI JE OVA METODA UOPSTE POTREBNA??? MISLIM DA NIJE
    }
    
    
    
    
}

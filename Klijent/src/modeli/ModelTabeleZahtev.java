/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Clan;
import domen.Usluga;
import kontroler.Kontroler;
import domen.Zahtev;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModelTabeleZahtev extends AbstractTableModel {

    private List<Zahtev> zahtevi;
    private String[] kolone = new String[]{"Datum odgovora", "Status zahteva", "Clan", "Usluga"};

    public ModelTabeleZahtev() {
        zahtevi = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return zahtevi.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zahtev z = zahtevi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                if (z.getDatumOdgovora() != null) {
                    return new SimpleDateFormat("dd.MM.yyyy").format(z.getDatumOdgovora());
                } else {
                    return z.getDatumOdgovora();
                }
            case 1:
                return z.getStatusZahteva();
            case 2:
                return z.getClan();
            case 3:
                return z.getUsluga();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public List<Zahtev> getZahtevi() {
        return zahtevi;
    }

    public void setZahtevi(List<Zahtev> zahtevi) {
        this.zahtevi = zahtevi;
        fireTableDataChanged();
    }

    public void dodajZahtev(Zahtev z) {
        zahtevi.add(z);
        fireTableDataChanged();
    }
    public void obrisiZahtev(int row){
        zahtevi.remove(row);
        fireTableDataChanged();
    }
    public void azurirajZahtev(Zahtev zahtev) {
        for(Zahtev z : zahtevi){
            if(zahtev.equals(z)){
                z.setAdministrator(zahtev.getAdministrator());
                z.setDatumOdgovora(zahtev.getDatumOdgovora());
                z.setStatusZahteva(zahtev.getStatusZahteva());
                break;
            }
        }
        fireTableDataChanged();
    }

}

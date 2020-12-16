/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class VrstaUsluge implements OpstiDomenskiObjekat{
    private int vrstaID;
    private String nazivVrste;
    

    public VrstaUsluge(int vrstaID, String nazivVrste) {
        this.vrstaID = vrstaID;
        this.nazivVrste = nazivVrste;
    }

    public VrstaUsluge(String nazivVrste) {
        this.nazivVrste = nazivVrste;
    }

    
    public int getVrstaID() {
        return vrstaID;
    }

    public void setVrstaID(int vrstaID) {
        this.vrstaID = vrstaID;
    }

    public String getNazivVrste() {
        return nazivVrste;
    }

    public void setNazivVrste(String nazivVrste) {
        this.nazivVrste = nazivVrste;
    }

    @Override
    public String toString() {
        return nazivVrste;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VrstaUsluge other = (VrstaUsluge) obj;
        if (this.vrstaID != other.vrstaID) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return "vrsta_usluge";
    }

    @Override
    public boolean isAutoIncrement() {
        return true;
    }

    @Override
    public String vratiNaziveKolona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaUnos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiWhereUslov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return " * ";
    }

    @Override
    public String vratiAlijas() {
        return " vu ";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "";
    }

    @Override
    public String vratiFilterZaSelect() {
        return "";
    }
    @Override
    public String vratiGrupisanje() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> listaV = new ArrayList<>();
        while(rs.next()){
            listaV.add(new VrstaUsluge(rs.getInt("id"), rs.getString("naziv_vrste")));
        }
        return listaV;
    }

    @Override
    public void setID(int id) {
        setVrstaID(id);
    }
    
    
    
}

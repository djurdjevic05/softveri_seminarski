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
public class Usluga implements OpstiDomenskiObjekat{
    private int uslugaID;
    private String naziv;
    private String opis;
    private StatusUsluge status;
    private VrstaUsluge vrstaUsluge;
    
    public Usluga(){
        
    }

    public Usluga(int uslugaID, String naziv, String opis, StatusUsluge status, VrstaUsluge vrstaUsluge) {
        this.uslugaID = uslugaID;
        this.naziv = naziv;
        this.opis = opis;
        this.status = status;
        this.vrstaUsluge = vrstaUsluge;
    }

    public Usluga(String naziv, String opis, StatusUsluge status, VrstaUsluge vrstaUsluge) {
        this.naziv = naziv;
        this.opis = opis;
        this.status = status;
        this.vrstaUsluge = vrstaUsluge;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usluga other = (Usluga) obj;
        if (this.uslugaID != other.uslugaID) {
            return false;
        }
        return true;
    }
    
    

    public int getUslugaID() {
        return uslugaID;
    }

    public void setUslugaID(int uslugaID) {
        this.uslugaID = uslugaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public StatusUsluge isStatus() {
        return status;
    }

    public void setStatus(StatusUsluge status) {
        this.status = status;
    }

    public VrstaUsluge getVrstaUsluge() {
        return vrstaUsluge;
    }

    public void setVrstaUsluge(VrstaUsluge vrstaUsluge) {
        this.vrstaUsluge = vrstaUsluge;
    }

    public StatusUsluge getStatus() {
        return status;
    }
    
    public String toString(){
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "usluga";
    }

    @Override
    public boolean isAutoIncrement() {
        return true;
    }

    @Override
    public String vratiNaziveKolona() {
        return "naziv,opis,status,vrsta_usluge_id";
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return "'"+naziv+"','"+opis+"','"+status+"',"+vrstaUsluge.getVrstaID();
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return " naziv='"+naziv+"',opis='"+opis+"',status='"+status+"',vrsta_usluge_id="+vrstaUsluge.getVrstaID();
    }

    @Override
    public String vratiWhereUslov() {
        return " id="+uslugaID;
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return " * ";
    }

    @Override
    public String vratiAlijas() {
        return " u ";
    }

    @Override
    public String vratiUslovZaJoin() {
        return " join vrsta_usluge vu on u.vrsta_usluge_id=vu.id ";
    }

    @Override
    public String vratiFilterZaSelect() {
        if(vrstaUsluge != null && naziv !=null && opis != null){
            return " WHERE naziv LIKE '%"+naziv+"%' OR opis LIKE '%"+opis+"%' AND vrsta_usluge_id = "+vrstaUsluge.getVrstaID();
        }
        if(vrstaUsluge != null){
            return " WHERE vrsta_usluge_id = "+vrstaUsluge.getVrstaID();
        }
        if(naziv != null && opis != null){
            return " WHERE naziv LIKE '%"+naziv+"%' OR opis LIKE '%"+opis+"%'";
        }
        if(uslugaID > 0){
            return " WHERE id = "+uslugaID; // ZA PRIKAZI ODABRANU USLUGU
        }
        return "";
    }

    @Override
    public String vratiGrupisanje() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> listaUsluga = new ArrayList<>();
        while(rs.next()){
            VrstaUsluge vu = new VrstaUsluge(rs.getInt("vu.id"), rs.getString("naziv_vrste"));
            listaUsluga.add(new Usluga(rs.getInt("u.id"), rs.getString("u.naziv"), rs.getString("u.opis"), StatusUsluge.valueOf(rs.getString("u.status")), vu));
        }
  
        return listaUsluga;
    }

    @Override
    public void setID(int id) {
        setUslugaID(id);
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author USER
 */
public class Clan implements OpstiDomenskiObjekat{
    private int clanID;
    private String ime;
    private String prezime;
    private String jmbg;
    private String pol;

    
    private String adresa;
    //private TipKorisnika tipKorisnika;
    private Date datumRodjenja;
    private String username;
    private String password;
    
    private Mesto mesto;

    private String whereFilter;
    
    public Clan(){
        whereFilter = "";
    }
    public Clan(int clanID, String ime, String prezime, String jmbg, String pol, String adresa, Date datumRodjenja,String username,String password, Mesto mesto) {
        this.clanID = clanID;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.pol = pol;
        this.adresa = adresa;
        this.datumRodjenja = datumRodjenja;
        this.username = username;
        this.password = password;
        this.mesto = mesto;
        whereFilter = "";
        
    }

    public Clan(String ime, String prezime, String jmbg, String pol, String adresa, Date datumRodjenja,String username,String password, Mesto mesto) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.pol = pol;
        this.adresa = adresa;
        this.datumRodjenja = datumRodjenja;
        this.username = username;
        this.password = password;
        this.mesto = mesto;
        whereFilter = "";
    }
    

    public int getClanID() {
        return clanID;
    }

    public void setClanID(int clanID) {
        this.clanID = clanID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /*public TipKorisnika getTipKorisnika() {
        return tipKorisnika;
    }

    public void setTipKorisnika(TipKorisnika tipKorisnika) {
        this.tipKorisnika = tipKorisnika;
    }*/
    
    public String getWhereFilter() {
        return whereFilter;
    }

    public void setWhereFilter(String whereFilter) {
        this.whereFilter = whereFilter;
    }
    


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clan other = (Clan) obj;
        if (this.clanID != other.clanID) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return ime+" "+prezime;
        
    }

    @Override
    public String vratiNazivTabele() {
        return "clan";
    }

    @Override
    public boolean isAutoIncrement() {
        return true;
    }

    @Override
    public String vratiNaziveKolona() {
        return "ime,prezime,jmbg,pol,adresa,datum_rodjenja,username,password,mesto_id";
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return "'"+ime+"','"+prezime+"','"+jmbg+"','"+pol+"','"+adresa+"','"+new java.sql.Date(datumRodjenja.getTime())+"','"+username+"','"+password+"',"+mesto.getMestoID();
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return " ime='"+ime+"',prezime='"+prezime+"',jmbg='"+jmbg+"',pol='"+pol+"',datum_rodjenja='"+new java.sql.Date(datumRodjenja.getTime())+"',username='"+username+"',password='"+password+"',mesto_id="+mesto.getMestoID();
    }

    @Override
    public String vratiWhereUslov() {
        return " id="+clanID;
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return " * ";
    }

    @Override
    public String vratiAlijas() {
        return " c ";
    }

    @Override
    public String vratiUslovZaJoin() {
        return " join mesto m on c.mesto_id=m.id ";
    }

    @Override
    public String vratiFilterZaSelect() {
        if(whereFilter!=null && username != null && password != null){
            return " WHERE username = '"+username+"' AND password='"+password+"' LIMIT 1";
        }
        if(ime != null && prezime != null && adresa != null && jmbg != null){
            return " WHERE ime LIKE '%"+ime+"%' OR prezime LIKE '%"+prezime+"%' OR adresa LIKE '%"+adresa+"%' OR jmbg LIKE '%"+jmbg+"%'";
        }
        if(clanID > 0){
            return " WHERE id = "+clanID; // DODATO ZA PRIKAZI IZABRANOG CLANA 
        }
        return "";
    }
    @Override
    public String vratiGrupisanje() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> listaClanova = new ArrayList<>();
        while(rs.next()){
            Mesto m = new Mesto(rs.getInt("m.id"), rs.getString("m.naziv"), rs.getString("m.postanski_broj"));
            int cID = rs.getInt("c.id");
            String ime1 = rs.getString("ime");
            String prezime1 = rs.getString("prezime");
            String jmbg1 = rs.getString("jmbg");
            String pol1 = rs.getString("pol");
            String adresa1 = rs.getString("adresa");
            Date datumRodjenja1 = rs.getDate("datum_rodjenja");
            String username1 = rs.getString("username");
            String password1 = rs.getString("password");
            
            listaClanova.add(new Clan(cID, ime1, prezime1, jmbg1, pol1, adresa1, datumRodjenja1, username1, password1, m));
        }
        return listaClanova;
    }

    @Override
    public void setID(int id) {
        setClanID(id);
    }
    
}

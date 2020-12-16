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
public class Zahtev implements OpstiDomenskiObjekat{
    private int sifra;
    private Clan clan;
    private Usluga usluga;
    private Date datumOdgovora;
    private StatusZahteva statusZahteva;
    private Administrator administrator;

    public Zahtev() {
    }
    public Zahtev(int sifra, Clan clan, Usluga usluga, Date datumOdgovora, StatusZahteva statusZahteva, Administrator administrator) {
        this.sifra = sifra;
        this.clan = clan;
        this.usluga = usluga;
        this.datumOdgovora = datumOdgovora;
        this.statusZahteva = statusZahteva;
        this.administrator = administrator;
    }

    public Zahtev(Clan clan, Usluga usluga, Date datumOdgovora, StatusZahteva statusZahteva, Administrator administrator) {
        this.clan = clan;
        this.usluga = usluga;
        this.datumOdgovora = datumOdgovora;
        this.statusZahteva = statusZahteva;
        this.administrator = administrator;
    }

    public Zahtev(Clan clan, Usluga usluga, StatusZahteva statusZahteva) {
        this.clan = clan;
        this.usluga = usluga;
        this.statusZahteva = statusZahteva;
    }
    

    

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public Date getDatumOdgovora() {
        return datumOdgovora;
    }

    public void setDatumOdgovora(Date datumOdgovora) {
        this.datumOdgovora = datumOdgovora;
    }

    public StatusZahteva getStatusZahteva() {
        return statusZahteva;
    }

    public void setStatusZahteva(StatusZahteva odobreno) {
        this.statusZahteva = odobreno;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zahtev other = (Zahtev) obj;
        if (this.sifra != other.sifra) {
            return false;
        }
        return true;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    @Override
    public String vratiNazivTabele() {
        return "zahtev";
    }

    @Override
    public boolean isAutoIncrement() {
        return true;
    }

    @Override
    public String vratiNaziveKolona() {
        return "status_zahteva,clan_id,usluga_id";//bez admin_id
    }

    @Override
    public String vratiVrednostiZaUnos() {
        return "'"+statusZahteva+"',"+clan.getClanID()+","+usluga.getUslugaID(); // unosi se bez administratora i datuma odgovora
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return " datum_odgovora='"+new java.sql.Date(datumOdgovora.getTime())+"',status_zahteva='"+statusZahteva+"',admin_id="+administrator.getAdminID();
    }

    @Override
    public String vratiWhereUslov() {
        return " sifra="+sifra+" and clan_id="+clan.getClanID()+" and usluga_id="+usluga.getUslugaID();
    }

    @Override
    public String vratiKoloneZaSelektovanje() {
        return " * ";
    }

    @Override
    public String vratiAlijas() {
        return " z ";
    }

    @Override
    public String vratiUslovZaJoin() {
        return " join clan c on z.clan_id=c.id join usluga u on z.usluga_id=u.id left join administrator a on z.admin_id=a.id "
                + "join vrsta_usluge vu on u.vrsta_usluge_id=vu.id join mesto m on c.mesto_id=m.id ";
    }

    @Override
    public String vratiFilterZaSelect() {
        if(clan != null && usluga != null){
            return " WHERE u.naziv LIKE '%"+usluga.getNaziv()+"%' AND z.clan_id = "+clan.getClanID()+" ";
        }
        if(usluga != null){
            return " WHERE u.naziv LIKE '%"+usluga.getNaziv()+"%' ";
        }
        if(clan != null){
            return " WHERE z.clan_id = "+clan.getClanID()+" ";
        }
        return "";
    }
    @Override
    public String vratiGrupisanje() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> listaZahteva = new ArrayList<>();
        while(rs.next()){
            Mesto m = new Mesto(rs.getInt("m.id"), rs.getString("m.naziv"), rs.getString("postanski_broj"));
            VrstaUsluge vu = new VrstaUsluge(rs.getInt("vu.id"), rs.getString("naziv_vrste"));
            
            int clanID = rs.getInt("c.id");
            String ime = rs.getString("c.ime");
            String prezime = rs.getString("c.prezime");
            String jmbg = rs.getString("jmbg");
            String pol = rs.getString("pol");
            String adresa = rs.getString("adresa");
            Date datumRodjenja = rs.getDate("datum_rodjenja");
            String username = rs.getString("c.username");
            String password = rs.getString("c.password");

            Clan c = new Clan(clanID, ime, prezime, jmbg, pol, adresa, datumRodjenja, username, password, m);
            
            int uslugaID = rs.getInt("u.id");
            String naziv = rs.getString("u.naziv");
            String opis = rs.getString("opis");
            StatusUsluge status = StatusUsluge.valueOf(rs.getString("status"));
            
            Usluga u = new Usluga(uslugaID, naziv, opis, status, vu);
            
            Administrator a = null;
            if(rs.getObject("a.id") != null){
                a = new Administrator(rs.getInt("a.id"), rs.getString("a.ime"), rs.getString("a.prezime"), rs.getString("a.username"), rs.getString("a.password"));
            }
            
            int sifra1 = rs.getInt("sifra");
            Date datumOdgovora1 = rs.getDate("datum_odgovora");
            StatusZahteva statusZahteva1 = StatusZahteva.valueOf(rs.getString("status_zahteva"));
            
            listaZahteva.add(new Zahtev(sifra1, c, u, datumOdgovora1, statusZahteva1, a));
        }
        return listaZahteva;
    }

    @Override
    public void setID(int sifra) {
        setSifra(sifra);
    }
    
    
    
    

    
    
    
}

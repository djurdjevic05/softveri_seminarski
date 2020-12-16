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
public class Administrator implements OpstiDomenskiObjekat {

    private int adminID;
    private String ime;
    private String prezime;
    private String username;
    private String password;

    public Administrator() {
    }

    
    public Administrator(int adminID, String ime, String prezime, String username, String password) {
        this.adminID = adminID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    public Administrator(String ime, String prezime, String username, String password) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Administrator other = (Administrator) obj;
        if (this.adminID != other.adminID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (ime != null && prezime != null) {
            return ime + " " + prezime;
        }
        return null;
    }

    @Override
    public String vratiNazivTabele() {
        return "administrator";
    }

    @Override
    public boolean isAutoIncrement() {
        return true;
    }

    @Override
    public String vratiNaziveKolona() {
        return "";
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
        return " a ";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "";
    }

    @Override
    public String vratiFilterZaSelect() {
        if(username != null && password != null){
            return " WHERE username = '"+username+"' AND password='"+password+"' LIMIT 1";
        }
        return "";
    }

    @Override
    public String vratiGrupisanje() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> listaAdministratora = new ArrayList<>();
        while (rs.next()) {
            listaAdministratora.add(new Administrator(rs.getInt("id"), rs.getString("ime"), rs.getString("prezime"), rs.getString("username"), rs.getString("password")));
        }
        return listaAdministratora;
    }

    @Override
    public void setID(int id) {
        setAdminID(id);
    }

}

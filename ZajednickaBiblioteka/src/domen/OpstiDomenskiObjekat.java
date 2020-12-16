/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author USER
 */
public interface OpstiDomenskiObjekat extends Serializable{
    public String vratiNazivTabele();
    public boolean isAutoIncrement();
    public void setID(int id);
    public String vratiNaziveKolona();
    public String vratiVrednostiZaUnos();
    public String vratiVrednostiZaUpdate();
    public String vratiWhereUslov();
    public String vratiKoloneZaSelektovanje();
    public String vratiAlijas();
    public String vratiUslovZaJoin();
    public String vratiFilterZaSelect();
    public String vratiGrupisanje();
    public List<OpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException;
    
    
}

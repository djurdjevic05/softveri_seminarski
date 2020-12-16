/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import baza.Konekcija;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import transfer.ServerskiOdgovor;

/**
 *
 * @author USER
 */
public abstract class OpstaSistemskaOperacija {
    public final ServerskiOdgovor izvrsiTransakciju(Object odo) throws Exception{
        ServerskiOdgovor so = new ServerskiOdgovor();
        try{
            proveriPreduslov(odo);
            pokreniTransakciju();
            so = izvrsiOperaciju(odo);
            potvrdiTransakciju();
        }catch(Exception ex){
            so.setUspesno(false);
            so.setPoruka(ex.getMessage());
            ponistiTransakciju();
        }
        return so;
    }
    
    protected abstract void proveriPreduslov(Object odo) throws Exception;
    
    private void pokreniTransakciju() throws SQLException{
        Konekcija.getInstance().getConnection().setAutoCommit(false);
    }
    
    protected abstract ServerskiOdgovor izvrsiOperaciju(Object odo) throws Exception;
    
    private void potvrdiTransakciju() throws SQLException{
        Konekcija.getInstance().commit();
    }
    
    private void ponistiTransakciju() throws SQLException{
        Konekcija.getInstance().rollback();
    }
}

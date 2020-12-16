/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.clan;

import baza.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.OpstaSistemskaOperacija;
import transfer.ServerskiOdgovor;

/**
 *
 * @author USER
 */
public class IzmeniClanaSO extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
        if (odo == null) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected ServerskiOdgovor izvrsiOperaciju(Object odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try{
            OpstiDomenskiObjekat opsti = (OpstiDomenskiObjekat) odo;
            DBBroker.getInstance().update(opsti);
            so.setOdgovor(null);//null
            so.setUspesno(true);
            so.setPoruka("Clan azuriran!");
        }catch(Exception ex){
            Logger.getLogger(IzmeniClanaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Clan nije azuriran!");
        }
        return so;
    }
    
}

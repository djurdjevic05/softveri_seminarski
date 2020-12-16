/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.usluga;

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
public class ObrisiUsluguSO extends OpstaSistemskaOperacija {

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
            DBBroker.getInstance().delete(opsti);
            so.setOdgovor(null);
            so.setUspesno(true);
            so.setPoruka("Usluga obrisana!");
        }catch(Exception ex){
            Logger.getLogger(ObrisiUsluguSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Usluga nije obrisana!");
        }
        return so;
    }

}

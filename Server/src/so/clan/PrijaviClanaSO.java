/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.clan;

import baza.DBBroker;
import domen.Administrator;
import domen.Clan;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.OpstaSistemskaOperacija;
import transfer.ServerskiOdgovor;

/**
 *
 * @author USER
 */
public class PrijaviClanaSO extends OpstaSistemskaOperacija {

    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
        if(odo == null || (!(odo instanceof Clan) && !(odo instanceof Administrator))){
            throw new Exception("Nevalidan objekat!");
        }
        
    }

    @Override
    protected ServerskiOdgovor izvrsiOperaciju(Object odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            OpstiDomenskiObjekat opsti = (OpstiDomenskiObjekat) odo;
            List<OpstiDomenskiObjekat> lista = opsti.ucitajListu(DBBroker.getInstance().select(opsti));
            if(lista.isEmpty()){
                throw new Exception("Neuspesno prijavljivanje! Korisnik sa unetim username-om i/ili password-om ne postoji!");
            }
            so.setOdgovor(lista);
            so.setUspesno(true);
            so.setPoruka("Uspesno prijavljivanje!");
        } catch (Exception ex) {
            //Logger.getLogger(PrijaviClanaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }

        return so;
    }

}

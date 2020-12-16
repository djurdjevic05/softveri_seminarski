/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zahtev;

import baza.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Zahtev;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.OpstaSistemskaOperacija;
import transfer.ServerskiOdgovor;

/**
 *
 * @author USER
 */
public class OdgovoriNaZahtevSO extends OpstaSistemskaOperacija {

    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
        if (odo == null) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected ServerskiOdgovor izvrsiOperaciju(Object odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            List<Zahtev> listaZahteva = (List<Zahtev>) odo;
            for (Zahtev z : listaZahteva) {
                DBBroker.getInstance().update(z);
            }
            so.setOdgovor(null);
            so.setUspesno(true);
            so.setPoruka("Odgovori na zahteve sacuvani!");
        } catch (Exception ex) {
            Logger.getLogger(OdgovoriNaZahtevSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Odgovori na zahteve nisu sacuvani!");
        }
        return so;
    }

}

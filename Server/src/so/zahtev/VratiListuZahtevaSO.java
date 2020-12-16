/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zahtev;

import baza.DBBroker;
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
public class VratiListuZahtevaSO extends OpstaSistemskaOperacija {

    @Override
    protected void proveriPreduslov(Object odo) throws Exception {

    }

    @Override
    protected ServerskiOdgovor izvrsiOperaciju(Object odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            OpstiDomenskiObjekat opsti = (OpstiDomenskiObjekat) odo;
            List<OpstiDomenskiObjekat> lista = opsti.ucitajListu(DBBroker.getInstance().select(opsti));
            so.setOdgovor(lista);
            so.setPoruka("Prikaz liste zahteva");
            so.setUspesno(true);

        } catch (Exception ex) {
            Logger.getLogger(VratiListuZahtevaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Lista zahteva nije pronadjena!");
        }

        return so;
    }

}

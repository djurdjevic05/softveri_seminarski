/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.clan;

import baza.DBBroker;
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
public class VratiListuClanovaSO extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
        
    }

    @Override
    protected ServerskiOdgovor izvrsiOperaciju(Object odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try{
            //Clan c = (Clan)odo;
            //c.setWhereFilter("");
            OpstiDomenskiObjekat opsti = (OpstiDomenskiObjekat) odo;
            List<OpstiDomenskiObjekat> lista = opsti.ucitajListu(DBBroker.getInstance().select(opsti));
            so.setOdgovor(lista);
            so.setUspesno(true);
            so.setPoruka("Prikaz liste clanova");
        }catch(Exception ex){
            Logger.getLogger(VratiListuClanovaSO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Lista clanova nije pronadjena!");
        }
        return so;
    }
    
}

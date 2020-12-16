/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Zahtev;
import forme.FGlavna;
import forme.zahtev.FPrikazZahteva;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Komunikacija;
import konstante.Operacije;
import transfer.ServerskiOdgovor;

/**
 *
 * @author USER
 */
public class NitOsvezi extends Thread {

    
    private FPrikazZahteva fpz;

    public NitOsvezi(FPrikazZahteva fg) {
        this.fpz = fg;
    }

    @Override
    public void run() {
        while (true) {
            fpz.azurirajZahteve();

            try {
                sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(NitOsvezi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

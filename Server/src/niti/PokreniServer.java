/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.GlavnaServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.Kontroler;

/**
 *
 * @author USER
 */
public class PokreniServer extends Thread {
    ServerSocket serverSocket;
    GlavnaServerskaForma gsf;
    boolean kraj;
    int port;
    public PokreniServer(GlavnaServerskaForma gsf, int port) {
        this.gsf = gsf;
        this.port = port;
        kraj = false;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Pokrenut server!");
            while (!kraj) { 
                Socket socket = serverSocket.accept();
                System.out.println("Klijent se povezao!");
                ObradaKlijentskihZahteva nit = new ObradaKlijentskihZahteva(socket);
                Kontroler.getInstance().getListaKlijenata().add(nit);
                nit.start();
                
            }
        } catch (IOException ex) {
            //Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
            gsf.zaustavljenServer();
        }

    }

    public void zaustaviServer() {
        try {
            kraj = true;
            serverSocket.close();
            /*for(ObradaKlijentskihZahteva okz : Kontroler.getInstance().getListaKlijenata()){
                okz.prekiniNit();
            }*/
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}

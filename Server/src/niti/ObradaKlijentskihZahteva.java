/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Administrator;
import domen.Clan;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Usluga;
import domen.VrstaUsluge;
import domen.Zahtev;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import logika.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author USER
 */
public class ObradaKlijentskihZahteva extends Thread {

    private Socket socket;
    boolean kraj;

    public ObradaKlijentskihZahteva(Socket s) {
        this.socket = s;
        kraj = false;
    }

    @Override
    public void run() {
        while (!kraj) {
            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = obradiZahtev(kz);
            posaljiOdgovor(so);
        }
    }

    private ServerskiOdgovor obradiZahtev(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor();
        switch (kz.getOperacija()) {
            case Operacije.LOGIN:
                Map<String, Object> parametri = (Map<String, Object>) kz.getParametar();
                Clan clan = (Clan) parametri.get("clan");
                System.out.println(clan.getUsername());
                clan.setWhereFilter("login");
                
                try {
                    so = Kontroler.getInstance().prijaviKorisnika(clan);
                    if (so.getOdgovor() == null || ((List<OpstiDomenskiObjekat>) so.getOdgovor()).isEmpty()) {
                        Administrator admin = (Administrator) parametri.get("admin");
                        System.out.println(admin.getUsername());
                        so = Kontroler.getInstance().prijaviKorisnika(admin);
                    }
                } catch (Exception ex) {
                    so.setPoruka(so.getPoruka());
                }
                break;
            case Operacije.UNESI_CLANA:
                Clan clanUnos = (Clan) kz.getParametar();
                try {
                    so = Kontroler.getInstance().unesiClana(clanUnos);
                } catch (Exception ex) {
                    so.setPoruka(so.getPoruka() + "\n " + ex.getMessage());
                }
                break;
            case Operacije.IZMENI_CLANA:
                Clan clanIzmena = (Clan) kz.getParametar();
                try {
                    so = Kontroler.getInstance().izmeniClana(clanIzmena);
                } catch (Exception ex) {
                    so.setPoruka(so.getPoruka() + "\n " + ex.getMessage());
                }
                break;
            case Operacije.OBRISI_CLANA:
                Clan clanBrisanje = (Clan) kz.getParametar();
                try {
                    so = Kontroler.getInstance().obrisiClana(clanBrisanje);
                } catch (Exception ex) {
                    so.setPoruka(so.getPoruka() + "\n " + ex.getMessage());
                }
                break;
            case Operacije.UNESI_USLUGU:
                Usluga uslugaUnos = (Usluga) kz.getParametar();
                try {
                    so = Kontroler.getInstance().unesiUslugu(uslugaUnos);
                } catch (Exception ex) {
                    so.setPoruka(so.getPoruka() + "\n " + ex.getMessage());
                }
                break;
            case Operacije.IZMENI_USLUGU:
                Usluga uslugaIzmena = (Usluga) kz.getParametar();
                try {
                    so = Kontroler.getInstance().izmeniUslugu(uslugaIzmena);
                } catch (Exception ex) {
                    so.setPoruka(so.getPoruka() + "\n " + ex.getMessage());
                }
                break;
                case Operacije.OBRISI_USLUGU:
                Usluga uslugaBrisanje = (Usluga) kz.getParametar();
                try {
                    so = Kontroler.getInstance().obrisiUslugu(uslugaBrisanje);
                } catch (Exception ex) {
                    so.setPoruka(so.getPoruka() + "\n " + ex.getMessage());
                }
                break;
            case Operacije.VRATI_USLUGE:
                Usluga u = (Usluga) kz.getParametar();
                try {
                    so = Kontroler.getInstance().vratiListuUsluga(u);
                } catch (Exception ex) {
                    so.setPoruka(so.getPoruka() + "\n " + ex.getMessage());
                }
                break;

            case Operacije.VRATI_CLANOVE:
                Clan clanovi = (Clan) kz.getParametar();
                try {
                    so = Kontroler.getInstance().vratiListuClanova(clanovi);
                } catch (Exception ex) {
                    so.setPoruka(so.getPoruka() + "\n " + ex.getMessage());
                }
                break;
            case Operacije.VRATI_MESTA:
                Mesto m = (Mesto) kz.getParametar();
                try {
                    so = Kontroler.getInstance().vratiListuMesta(m);
                } catch (Exception ex) {
                    so.setPoruka(so.getPoruka() + "\n " + ex.getMessage());
                }
                break;
            case Operacije.VRATI_VRSTE_USLUGA:
                VrstaUsluge vu = (VrstaUsluge) kz.getParametar();
                try {
                    so = Kontroler.getInstance().vratiListuVrstaUsluga(vu);
                } catch (Exception ex) {
                    so.setPoruka(so.getPoruka() + "\n " + ex.getMessage());
                }
                break;
            case Operacije.ZAPAMTI_ZAHTEVE:
                List<Zahtev> listaUnosZahteva = (List<Zahtev>) kz.getParametar(); /// ????????????????????
                try {
                    so = Kontroler.getInstance().zapamtiZahtev(listaUnosZahteva);
                } catch (Exception ex) {
                    so.setPoruka(so.getPoruka() + "\n " + ex.getMessage());
                }
                break;
            case Operacije.VRATI_ZAHTEVE:
                Zahtev z1 = (Zahtev) kz.getParametar();
                try {
                    so = Kontroler.getInstance().vratiListuZahteva(z1);
                } catch (Exception ex) {
                    so.setPoruka(so.getPoruka() + "\n " + ex.getMessage());
                }
                break;
            case Operacije.ODGOVORI_NA_ZAHTEVE:
                List<Zahtev> listaOdgovoraNaZahteve = (List<Zahtev>) kz.getParametar();
                try {
                    so = Kontroler.getInstance().odgovoriNaZahtev(listaOdgovoraNaZahteve);
                } catch (Exception ex) {
                    so.setPoruka(so.getPoruka() + "\n " + ex.getMessage());
                }
                break;
            case Operacije.KRAJ_RADA:
                kraj = true;
                so.setPoruka("Sistem je zavrsio sa radom.");
                break;
        }
        return so;
    }

    private KlijentskiZahtev primiZahtev() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            return (KlijentskiZahtev) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            if(ex instanceof SocketException){
                System.out.println("Klijent odjavljen");
            }
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void prekiniNit() {
        try {
            socket.close();
            kraj = true;
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}

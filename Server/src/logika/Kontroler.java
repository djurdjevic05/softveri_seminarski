/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import baza.DBBroker;
import baza.Konekcija;
import domen.Administrator;
import domen.OpstiDomenskiObjekat;
import domen.Zahtev;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import niti.ObradaKlijentskihZahteva;
import so.clan.IzmeniClanaSO;
import so.clan.ObrisiClanaSO;
import so.clan.PrijaviClanaSO;
import so.clan.UnesiClanaSO;
import so.clan.VratiListuClanovaSO;
import so.mesto.VratiListuMestaSO;
import so.usluga.IzmeniUsluguSO;
import so.usluga.ObrisiUsluguSO;
import so.usluga.UnesiUsluguSO;
import so.usluga.VratiListuUslugaSO;
import so.vrstausluge.VratiListuVrstaUslugaSO;
import so.zahtev.OdgovoriNaZahtevSO;
import so.zahtev.VratiListuZahtevaSO;
import so.zahtev.ZapamtiZahtevSO;
import transfer.ServerskiOdgovor;

/**
 *
 * @author USER
 */
public class Kontroler {

    private static Kontroler instance;
    private List<ObradaKlijentskihZahteva> listaKlijenata;

    private Kontroler() {
        listaKlijenata = new ArrayList<>();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public List<ObradaKlijentskihZahteva> getListaKlijenata() {
        return listaKlijenata;
    }
    
    public ServerskiOdgovor vratiListuMesta(OpstiDomenskiObjekat odo) throws Exception {
        return new VratiListuMestaSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor vratiListuVrstaUsluga(OpstiDomenskiObjekat odo) throws Exception {
        return new VratiListuVrstaUslugaSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor vratiListuClanova(OpstiDomenskiObjekat odo) throws Exception {
        return new VratiListuClanovaSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor unesiClana(OpstiDomenskiObjekat odo) throws Exception {
        return new UnesiClanaSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor izmeniClana(OpstiDomenskiObjekat odo) throws Exception {
        return new IzmeniClanaSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor obrisiClana(OpstiDomenskiObjekat odo) throws Exception {
        return new ObrisiClanaSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor prijaviKorisnika(OpstiDomenskiObjekat odo) throws Exception {
        return new PrijaviClanaSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor vratiListuUsluga(OpstiDomenskiObjekat odo) throws Exception {
        return new VratiListuUslugaSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor unesiUslugu(OpstiDomenskiObjekat odo) throws Exception {
        return new UnesiUsluguSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor izmeniUslugu(OpstiDomenskiObjekat odo) throws Exception {
        return new IzmeniUsluguSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor obrisiUslugu(OpstiDomenskiObjekat odo) throws Exception {
        return new ObrisiUsluguSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor zapamtiZahtev(List<Zahtev> odo) throws Exception {
        return new ZapamtiZahtevSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor vratiListuZahteva(OpstiDomenskiObjekat odo) throws Exception {
        return new VratiListuZahtevaSO().izvrsiTransakciju(odo);
    }

    public ServerskiOdgovor odgovoriNaZahtev(List<Zahtev> odo) throws Exception {
        return new OdgovoriNaZahtevSO().izvrsiTransakciju(odo);
    }

}

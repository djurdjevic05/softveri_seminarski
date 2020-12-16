/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Administrator;
import domen.Clan;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.TipKorisnika;
import domen.Usluga;
import domen.VrstaUsluge;
import domen.Zahtev;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author USER
 */
public class Kontroler {

    private static Kontroler instance;
    private Map<String, Object> mapa;
    private TipKorisnika tipKorisnika;

    private Kontroler() {
        mapa = new HashMap<>();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Map<String, Object> getMapa() {
        return mapa;
    }

    public void setTipKorisnika(TipKorisnika tipKorisnika) {
        this.tipKorisnika = tipKorisnika;
    }

    public TipKorisnika getTipKorisnika() {
        return tipKorisnika;
    }

    public boolean prijaviClana(Map<String,Object> parametri) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.LOGIN);
        kz.setParametar(parametri);
        System.out.println(((Clan)parametri.get("clan")).getUsername());
        System.out.println(((Administrator)parametri.get("admin")).getUsername());

        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();

        //List<Clan> listaClanova = (List<Clan>) so.getOdgovor();
        JOptionPane.showMessageDialog(null, so.getPoruka());
        //if(listaClanova == null || listaClanova.isEmpty()){
        List<OpstiDomenskiObjekat> lista = (List<OpstiDomenskiObjekat>) so.getOdgovor();
        if (lista == null || lista.isEmpty()) {
            return false;
        } else {
            //mapa.put("clan", listaClanova.get(0));
            if(lista.get(0) instanceof Clan){
                System.out.println("Usao u Clan");
                setTipKorisnika(TipKorisnika.CLAN);
                Clan c = (Clan) lista.get(0);
                mapa.put("clan", c);
            }else{
                System.out.println("Usao u Admin");
                setTipKorisnika(TipKorisnika.ADMINISTRATOR);
                Administrator a = (Administrator) lista.get(0);
                mapa.put("admin", a);
            }
            return true;
        }
    }
    public OpstiDomenskiObjekat vratiKorisnika(){
        if(tipKorisnika == TipKorisnika.ADMINISTRATOR){
             return (Administrator)mapa.get("admin");
        }
        return (Clan)mapa.get("clan");
    }

    public List<Usluga> vratiUsluge(Usluga u) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_USLUGE);
        kz.setParametar(u);

        Komunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        if (!so.isUspesno()) {
            JOptionPane.showMessageDialog(null, so.getPoruka());
            return new ArrayList<>();
        }
        List<Usluga> lista = (List<Usluga>) so.getOdgovor();
        return lista;
    }

    public List<VrstaUsluge> vratiVrsteUsluga() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_VRSTE_USLUGA);
        kz.setParametar(new VrstaUsluge(""));

        Komunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        if (!so.isUspesno()) {
            JOptionPane.showMessageDialog(null, so.getPoruka());
            return new ArrayList<>();
        }
        List<VrstaUsluge> lista = (List<VrstaUsluge>) so.getOdgovor();
        return lista;
    }

    public ServerskiOdgovor zapamtiZahteve(List<Zahtev> listaZahteva) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.ZAPAMTI_ZAHTEVE);
        kz.setParametar(listaZahteva);

        Komunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;

    }

    public List<Zahtev> vratiZahteve(Zahtev z) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_ZAHTEVE);
        //Clan c = (Clan) mapa.get("clan");
        //Zahtev z = new Zahtev();
        //z.setClan(c);
        kz.setParametar(z);

        Komunikacija.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        if (!so.isUspesno()) {
            JOptionPane.showMessageDialog(null, so.getPoruka());
            return new ArrayList<>();
        }
        List<Zahtev> lista = (List<Zahtev>) so.getOdgovor();
        return lista;
    }

    public ServerskiOdgovor unesiClana(Clan c) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.UNESI_CLANA);
        kz.setParametar(c);

        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor izmeniClana(Clan c) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_CLANA);
        kz.setParametar(c);

        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public List<Mesto> vratiListuMesta(Mesto mesto) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_MESTA);
        kz.setParametar(mesto);

        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        if (!so.isUspesno()) {
            JOptionPane.showMessageDialog(null, so.getPoruka());
            return new ArrayList<>();
        }
        List<Mesto> lista = (List<Mesto>) so.getOdgovor();
        return lista;
    }

    public List<Clan> vratiListuClanova(Clan clan) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_CLANOVE);
        kz.setParametar(clan);

        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        if (!so.isUspesno()) {
            JOptionPane.showMessageDialog(null, so.getPoruka());
            return new ArrayList<>();
        }
        List<Clan> lista = (List<Clan>) so.getOdgovor();
        return lista;
    }

    public ServerskiOdgovor obrisiClana(Clan c) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRISI_CLANA);
        kz.setParametar(c);

        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor unesiUslugu(Usluga u) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.UNESI_USLUGU);
        kz.setParametar(u);

        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor izmeniUslugu(Usluga u) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_USLUGU);
        kz.setParametar(u);

        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor obrisiUslugu(Usluga u) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRISI_USLUGU);
        kz.setParametar(u);

        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor odgovoriNaZahteve(List<Zahtev> lista) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.ODGOVORI_NA_ZAHTEVE);
        kz.setParametar(lista);

        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so;
    }

    public String zavrsiSaRadom() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.KRAJ_RADA);
        
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        return so.getPoruka();
    }

}

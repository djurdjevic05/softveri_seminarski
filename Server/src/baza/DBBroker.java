/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.OpstiDomenskiObjekat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author USER
 */
public class DBBroker {

    private static DBBroker instance;

    private DBBroker() {
    }
    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public void insert(OpstiDomenskiObjekat odo) throws SQLException {
        String sql = "INSERT INTO " + odo.vratiNazivTabele() + "(" + odo.vratiNaziveKolona() + ")" + " VALUES (" + odo.vratiVrednostiZaUnos() + ")";
        System.out.println(sql);
        Statement s = Konekcija.getInstance().getConnection().createStatement();
        s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        if (odo.isAutoIncrement()) {
            ResultSet rs = s.getGeneratedKeys();
            if (rs.next()) {
                odo.setID(rs.getInt(1));
            }
        }
        s.close();
    }

    public void update(OpstiDomenskiObjekat odo) throws SQLException {
        String sql = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostiZaUpdate() + " WHERE " + odo.vratiWhereUslov();
        System.out.println(sql);
        Statement s = Konekcija.getInstance().getConnection().createStatement();
        s.executeUpdate(sql);
        s.close();
    }

    public void delete(OpstiDomenskiObjekat odo) throws SQLException {
        String sql = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiWhereUslov();
        System.out.println(sql);
        Statement s = Konekcija.getInstance().getConnection().createStatement();
        s.executeUpdate(sql);
        s.close();
    }

    public ResultSet select(OpstiDomenskiObjekat odo) throws SQLException {
        String sql = "SELECT " + odo.vratiKoloneZaSelektovanje() + " FROM " + odo.vratiNazivTabele() + " as " + odo.vratiAlijas()
                + odo.vratiUslovZaJoin() + odo.vratiFilterZaSelect() + odo.vratiGrupisanje();
        System.out.println(sql);
        Statement s = Konekcija.getInstance().getConnection().createStatement();
        ResultSet rs = s.executeQuery(sql);
        return rs;
    }
    /*public OpstiDomenskiObjekat find(OpstiDomenskiObjekat odo) throws SQLException{
        ResultSet rs = select(odo);
        List<OpstiDomenskiObjekat> lista = odo.ucitajListu(rs);
        return lista.get(0);
    }*/

    

}

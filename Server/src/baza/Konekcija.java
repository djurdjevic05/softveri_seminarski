/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import properties.UtilProperties;

/**
 *
 * @author USER
 */
public class Konekcija {

    private static Konekcija instance;
    private Connection connection;

    private Konekcija() throws SQLException {
        String url = UtilProperties.getInstance().vratiVrednost("url");
        String user = UtilProperties.getInstance().vratiVrednost("user");
        String pass = UtilProperties.getInstance().vratiVrednost("pass");
        connection = DriverManager.getConnection(url, user, pass);
        connection.setAutoCommit(false);

    }

    public static Konekcija getInstance() throws SQLException {
        if (instance == null) {
            instance = new Konekcija();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }
}

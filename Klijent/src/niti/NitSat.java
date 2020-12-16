/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author USER
 */
public class NitSat extends Thread{
    JLabel labela;

    public NitSat(JLabel labela) {
        this.labela = labela;
    }

    @Override
    public void run() {
        while(true){
            labela.setText(new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss").format(new Date()));
        }
    }
    
    
}

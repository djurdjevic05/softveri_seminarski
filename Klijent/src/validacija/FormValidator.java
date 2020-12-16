/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacija;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Miroslav
 */
public class FormValidator {
    private Border defaultBorder;
    private static FormValidator instance;
    String validationMessage = "";
    
    private FormValidator(){
    }

    public static FormValidator getInstance() {
        if(instance == null)
            instance = new FormValidator();
        return instance;
    }
    
    public boolean validateEmpty(JTextComponent... polja){
        boolean valid = true;
        int brojacLosih = 0;
        for (JTextComponent p : polja) {
            if("".equals(p.getText())){
                dodajListenerZaTekstPolje(p);
                p.setBorder(BorderFactory.createLineBorder(Color.red,3,true));
                brojacLosih++;
                valid = false;
            }
        }
        
        if(!valid)
         validationMessage =   brojacLosih==1 ? "Dato polje ne sme biti prazno": "Data polja ne smeju biti prazna";
        
        return valid;
    }
    public boolean validateComboSelection(JComboBox... combos){
        boolean valid = true;
        int brojacLosih = 0;
        for(JComboBox c : combos){
            if(c.getSelectedItem() == null){
                brojacLosih++;
                valid = false;
            }
        }
        if(!valid){
            validationMessage = brojacLosih==1 ? "Mora postojati selekcija u ComboBox-u!": "Mora postojati selekcija u svakom ComboBox-u";
        }
        return valid;
    }
    public boolean validateButtonGroupSelection(ButtonGroup... buttonGroups){
        boolean valid = true;
        int brojacLosih = 0;
        for(ButtonGroup bg : buttonGroups){
            if(bg.getSelection() == null){
                brojacLosih++;
                valid = false;
            }
        }
        if(!valid){
            validationMessage = brojacLosih==1 ? "Mora postojati selekcija u ButtonGroup-u!": "Mora postojati selekcija u svakom ButtonGroup-u";
        }
        return valid;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setDefaultBorder(Border defaultBorder) {
        this.defaultBorder = defaultBorder;
    }
    
    public void dodajListenerZaTekstPolje(JTextComponent polje){
        
        polje.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                String tekst = polje.getText();
                if(tekst.isEmpty()){
                    polje.setBorder(BorderFactory.createLineBorder(Color.red,3,true));
                }else{
                    polje.setBorder(defaultBorder);
                }
            }
        });
    }
    
}

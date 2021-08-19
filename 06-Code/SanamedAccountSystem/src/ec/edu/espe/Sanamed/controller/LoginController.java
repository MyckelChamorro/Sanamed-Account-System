/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Sanamed.controller;

import ec.edu.espe.Sanamed.view.LoginFrm;
import ec.edu.espe.Sanamed.view.MenuSanamed;
import ec.edu.espe.Sanamed.model.User;
import ec.edu.espe.Sanamed.model.UserJson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Esteban Chablay EMCL. Java ESPE-DCCO
 */
public class LoginController implements ActionListener {
    UserJson json = new UserJson();
    User objectUser = new User();
    LoginFrm vista = new LoginFrm();
    MenuSanamed m = new MenuSanamed();
    
    public LoginController(LoginFrm v){
        this.vista = v;
        this.vista.btnStart.addActionListener(this);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int verification = 0;
        if (e.getSource() == vista.btnStart){
            objectUser.setNameUser(vista.txtName.getText());
            objectUser.setPassword(vista.txtPassword.getText());
            verification=json.userVerification(objectUser.getNameUser(), objectUser.getPassword());
            if(verification == 1){
            m.setVisible(true);
            vista.setVisible(false);
            }
        }
    }
}

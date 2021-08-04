/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Sanamed.controller;

import ec.edu.espe.Sanamed.view.LoginFrm;
import ec.edu.espe.SanamedAccountSystem.model.User;
import ec.edu.espe.SanamedAccountSystem.model.UserJson;
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
    
    public LoginController(LoginFrm v){
        this.vista = v;
        this.vista.btnStart.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnStart){
            objectUser.setNameUser(vista.txtName.getText());
            objectUser.setPassword(vista.txtPassword.getText());
            json.userVerification(objectUser.getNameUser(), objectUser.getPassword());
        }
    }
}

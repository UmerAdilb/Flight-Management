package UI;

import Service.AuthenticationService;

import UI.admin.AdminUi;
import UI.user.UserUi;

import javax.swing.*;
import java.awt.*;

public class LoginUi {

    public LoginUi(){
        JFrame frame = new JFrame("Login");

        JLabel username = new JLabel("username");
        JTextField usernameTf = new JTextField(10);

        JLabel password = new JLabel("password");
        JTextField passwordTf = new JTextField(10);

        JLabel errorLabel = new JLabel();

        JButton login = new JButton();
        login.setBounds(200,300,150,30);
        login.setText("Login");

        JButton logout = new JButton();
        logout.setBounds(200,400,150,30);
        logout.setText("Close");

        login.addActionListener(btn->{
            String uname = usernameTf.getText();
            String pass = passwordTf.getText();
            if(AuthenticationService.authenticateAdmin(uname,pass)){
               new AdminUi();
                System.out.println("hello admin");
                frame.dispose();

                //for admin
            }else if (AuthenticationService.authenticateUser(uname,pass)){
               //for user

                new UserUi();
                System.out.println("hello user");
                frame.dispose();

            }
            else{
                errorLabel.setText("Your username or password is incorrect");
                errorLabel.setForeground(Color.RED);
            }
        });
        logout.addActionListener(el->{
            frame.dispose();
        });


        frame.add(username);
        frame.add(usernameTf);
        frame.add(password);
        frame.add(passwordTf);
        frame.add(login);
        frame.add(logout);
        frame.add(errorLabel);

        frame.setLayout(new FlowLayout(FlowLayout.CENTER,120,25));

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}

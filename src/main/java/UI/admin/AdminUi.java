package UI.admin;

import UI.LoginUi;

import javax.swing.*;
import java.awt.*;

public class AdminUi {

    public AdminUi(){
        JFrame frame = new JFrame("Admin Panel");
        JButton btnFlight = new JButton();
        btnFlight.setBounds(150,100,150,30);
        btnFlight.setFocusable(false);
        btnFlight.setText("Flight");

        JButton btnPlane = new JButton();
        btnPlane.setBounds(150,200,150,30);
        btnPlane.setFocusable(true);
        btnPlane.setText("Plane");

        JButton btnLogout = new JButton();
        btnLogout.setBounds(150,300,150,30);
        btnLogout.setFocusable(false);
        btnLogout.setText("Logout");

        frame.add(btnFlight);
        frame.add(btnPlane);
        frame.add(btnLogout);

//        frame.setLayout(new FlowLayout(FlowLayout.CENTER,120,25));
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        btnPlane.addActionListener(el->{
            frame.dispose();
            new PlaneUi();
        });
        btnFlight.addActionListener(el->{
            frame.dispose();
            new FlightUi();
        });
        btnLogout.addActionListener(el->{
            frame.dispose();
            new LoginUi();
        });

    }
}

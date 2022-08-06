package UI.admin;


import Service.PlaneService;
import domain.Aeroplane;

import javax.swing.*;
import java.awt.*;

public class EditPlaneForm {


    EditPlaneForm(Aeroplane aeroplane) {
        JFrame frame = new JFrame("Add Planes Panel");

        JLabel planeNameLb = new JLabel("Name");
        planeNameLb.setBounds(200, 60, 150, 100);
        JTextField planeNameTf = new JTextField();
        planeNameTf.setBounds(270, 100, 150, 20);
        planeNameTf.setText(aeroplane.getAeroplaneName());

        JLabel planeCapacityLb = new JLabel("Capacity");
        planeCapacityLb.setBounds(200, 110, 150, 100);
        JTextField planeCapacityTf = new JTextField();
        planeCapacityTf.setBounds(270, 150, 150, 20);
        planeCapacityTf.setText(aeroplane.getCapacity().toString());
        JLabel planeAirlineLb = new JLabel("Airline");
        planeAirlineLb.setBounds(200, 160, 150, 100);
        JTextField planeAirlineTf = new JTextField();
        planeAirlineTf.setBounds(270, 200, 150, 20);
planeAirlineTf.setText(aeroplane.getAirline());
        JButton btnEditPlane = new JButton();
        btnEditPlane.setBounds(200, 300, 100, 50);
        btnEditPlane.setText("Edit Plane");

        JButton backBtn = new JButton();
        backBtn.setBounds(300, 300, 100, 50);
        backBtn.setText("Back");


        frame.add(planeNameLb);
        frame.add(planeNameTf);
        frame.add(planeCapacityLb);
        frame.add(planeCapacityTf);
        frame.add(planeAirlineLb);
        frame.add(planeAirlineTf);
        frame.add(btnEditPlane);
        frame.add(backBtn);

        btnEditPlane.addActionListener(btn -> {
            String _name = planeNameTf.getText();
            Integer _capacity = Integer.valueOf(planeCapacityTf.getText());
            String _airline = planeAirlineTf.getText();
           Boolean edit=  PlaneService.PlaneEdit(_name,_capacity,_airline,aeroplane.getId());

            if (edit){ JOptionPane.showMessageDialog(frame,"Plane Edited");
         }else {
                JOptionPane.showMessageDialog(frame,"Plane Not Edited");
//
            }
              frame.dispose();
//            new PlaneUi();
        });

        backBtn.addActionListener(btn -> {
            frame.dispose();
            new PlaneUi();
        });


          frame.setLayout(new FlowLayout(FlowLayout.CENTER,120,25));
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}

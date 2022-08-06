package UI.admin;


import Service.PlaneService;
import domain.Aeroplane;

import javax.swing.*;
import java.util.ArrayList;

public class AddPlaneUi {
    //name capacity airline

    AddPlaneUi(){
        JFrame frame = new JFrame("Add Planes Panel");

        JLabel planeNameLb = new JLabel("Name");
        planeNameLb.setBounds(200,60,150,100);
        JTextField planeNameTf = new JTextField();
        planeNameTf.setBounds(270,100,150,20);

        JLabel planeCapacityLb = new JLabel("Capacity");
        planeCapacityLb.setBounds(200,110,150,100);
        JTextField planeCapacityTf = new JTextField();
        planeCapacityTf.setBounds(270,150,150,20);

        JLabel planeAirlineLb = new JLabel("Airline");
        planeAirlineLb.setBounds(200,160,150,100);
        JTextField planeAirlineTf = new JTextField();
        planeAirlineTf.setBounds(270,200,150,20);

        JButton addPlaneBtn = new JButton();
        addPlaneBtn.setBounds(200,300,100,50);
        addPlaneBtn.setText("Add Plane");

        JButton backBtn = new JButton();
        backBtn.setBounds(300,300,100,50);
        backBtn.setText("Back");


        frame.add(planeNameLb);
        frame.add(planeNameTf);
        frame.add(planeCapacityLb);
        frame.add(planeCapacityTf);
        frame.add(planeAirlineLb);
        frame.add(planeAirlineTf);
        frame.add(addPlaneBtn);
        frame.add(backBtn);

        addPlaneBtn.addActionListener(btn->{
            String _name = planeNameTf.getText();
            Integer _capacity = Integer.valueOf(planeCapacityTf.getText());
            String _airline = planeAirlineTf.getText();

            Boolean addplane =  PlaneService.addAeroplane(_name,_capacity,_airline);

            if(addplane){
                JOptionPane.showMessageDialog(frame,"Plane Added Succesfully");
            }else {
                JOptionPane.showMessageDialog(frame,"Aeroplane Name Already Exists");
            }

        });

        backBtn.addActionListener(btn->{
            frame.dispose();
            new PlaneUi();
        });


        //     frame.setLayout(new FlowLayout(FlowLayout.CENTER,120,25));
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
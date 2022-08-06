package UI.admin;

import Service.FlightService;
import Service.PlaneService;
import domain.Flight;

import javax.swing.*;

public class RemovePlaneUi {
    RemovePlaneUi(){

        JFrame frame = new JFrame("Remove PLane");

        JLabel flightNameLb = new JLabel("Enter the Plane ID to be Deleted ");
        flightNameLb.setBounds(180,60,250,120);
        JTextField planeNameTF = new JTextField();
        planeNameTF.setBounds(200,150,150,20);



        JButton btnDelete = new JButton();
        btnDelete.setBounds(190,300,90,40);
        btnDelete.setText("Delete");

        JButton backBtn = new JButton();
        backBtn.setBounds(290,300,90,40);
        backBtn.setText("Back");


        frame.add(flightNameLb);
        frame.add(planeNameTF);

        frame.add(btnDelete);
        frame.add(backBtn);

        btnDelete.addActionListener(btn->{
            Long planeID =Long.parseLong(planeNameTF.getText()) ;
            Boolean fl = PlaneService.DeletePlane(planeID);
            if (fl){
                JOptionPane.showMessageDialog(frame,"Aeroplane Deleted");

            }else{
                JOptionPane.showMessageDialog(frame,"Invalid Aeroplane ID given");

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

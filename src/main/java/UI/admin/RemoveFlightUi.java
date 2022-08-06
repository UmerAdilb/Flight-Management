package UI.admin;

import Service.FlightService;

import javax.swing.*;

public class RemoveFlightUi {
    RemoveFlightUi(){

        JFrame frame = new JFrame("Remove Flight");

        JLabel flightNameLb = new JLabel("Enter the Flight ID to be Deleted ");
        flightNameLb.setBounds(180,60,250,120);
        JTextField flightNameTF = new JTextField();
        flightNameTF.setBounds(200,150,150,20);



        JButton btnDelete = new JButton();
        btnDelete.setBounds(190,300,90,40);
        btnDelete.setText("Delete");

        JButton backBtn = new JButton();
        backBtn.setBounds(290,300,90,40);
        backBtn.setText("Back");


        frame.add(flightNameLb);
        frame.add(flightNameTF);

        frame.add(btnDelete);
        frame.add(backBtn);

        btnDelete.addActionListener(btn->{
            Long flightId =Long.parseLong(flightNameTF.getText()) ;
            Boolean fl = FlightService.DeleteFlight(flightId);
            if (fl){
                JOptionPane.showMessageDialog(frame,"Flight Deleted");

            }else{
                JOptionPane.showMessageDialog(frame,"Invalid Flight ID given");

            }
        });

        backBtn.addActionListener(btn->{
            frame.dispose();
            new FlightUi();
        });


        //     frame.setLayout(new FlowLayout(FlowLayout.CENTER,120,25));
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }


}

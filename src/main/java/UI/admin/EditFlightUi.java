package UI.admin;



import Service.FlightService;
import domain.Flight;

import javax.swing.*;

public class EditFlightUi {
    EditFlightUi(){

        JFrame frame = new JFrame("Edit Flight Panel");

        JLabel flightNameLb = new JLabel("Enter the Flight Number to be Edit ");
        flightNameLb.setBounds(180,60,250,120);
        JTextField flightNameTf = new JTextField();
        flightNameTf.setBounds(200,150,150,20);



        JButton btnNext = new JButton();
        btnNext.setBounds(190,300,90,40);
        btnNext.setText("Next");

        JButton backBtn = new JButton();
        backBtn.setBounds(290,300,90,40);
        backBtn.setText("Back");


        frame.add(flightNameLb);
        frame.add(flightNameTf);

        frame.add(btnNext);
        frame.add(backBtn);

        btnNext.addActionListener(btn->{
            String flightNumber = flightNameTf.getText();
            Flight fl = FlightService.searchFlightbyNumber(flightNumber);
            if (fl != null){
                EditFlightForm editflightform= new EditFlightForm(fl);
                frame.dispose();
            }else{
                JOptionPane.showMessageDialog(frame,"Invalid Input");

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


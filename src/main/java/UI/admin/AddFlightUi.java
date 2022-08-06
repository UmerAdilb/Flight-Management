package UI.admin;


import Service.FlightService;

import javax.swing.*;
import java.time.LocalDate;

public class AddFlightUi {

    AddFlightUi(){
        JFrame frame = new JFrame("Add Flight Panel");

        JLabel planeName = new JLabel("Plane ID");
        planeName.setBounds(150,60,150,100);
        JTextField planeNameTF = new JTextField();
        planeNameTF.setBounds(270,100,150,20);



        JLabel flightNumberLb = new JLabel("Flight Number");
        flightNumberLb.setBounds(150,110,150,100);
        JTextField flightNumberTf = new JTextField();
        flightNumberTf.setBounds(270,150,150,20);

        JLabel flightDateLb = new JLabel("Date");
        flightDateLb.setBounds(150,160,150,100);
        JTextField flightDateTf = new JTextField();
        flightDateTf.setBounds(270,200,150,20);
        flightDateTf.setText("YYYY-mm-dd");


        JLabel flightSourceLb = new JLabel("Source");
        flightSourceLb.setBounds(150,210,150,100);
        JTextField flightSourceTf = new JTextField();
        flightSourceTf.setBounds(270,250,150,20);

        JLabel flightDestinationLb = new JLabel("Destination");
        flightDestinationLb.setBounds(150,260,150,100);
        JTextField flightDestinationTf = new JTextField();
        flightDestinationTf.setBounds(270,300,150,20);

        JLabel flightFareLb = new JLabel("Fare");
        flightFareLb.setBounds(150,310,150,100);
        JTextField flightFareTf = new JTextField();
        flightFareTf.setBounds(270,350,150,20);

        JButton addFlightBtn = new JButton();
        addFlightBtn.setBounds(200,400,100,50);
        addFlightBtn.setText("Add Flight");

        JButton backFlightBtn = new JButton();
        backFlightBtn.setBounds(300,400,100,50);
        backFlightBtn.setText("Back");

frame.add(planeName);
frame.add(planeNameTF);
        frame.add(flightNumberLb);
        frame.add(flightNumberTf);
        frame.add(flightDateLb);
        frame.add(flightDateTf);
        frame.add(flightSourceLb);
        frame.add(flightSourceTf);
        frame.add(flightDestinationLb);
        frame.add(flightDestinationTf);
        frame.add(flightFareLb);
        frame.add(flightFareTf);
        frame.add(addFlightBtn);
        frame.add(backFlightBtn);
        addFlightBtn.addActionListener(fl->{


            Long aeroplane_id = Long.parseLong(planeNameTF.getText());
            String flight_number = flightNumberTf.getText();
            LocalDate flight_date = LocalDate.parse(flightDateTf.getText());
            String src = flightSourceTf.getText();
            String des = flightDestinationTf.getText();
            Double fare =  Double.parseDouble(flightFareTf.getText()) ;
          Boolean addFlight =  FlightService.addFlightIntoPlane(flight_number,flight_date,src,des,fare,aeroplane_id);
            if(addFlight){
                JOptionPane.showMessageDialog(frame,"Flight Added Succesfully");
            }else {
                JOptionPane.showMessageDialog(frame,"Flight not Added Due to an Invalid field");
            }

        });




        backFlightBtn.addActionListener(el->{
            frame.dispose();
            new FlightUi();
        });

        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }}
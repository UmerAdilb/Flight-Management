package UI.admin;



import Service.FlightService;
import Service.PlaneService;
import domain.Flight;

import javax.swing.*;
import java.time.LocalDate;

public class EditFlightForm {


    EditFlightForm(Flight flight){

    JFrame frame = new JFrame("Edit Flight Panel");



    JLabel flightNumberLb = new JLabel("Flight Number");
        flightNumberLb.setBounds(150,50,150,100);
    JTextField flightNumberTf = new JTextField();
        flightNumberTf.setBounds(270,90,150,20);
flightNumberTf.setText(flight.getFlightNumber());
    JLabel flightDateLb = new JLabel("Date");
        flightDateLb.setBounds(150,100,150,100);

    JTextField flightDateTf = new JTextField();
        flightDateTf.setBounds(270,140,150,20);
        flightDateTf.setText(flight.getDate().toString());


    JLabel flightSourceLb = new JLabel("Source");
        flightSourceLb.setBounds(150,150,150,100);
    JTextField flightSourceTf = new JTextField();
        flightSourceTf.setBounds(270,190,150,20);
flightSourceTf.setText(flight.getSource());

    JLabel flightDestinationLb = new JLabel("Destination");
        flightDestinationLb.setBounds(150,200,150,100);
    JTextField flightDestinationTf = new JTextField();
        flightDestinationTf.setBounds(270,240,150,20);
flightDestinationTf.setText(flight.getDestination());


    JLabel flightFareLb = new JLabel("Fare");
        flightFareLb.setBounds(150,250,150,100);
    JTextField flightFareTf = new JTextField();
        flightFareTf.setBounds(270,290,150,20);
flightFareTf.setText(flight.getFare().toString());

        JLabel AeroplaneId= new JLabel("Aeroplane Id");
        AeroplaneId.setBounds(150,300,150,100);
        JTextField AeroplaneIdTf = new JTextField();
        AeroplaneIdTf.setBounds(270,340,150,20);
        AeroplaneIdTf.setText(flight.getAeroplaneId().toString());



    JButton editFlightBtn = new JButton();
        editFlightBtn.setBounds(180,420,100,50);
        editFlightBtn.setText("Edit Flight");

    JButton backFlightBtn = new JButton();
        backFlightBtn.setBounds(320,420,100,50);
        backFlightBtn.setText("Back");


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
        frame.add(AeroplaneId);
        frame.add(AeroplaneIdTf);
        frame.add(editFlightBtn);
        frame.add(backFlightBtn);
        editFlightBtn.addActionListener(fl->{



        String flight_number = flightNumberTf.getText();
        LocalDate flight_date = LocalDate.parse(flightDateTf.getText());
        String src = flightSourceTf.getText();
        String des = flightDestinationTf.getText();
        Double fare =  Double.parseDouble(flightFareTf.getText()) ;
        Long aeroId = Long.parseLong(AeroplaneIdTf.getText());
      Boolean edit =       FlightService.FlightEdit( flight.getId(),flight_number,src,des,flight_date,fare,aeroId);
if (edit){
    JOptionPane.showMessageDialog(frame,"Flight Updated Succesfully");
}else {
    JOptionPane.showMessageDialog(frame,"File Not Updated");
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
}
}

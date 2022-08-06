package UI.user;



import Service.FlightService;

import javax.swing.*;
import java.awt.*;

public class PassengerInquiry {
    public PassengerInquiry(){
        JFrame f=new JFrame("Passenger Inquiry");
        Container c = f.getContentPane();

        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();

        panel1.setLayout(null);
        panel2.setLayout(null);

        panel1.setBackground(Color.lightGray);
        panel1.setBounds(10,10,800,100);
        panel2.setBounds(10,150,800,700);


        JTextField flightNumber = new JTextField(10);
        flightNumber.setText("Flight Number");
        flightNumber.setBounds(20,10,150,30);


        JButton search = new JButton("Search");
        search.setBounds(400,10,150,30);

        JButton back = new JButton("Back");
        back.setBounds(600,10,150,30);

        back.addActionListener(bk->{
            f.dispose();

            new UserUi();
        });

        panel1.add(flightNumber);
        panel1.add(search);
        panel1.add(back);


        search.addActionListener(s->{
            String column[]={"Name","Contact","Address","Airline","Flight Name","Date","Source","Destination","Fare"};
           String data[][] = FlightService.getAllPassengerByFlightNumberJTable(column.length,flightNumber.getText());


            JTable jt=new JTable(data,column);
            JScrollPane sp=new JScrollPane(jt);
            sp.setBounds(0,0,800,700);
            panel2.add(sp);
        });

        c.add(panel1);
        c.add(panel2);

        f.setLayout(null);
        f.setSize(1000,1000);
        f.setVisible(true);

        f.setLocationRelativeTo(null);


    }

}

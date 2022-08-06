package UI.user;

import UI.LoginUi;

import javax.swing.*;

public class UserUi {

    public UserUi(){
        JFrame frame = new JFrame("User Panel");
        JButton btnLookupFlight = new JButton();
        btnLookupFlight.setBounds(100,100,250,30);
        btnLookupFlight.setFocusable(false);
        btnLookupFlight.setText("Lookup Flights");



        JButton btnBookPassenger = new JButton();
        btnBookPassenger.setBounds(100,200,250,30);
        btnBookPassenger.setFocusable(false);
        btnBookPassenger.setText("Book Passenger");

        JButton btnPassengerInquiry = new JButton();
        btnPassengerInquiry.setBounds(100,300,250,30);
        btnPassengerInquiry.setFocusable(false);
        btnPassengerInquiry.setText("Passenger Inquiry");
        JButton btnLogout = new JButton();
        btnLogout.setBounds(150,400,150,30);
        btnLogout.setFocusable(false);
        btnLogout.setText("Logout");


        frame.add(btnLookupFlight);
        frame.add(btnBookPassenger);
        frame.add(btnPassengerInquiry);
frame.add(btnLogout);
        btnLookupFlight.addActionListener(btn->{
            frame.dispose();
            new LookUpUi();
        });
        btnBookPassenger.addActionListener(btn->{
            frame.dispose();
            new BookPassenger();
        });
        btnPassengerInquiry.addActionListener(btn->{
            frame.dispose();
            new PassengerInquiry();
        });
        btnLogout.addActionListener(el->{frame.dispose();
        new LoginUi();
        });


        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}

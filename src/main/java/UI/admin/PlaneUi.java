package UI.admin;




import Service.PlaneService;

import javax.swing.*;
import java.awt.*;

public class PlaneUi {

    PlaneUi(){
        JFrame frame = new JFrame("All Planes Panel");


        JPanel panelBtn = new JPanel();
        JPanel panelView = new JPanel();

        String column[]={"Id","Name","Capacity","Airline"};
        String data[][] = PlaneService.getAllAirlineForJTable(column.length);


        JTable tbl=new JTable(data,column);
        //  JScrollPane scrollPane = new JScrollPane(tbl);

        panelView.setLayout(new BorderLayout());
        panelBtn.setBackground(Color.gray);
        frame.getContentPane().add(panelView);
        frame.getContentPane().add(panelBtn);

        JScrollPane sp1=new JScrollPane(tbl);
        panelView.add(sp1);
        panelView.add(sp1,BorderLayout.CENTER);
        panelView.setBounds(0,0,600,500);
        panelBtn.setBounds(20,550,500,100);

        JButton btnAddPlane = new JButton();
        btnAddPlane.setBounds(20,20,150,30);
        btnAddPlane.setFocusable(false);
        btnAddPlane.setText("Add");
        JButton btnEditPlane = new JButton();
        btnEditPlane.setBounds(40,20,150,30);
        btnEditPlane.setFocusable(false);
        btnEditPlane.setText("Edit");
        JButton btnDeletePlane = new JButton();
        btnDeletePlane.setBounds(60,20,150,30);
        btnDeletePlane.setFocusable(false);
        btnDeletePlane.setText("Delete");
        JButton btnBackPlane = new JButton();
        btnBackPlane.setBounds(80,20,150,30);
        btnBackPlane.setFocusable(false);
        btnBackPlane.setText("Back");

        panelBtn.add(btnAddPlane);
        panelBtn.add(btnEditPlane);
        panelBtn.add(btnDeletePlane);
        panelBtn.add(btnBackPlane);

        btnEditPlane.addActionListener(fl->{
            frame.dispose();
            new EditPlaneUi();
        });

        btnAddPlane.addActionListener(btn->{
            frame.dispose();
            new AddPlaneUi();
        });

        btnBackPlane.addActionListener(btn->{
            frame.dispose();
            new AdminUi();
        });
        btnDeletePlane.addActionListener(fl->{
            frame.dispose();
            new RemovePlaneUi();
        });

        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        panelBtn.setVisible(true);
        panelView.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}

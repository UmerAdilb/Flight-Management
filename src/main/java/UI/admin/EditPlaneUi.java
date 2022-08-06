package UI.admin;



import Service.PlaneService;
import domain.Aeroplane;

import javax.swing.*;

public class EditPlaneUi {
    EditPlaneUi(){
        JFrame frame = new JFrame("Add Planes Panel");

        JLabel planeNameLb = new JLabel("Enter the Plane Name to be Edit ");
        planeNameLb.setBounds(180,60,250,120);
        JTextField planeNameTf = new JTextField();
        planeNameTf.setBounds(200,150,150,20);



        JButton btnNext = new JButton();
        btnNext.setBounds(190,300,90,40);
        btnNext.setText("Next");

        JButton backBtn = new JButton();
        backBtn.setBounds(290,300,90,40);
        backBtn.setText("Back");


        frame.add(planeNameLb);
        frame.add(planeNameTf);

        frame.add(btnNext);
        frame.add(backBtn);

        btnNext.addActionListener(btn->{
String planeName = planeNameTf.getText();

            Aeroplane aero = PlaneService.searchAeroplane(planeName);
if (aero != null){
    EditPlaneForm editplaneforme= new EditPlaneForm(aero);
    frame.dispose();
}else{

        JOptionPane.showMessageDialog(frame,"No Aeroplane Exists with this name");

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

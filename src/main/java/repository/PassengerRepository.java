package repository;

import domain.Flight;
import domain.Passengerinquiry;
import domain.Pessanger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PassengerRepository extends BaseConnection{

    public Boolean AddPassenger(Pessanger passanger){
        try {
            if(con.isClosed()){
                openConnection();
            }
            PreparedStatement ps = con.prepareStatement(
                    "insert into passenger (name,address,contact,flight_id) values(?, ?, ?, ?);");
            ps.setString(1,passanger.getName());
            ps.setString(2,passanger.getContact());
            ps.setString(3,passanger.getAddress());
            ps.setInt(4,(passanger.getFlightId()).intValue());;
            int i=ps.executeUpdate();
            System.out.println(i+" records inserted");
return  true;
        }catch (Exception  e){
            System.out.println(e);
        }
    return  false;}


    public List<Passengerinquiry> getPassengerForInquiry(String contact) {
        List<Passengerinquiry> passengerList = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("\n" +
                    "select p.name,p.address,p.contact,a.airline,f.flight_name,f.flight_date,f.flight_source,f.flight_destination,f.fare from passenger p inner join \n" +
                    "flight f on p.flight_id = f.id inner join aeroplane a on f.aeroplane_id = a.id where p.contact ='"+contact+ "'; ");
            while (rs.next()){
                Passengerinquiry pass = new Passengerinquiry();
                pass.populate(rs);
                passengerList.add(pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

return passengerList;
    }

    }

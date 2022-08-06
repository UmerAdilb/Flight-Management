package repository;

import domain.Aeroplane;
import domain.Flight;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaneRepository extends BaseConnection{
    public List<Aeroplane> GetAllPlanes(){
        List<Aeroplane> aerolist = new ArrayList<>();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from aeroplane");

            while (rs.next()){
                Aeroplane aeroplane = new Aeroplane();
                aeroplane.populate(rs);
                aerolist.add(aeroplane);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return aerolist;
    }

    public void addplane(Aeroplane aeroplane) {
        try {
            if(con.isClosed()){
                openConnection();
            }
            PreparedStatement ps = con.prepareStatement(
                    "insert into aeroplane (aeroplane_name,capacity,airline) values(?, ?, ?);");
            ps.setString(1,aeroplane.getAeroplaneName());
            ps.setString(2,aeroplane.getCapacity().toString());
            ps.setString(3,aeroplane.getAirline());
            int i=ps.executeUpdate();
            System.out.println(i+" records inserted");

        }catch (Exception  e){
            System.out.println(e);
        }
    }

    public Aeroplane getPlanesthroughName(String aeroplaneName){

        Aeroplane aero = new Aeroplane();
        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from aeroplane where aeroplane_name = '"+aeroplaneName+"'");

            while (rs.next()){

                aero.populate(rs);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return aero;
    }

    public Boolean UpdatePlane(String name,Integer capacity, String airline, Long id){

        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();

            st.executeUpdate("update aeroplane set aeroplane_name = '"+name+"', capacity = "+capacity+", airline = '"+airline+"' where id = "+id+" ");

return true;
        }catch (Exception e){
            e.printStackTrace();}
   return false; }

    public Boolean deletePlaneThroughID(Long planeId) {
        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();

            st.executeUpdate("delete from aeroplane where id ="+planeId+"" );

            return true;
        }catch (Exception e){
            e.printStackTrace();}
        return false; }



    }
//    public Aeroplane getPlanesthroughId(Long id){
//
//        Aeroplane aero = new Aeroplane();
//        try{
//            if(con.isClosed()){
//                openConnection();
//            }
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select * from aeroplane where id = "+id+"");
//
//            while (rs.next()){
//
//                aero.populate(rs);
//
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return aero;
//    }





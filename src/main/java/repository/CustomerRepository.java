package repository;

import domain.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository extends BaseConnection {

    public List<Customer> getAll(){

       List<Customer> customerList = new ArrayList<>();
        try{
            if(con.isClosed()){
                openConnection();
            }
           Statement st =  con.createStatement();
           ResultSet rs = st.executeQuery("select * from customer");
           while (rs.next()){
               Customer customer = new Customer();
               customer.populate(rs);
               customerList.add(customer);
           }

       }catch (Exception e){
           System.out.println(e);
       }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return customerList;
    }

    public Customer saveCustomer(Customer customer){
        try {
            if(con.isClosed()){
                openConnection();
            }
            PreparedStatement ps = con.prepareStatement(
                    "insert into customer(name,contact,nic) values(?,?,?)");
            ps.setString(1,customer.getName());
            ps.setString(2,customer.getContact());
            ps.setString(3,"1234");
            int i=ps.executeUpdate();
            System.out.println(i+" records inserted");

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return customer;
    }
}

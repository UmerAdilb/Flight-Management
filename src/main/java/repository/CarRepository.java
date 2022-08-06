package repository;

import domain.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarRepository extends BaseConnection implements ICarRepository{



    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from car");
            while (rs.next()){
               Integer id = Integer.valueOf(rs.getString("id"));
               String name = rs.getString("name");
               String color = rs.getString("color");

               cars.add(new Car(id,name,color));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return cars;
    }

    @Override
    public Car save(Car c) {
        return null;
    }

    @Override
    public Car update(Car c) {
        return null;
    }
}

package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Aeroplane {
  private Long id;
  private String aeroplaneName;
  private Integer capacity;
  private String airline;

    public Aeroplane(String aeroplaneName, Integer capacity, String airline) {
        this.aeroplaneName = aeroplaneName;
        this.capacity = capacity;
        this.airline = airline;
    }

    public Aeroplane(Long id, String aeroplaneName, Integer capacity, String airline, List<Flight> flights) {
        this.id = id;
        this.aeroplaneName = aeroplaneName;
        this.capacity = capacity;
        this.airline = airline;
        this.flights = flights;
    }

    public Aeroplane() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAeroplaneName() {
        return aeroplaneName;
    }

    public void setAeroplaneName(String aeroplaneName) {
        this.aeroplaneName = aeroplaneName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    private List<Flight> flights = new ArrayList<>();


    @Override
    public String toString() {
        return "Aeroplane{" +
                "id=" + id +
                ", aeroplaneName='" + aeroplaneName + '\'' +
                ", capacity=" + capacity +
                ", airline='" + airline + '\'' +
                ", flights=" + flights +
                '}';
    }

    public void populate(ResultSet rs) throws SQLException {

        this.setId(Long.parseLong(rs.getString("id")));
        this.setAeroplaneName(rs.getString("aeroplane_name"));
        this.setCapacity(Integer.parseInt(rs.getString("capacity")));
        this.setAirline(rs.getString("airline"));
    }
}

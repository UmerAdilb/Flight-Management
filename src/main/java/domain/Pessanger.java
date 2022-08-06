package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Pessanger {

    private Long id;
    private String name;
    private String contact;
    private String address;
    private Long flightId;
private String flightName;

    public Pessanger(Long id, String name, String contact, String address, String flightName) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        flightName = flightName;
    }

    public Pessanger(Long id, String name, String contact, String address, Long flightId) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.flightId = flightId;
    }

    public Pessanger(String name, String contact, String address, Long flightId) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.flightId = flightId;
    }
    public Pessanger(){

    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return "Pessanger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", flightName='" + flightName + '\'' +
                '}';
    }

    public void populate(ResultSet rs )throws SQLException {
        this.setId(Long.parseLong(rs.getString("id")));
        this.setName(rs.getString("name"));
        this.setAddress(rs.getString("address"));
        this.setContact(rs.getString("contact"));
        this.setFlightName(rs.getString("flight_name"));


    }
}

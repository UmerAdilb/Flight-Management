package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Passengerinquiry {
    private String name;
    private String contact;
    private String address;
    private String airline;
    private String flightName;
    private LocalDate flightDate;
    private String source;
    private String destination;
    private Double fare;

    public Passengerinquiry() {
    }

    public Passengerinquiry(String name, String contact, String address, String airline, String flightName, LocalDate flightDate, String source, String destination, Double fare) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.airline = airline;
        this.flightName = flightName;
        this.flightDate = flightDate;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
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

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Passengerinquiry{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", airline='" + airline + '\'' +
                ", flightName='" + flightName + '\'' +
                ", flightDate=" + flightDate +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", fare=" + fare +
                '}';
    }

    public void populate(ResultSet rs) throws SQLException {
        this.setName(rs.getString("name"));
        this.setContact(rs.getString("contact"));
        this.setAddress(rs.getString("address"));
        this.setAirline(rs.getString("airline"));
        this.setFlightName(rs.getString("flight_name"));
        this.setFlightDate(LocalDate.parse(rs.getString("flight_date")));
        this.setSource(rs.getString("flight_source"));
        this.setDestination(rs.getString("flight_destination"));
        this.setFare(Double.parseDouble(rs.getString("fare")));
    }
}

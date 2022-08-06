package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
    private Integer id;
    private String name;
    private String contact;
    private Integer address_id;

    public Customer() {
    }

    public Customer(Integer id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    public void populate(ResultSet rs) throws SQLException {
        this.setId(Integer.valueOf(rs.getString("id")));
        this.setName(rs.getString("name"));
        this.setContact(rs.getString("contact"));
    }
}

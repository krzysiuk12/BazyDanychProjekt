package pl.edu.agh.tutorial.mappings.associations.unidirectional.onetomany.xml;

import java.util.Set;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private Set<Order> orders;

    public Customer() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Order> getOrders() {
        return orders;
    }
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}

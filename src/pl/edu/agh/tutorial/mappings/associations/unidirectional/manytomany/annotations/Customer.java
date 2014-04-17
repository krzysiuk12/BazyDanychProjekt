package pl.edu.agh.tutorial.mappings.associations.unidirectional.manytomany.annotations;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Krzysiu on 2014-04-17.
 */
@Entity
@Table(name = "Customers")
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private Set<Order> orders;

    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "CustomersOrdersJoinTable",
        joinColumns = { @JoinColumn(name = "CustomerId", nullable = false, updatable = false)},
        inverseJoinColumns = { @JoinColumn(name = "OrderId", nullable = false, updatable = false)})
    public Set<Order> getOrders() {
        return orders;
    }
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

}

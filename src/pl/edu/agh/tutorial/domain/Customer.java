package pl.edu.agh.tutorial.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Krzysiu on 2014-04-15.
 */
@Entity
@Table(name = "Customers")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Customer {

    protected Long id;
    protected Address address;
    protected Set<Order> orders;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer_PK_Sequence")
    @SequenceGenerator(name = "Customer_PK_Sequence", sequenceName = "Customer_PK_Sequence")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId", nullable = false)
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    public Set<Order> getOrders() {
        return orders;
    }
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

}

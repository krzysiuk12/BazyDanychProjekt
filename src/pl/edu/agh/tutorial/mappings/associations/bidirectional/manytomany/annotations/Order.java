package pl.edu.agh.tutorial.mappings.associations.bidirectional.manytomany.annotations;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Krzysiu on 2014-04-17.
 */
@Entity
@Table(name = "Orders")
public class Order {

    private Long id;
    private Set<Customer> customers;

    private int productAmount;
    private float cost;

    public Order() {
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
    @Column(name = "productAmount")
    public int getProductAmount() {
        return productAmount;
    }
    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    @Basic
    @Column(name = "cost")
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "orders")
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}

package pl.edu.agh.tutorial.mappings.associations.unidirectional.onetomany.annotations;

import javax.persistence.*;

/**
 * Created by Krzysiu on 2014-04-16.
 */
@Entity
@Table(name = "Orders")
public class Order {

    private Long id;
    private Customer customer;
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

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

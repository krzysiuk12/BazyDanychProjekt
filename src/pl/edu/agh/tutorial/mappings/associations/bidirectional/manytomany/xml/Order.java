package pl.edu.agh.tutorial.mappings.associations.bidirectional.manytomany.xml;

import java.util.Set;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public class Order {

    private Long id;
    private Set<Customer> customers;

    private int productAmount;
    private float cost;

    public Order() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getProductAmount() {
        return productAmount;
    }
    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}

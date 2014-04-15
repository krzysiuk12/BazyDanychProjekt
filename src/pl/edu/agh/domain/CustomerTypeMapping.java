package pl.edu.agh.domain;

import javax.persistence.*;

/**
 * Created by Krzysiu on 2014-04-15.
 */
@Entity
@Table(name = "CustomerTypeMappings")
public class CustomerTypeMapping {

    private Long id;
    private Customer customer;
    private CustomerDemographic customerDemographic;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CustomerTypeMapping_PK_Sequence")
    @SequenceGenerator(name = "CustomerTypeMapping_PK_Sequence", sequenceName = "CustomerTypeMapping_PK_Sequence")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer cutomer) {
        this.customer = cutomer;
    }

    @ManyToOne
    @JoinColumn(name = "customerDemographicId", nullable = false)
    public CustomerDemographic getCustomerDemographic() {
        return customerDemographic;
    }
    public void setCustomerDemographic(CustomerDemographic customerDemographic) {
        this.customerDemographic = customerDemographic;
    }
}

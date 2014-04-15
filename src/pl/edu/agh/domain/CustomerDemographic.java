package pl.edu.agh.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Krzysiu on 2014-04-15.
 */
@Entity
@Table(name = "CustomerDemographics")
public class CustomerDemographic {

    private Long id;
    private String description;
    private Set<CustomerTypeMapping> customers;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CustomerDemographic_PK_Sequence")
    @SequenceGenerator(name = "CustomerDemographic_PK_Sequence", sequenceName = "CustomerDemographic_PK_Sequence")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerDemographic", fetch = FetchType.LAZY)
    public Set<CustomerTypeMapping> getCustomers() {
        return customers;
    }
    public void setCustomers(Set<CustomerTypeMapping> customers) {
        this.customers = customers;
    }
}

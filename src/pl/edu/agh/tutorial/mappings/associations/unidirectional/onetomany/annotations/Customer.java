package pl.edu.agh.tutorial.mappings.associations.unidirectional.onetomany.annotations;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Krzysiu on 2014-04-16.
 */
@Entity
@Table(name = "Customers")
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;

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
}

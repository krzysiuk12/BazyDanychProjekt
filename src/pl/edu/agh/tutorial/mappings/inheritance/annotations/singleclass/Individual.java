package pl.edu.agh.tutorial.mappings.inheritance.annotations.singleclass;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Krzysiu on 2014-04-17.
 */
@Entity
@DiscriminatorValue(value = "I")
public class Individual extends Customer {

    private String firstName;
    private String lastName;

    public Individual() {
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

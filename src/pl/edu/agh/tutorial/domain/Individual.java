package pl.edu.agh.tutorial.domain;

import javax.persistence.*;

/**
 * Created by Krzysiu on 2014-04-29.
 */
@Entity
@Table(name = "Individuals")
public class Individual extends Customer {

    private String firstName;
    private String lastName;

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

    @Override
    public String toString() {
        return "Individual{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

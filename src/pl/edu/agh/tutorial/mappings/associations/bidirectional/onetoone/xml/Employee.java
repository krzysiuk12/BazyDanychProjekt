package pl.edu.agh.tutorial.mappings.associations.bidirectional.onetoone.xml;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Krzysiu on 2014-04-17.
 */
@Entity
@Table(name = "Employees")
public class Employee {

    private Long id;
    private String lastName;
    private String firstName;
    private String title;
    private String titleOfCourtesy;
    private Date birthdate;
    private Date hiredate;
    private Address address;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lastName", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "firstName", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "titleOfCourtensy")
    public String getTitleOfCourtesy() {
        return titleOfCourtesy;
    }
    public void setTitleOfCourtesy(String titleOfCourtesy) {
        this.titleOfCourtesy = titleOfCourtesy;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday", length = 15)
    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "hiredate", length = 15)
    public Date getHiredate() {
        return hiredate;
    }
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AddressId")
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}

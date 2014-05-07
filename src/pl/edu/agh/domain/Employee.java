package pl.edu.agh.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Krzysiu on 2014-04-15.
 */
@Entity
@Table(name = "Employees")
public class Employee {

    private Long id;

    private Employee reportToEmployee;
    private Address address;
    private Set<Employee> subordinateEmployees;
    private Set<EmployeeTerritory> employeeTerritories;
    private Set<Order> ordersResponsibleFor;

    private String lastName;
    private String firstName;
    private String title;
    private String titleOfCourtesy;
    private Date birthdate;
    private Date hiredate;
    private String homephone;
    private String extension;
    private byte[] photo;
    private String notes;
    private String photoPath;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Employee_PK_Sequence")
    @SequenceGenerator(name = "Employee_PK_Sequence", sequenceName = "Employee_PK_Sequence")
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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId", nullable = false)
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    @Basic
    @Column(name = "homephone")
    public String getHomephone() {
        return homephone;
    }
    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    @Basic
    @Column(name = "extension")
    public String getExtension() {
        return extension;
    }
    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Lob
    @Column(name = "photo")
    public byte[] getPhoto() {
        return photo;
    }
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "photoPath")
    public String getPhotoPath() {
        return photoPath;
    }
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @ManyToOne
    @JoinColumn(name = "reportsToEmployeeId")
    public Employee getReportToEmployee() {
        return reportToEmployee;
    }
    public void setReportToEmployee(Employee reportToEmployee) {
        this.reportToEmployee = reportToEmployee;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportToEmployee", fetch = FetchType.LAZY)
    public Set<Employee> getSubordinateEmployees() {
        return subordinateEmployees;
    }
    public void setSubordinateEmployees(Set<Employee> subordinateEmployees) {
        this.subordinateEmployees = subordinateEmployees;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    public Set<Order> getOrdersResponsibleFor() {
        return ordersResponsibleFor;
    }
    public void setOrdersResponsibleFor(Set<Order> ordersResponsibleFor) {
        this.ordersResponsibleFor = ordersResponsibleFor;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    public Set<EmployeeTerritory> getEmployeeTerritories() {
        return employeeTerritories;
    }
    public void setEmployeeTerritories(Set<EmployeeTerritory> employeeTerritories) {
        this.employeeTerritories = employeeTerritories;
    }
}

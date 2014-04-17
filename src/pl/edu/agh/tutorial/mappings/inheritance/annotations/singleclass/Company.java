package pl.edu.agh.tutorial.mappings.inheritance.annotations.singleclass;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Krzysiu on 2014-04-17.
 */
@Entity
@DiscriminatorValue(value = "C")
public class Company extends Customer {

    private String companyName;
    private String phone;
    private String fax;

    public Company() {
    }

    @Basic
    @Column(name = "companyName")
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "fax")
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
}

package pl.edu.agh.tutorial.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Krzysiu on 2014-04-29.
 */
@Entity
@Table(name = "Company")
public class Company extends Customer {

    private String companyName;
    private String phone;

    @Basic
    @Column(name = "companyName", nullable = false)
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

}

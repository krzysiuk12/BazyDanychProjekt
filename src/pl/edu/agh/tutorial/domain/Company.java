package pl.edu.agh.tutorial.domain;

import javax.persistence.*;

/**
 * Created by Krzysiu on 2014-04-29.
 */
@Entity
@Table(name = "Companies")
public class Company extends Customer {

    private String companyName;
    private String phone;

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

}

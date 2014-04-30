package pl.edu.agh.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Krzysiu on 2014-04-29.
 */
@Entity
@Table(name = "Company")
public class Company extends Customer {

    private String companyName;
    private String contactName;
    private String contactTitle;
    private String phone;
    private String fax;

    @Basic
    @Column(name = "companyName", nullable = false)
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "contactName")
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Basic
    @Column(name = "contactTitle")
    public String getContactTitle() {
        return contactTitle;
    }
    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
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

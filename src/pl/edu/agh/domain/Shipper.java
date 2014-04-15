package pl.edu.agh.domain;

import javax.persistence.*;

/**
 * Created by Krzysiu on 2014-04-15.
 */
@Entity
@Table(name = "Shippers")
public class Shipper {

    private Long id;
    private String companyName;
    private String phone;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Shipper_PK_Sequence")
    @SequenceGenerator(name = "Shipper_PK_Sequence", sequenceName = "Shipper_PK_Sequence")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

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

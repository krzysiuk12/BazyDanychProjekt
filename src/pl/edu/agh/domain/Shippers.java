package pl.edu.agh.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Krzysiu on 2014-04-02.
 */
@Entity
public class Shippers {
    private int shipperid;
    private String companyname;
    private String phone;
//    private Collection<Orders> ordersesByShipperid;

    @Id
    @Column(name = "shipperid")
    public int getShipperid() {
        return shipperid;
    }

    public void setShipperid(int shipperid) {
        this.shipperid = shipperid;
    }

    @Basic
    @Column(name = "companyname")
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shippers shippers = (Shippers) o;

        if (shipperid != shippers.shipperid) return false;
        if (companyname != null ? !companyname.equals(shippers.companyname) : shippers.companyname != null)
            return false;
        if (phone != null ? !phone.equals(shippers.phone) : shippers.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shipperid;
        result = 31 * result + (companyname != null ? companyname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "shippersByShipvia")
//    public Collection<Orders> getOrdersesByShipperid() {
//        return ordersesByShipperid;
//    }
//
//    public void setOrdersesByShipperid(Collection<Orders> ordersesByShipperid) {
//        this.ordersesByShipperid = ordersesByShipperid;
//    }
//

    @Override
    public String toString() {
        return "Shippers{" +
                "shipperid=" + shipperid +
                ", companyname='" + companyname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

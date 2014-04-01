package pl.edu.agh.domain;

import javax.persistence.*;

/**
 * Created by Krzysiu on 2014-04-02.
 */
@Entity
@IdClass(CustomercustomerdemoPK.class)
public class Customercustomerdemo {
    private String customerid;
    private String customertypeid;
    private Customerdemographics customerdemographicsByCustomertypeid;
    private Customers customersByCustomerid;

    @Id
    @Column(name = "customerid")
    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    @Id
    @Column(name = "customertypeid")
    public String getCustomertypeid() {
        return customertypeid;
    }

    public void setCustomertypeid(String customertypeid) {
        this.customertypeid = customertypeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customercustomerdemo that = (Customercustomerdemo) o;

        if (customerid != null ? !customerid.equals(that.customerid) : that.customerid != null) return false;
        if (customertypeid != null ? !customertypeid.equals(that.customertypeid) : that.customertypeid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerid != null ? customerid.hashCode() : 0;
        result = 31 * result + (customertypeid != null ? customertypeid.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customertypeid", referencedColumnName = "customertypeid", nullable = false)
    public Customerdemographics getCustomerdemographicsByCustomertypeid() {
        return customerdemographicsByCustomertypeid;
    }

    public void setCustomerdemographicsByCustomertypeid(Customerdemographics customerdemographicsByCustomertypeid) {
        this.customerdemographicsByCustomertypeid = customerdemographicsByCustomertypeid;
    }

    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "customerid", nullable = false)
    public Customers getCustomersByCustomerid() {
        return customersByCustomerid;
    }

    public void setCustomersByCustomerid(Customers customersByCustomerid) {
        this.customersByCustomerid = customersByCustomerid;
    }
}

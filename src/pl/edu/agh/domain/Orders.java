package pl.edu.agh.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Krzysiu on 2014-04-02.
 */
@Entity
public class Orders {
    private int orderid;
    private Date orderdate;
    private Date requireddate;
    private Date shippeddate;
    private Float freight;
    private String shipname;
    private String shipaddress;
    private String shipcity;
    private String shipregion;
    private String shippostalcode;
    private String shipcountry;
    private Collection<Orderdetails> orderdetailsesByOrderid;
    private Customers customersByCustomerid;
    private Employees employeesByEmployeeid;
    private Shippers shippersByShipvia;

    @Id
    @Column(name = "orderid")
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "orderdate")
    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    @Basic
    @Column(name = "requireddate")
    public Date getRequireddate() {
        return requireddate;
    }

    public void setRequireddate(Date requireddate) {
        this.requireddate = requireddate;
    }

    @Basic
    @Column(name = "shippeddate")
    public Date getShippeddate() {
        return shippeddate;
    }

    public void setShippeddate(Date shippeddate) {
        this.shippeddate = shippeddate;
    }

    @Basic
    @Column(name = "freight")
    public Float getFreight() {
        return freight;
    }

    public void setFreight(Float freight) {
        this.freight = freight;
    }

    @Basic
    @Column(name = "shipname")
    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname;
    }

    @Basic
    @Column(name = "shipaddress")
    public String getShipaddress() {
        return shipaddress;
    }

    public void setShipaddress(String shipaddress) {
        this.shipaddress = shipaddress;
    }

    @Basic
    @Column(name = "shipcity")
    public String getShipcity() {
        return shipcity;
    }

    public void setShipcity(String shipcity) {
        this.shipcity = shipcity;
    }

    @Basic
    @Column(name = "shipregion")
    public String getShipregion() {
        return shipregion;
    }

    public void setShipregion(String shipregion) {
        this.shipregion = shipregion;
    }

    @Basic
    @Column(name = "shippostalcode")
    public String getShippostalcode() {
        return shippostalcode;
    }

    public void setShippostalcode(String shippostalcode) {
        this.shippostalcode = shippostalcode;
    }

    @Basic
    @Column(name = "shipcountry")
    public String getShipcountry() {
        return shipcountry;
    }

    public void setShipcountry(String shipcountry) {
        this.shipcountry = shipcountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (orderid != orders.orderid) return false;
        if (freight != null ? !freight.equals(orders.freight) : orders.freight != null) return false;
        if (orderdate != null ? !orderdate.equals(orders.orderdate) : orders.orderdate != null) return false;
        if (requireddate != null ? !requireddate.equals(orders.requireddate) : orders.requireddate != null)
            return false;
        if (shipaddress != null ? !shipaddress.equals(orders.shipaddress) : orders.shipaddress != null) return false;
        if (shipcity != null ? !shipcity.equals(orders.shipcity) : orders.shipcity != null) return false;
        if (shipcountry != null ? !shipcountry.equals(orders.shipcountry) : orders.shipcountry != null) return false;
        if (shipname != null ? !shipname.equals(orders.shipname) : orders.shipname != null) return false;
        if (shippeddate != null ? !shippeddate.equals(orders.shippeddate) : orders.shippeddate != null) return false;
        if (shippostalcode != null ? !shippostalcode.equals(orders.shippostalcode) : orders.shippostalcode != null)
            return false;
        if (shipregion != null ? !shipregion.equals(orders.shipregion) : orders.shipregion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderid;
        result = 31 * result + (orderdate != null ? orderdate.hashCode() : 0);
        result = 31 * result + (requireddate != null ? requireddate.hashCode() : 0);
        result = 31 * result + (shippeddate != null ? shippeddate.hashCode() : 0);
        result = 31 * result + (freight != null ? freight.hashCode() : 0);
        result = 31 * result + (shipname != null ? shipname.hashCode() : 0);
        result = 31 * result + (shipaddress != null ? shipaddress.hashCode() : 0);
        result = 31 * result + (shipcity != null ? shipcity.hashCode() : 0);
        result = 31 * result + (shipregion != null ? shipregion.hashCode() : 0);
        result = 31 * result + (shippostalcode != null ? shippostalcode.hashCode() : 0);
        result = 31 * result + (shipcountry != null ? shipcountry.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ordersByOrderid")
    public Collection<Orderdetails> getOrderdetailsesByOrderid() {
        return orderdetailsesByOrderid;
    }

    public void setOrderdetailsesByOrderid(Collection<Orderdetails> orderdetailsesByOrderid) {
        this.orderdetailsesByOrderid = orderdetailsesByOrderid;
    }

    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    public Customers getCustomersByCustomerid() {
        return customersByCustomerid;
    }

    public void setCustomersByCustomerid(Customers customersByCustomerid) {
        this.customersByCustomerid = customersByCustomerid;
    }

    @ManyToOne
    @JoinColumn(name = "employeeid", referencedColumnName = "employeeid")
    public Employees getEmployeesByEmployeeid() {
        return employeesByEmployeeid;
    }

    public void setEmployeesByEmployeeid(Employees employeesByEmployeeid) {
        this.employeesByEmployeeid = employeesByEmployeeid;
    }

    @ManyToOne
    @JoinColumn(name = "shipvia", referencedColumnName = "shipperid")
    public Shippers getShippersByShipvia() {
        return shippersByShipvia;
    }

    public void setShippersByShipvia(Shippers shippersByShipvia) {
        this.shippersByShipvia = shippersByShipvia;
    }
}

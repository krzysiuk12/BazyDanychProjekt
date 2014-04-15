package pl.edu.agh.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Krzysiu on 2014-04-15.
 */
@Entity
@Table(name = "Orders")
public class Order {

    private Long id;

    private Set<OrderDetails> orderDetails;
    private Customer customer;
    private Employee employee;
    private Shipper shipViaShipper;

    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private float freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Order_PK_Sequence")
    @SequenceGenerator(name = "Order_PK_Sequence", sequenceName = "Order_PK_Sequence")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }
    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @ManyToOne
    @JoinColumn(name = "customer", nullable = false)
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name = "employeeId", nullable = false)
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne
    @JoinColumn(name = "shipViaShipperId", nullable = false)
    public Shipper getShipViaShipper() {
        return shipViaShipper;
    }
    public void setShipViaShipper(Shipper shipViaShipper) {
        this.shipViaShipper = shipViaShipper;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "orderDate")
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "requiredDate")
    public Date getRequiredDate() {
        return requiredDate;
    }
    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "shippedDate")
    public Date getShippedDate() {
        return shippedDate;
    }
    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    @Basic
    @Column(name = "freight")
    public float getFreight() {
        return freight;
    }
    public void setFreight(float freight) {
        this.freight = freight;
    }

    @Basic
    @Column(name = "shipName")
    public String getShipName() {
        return shipName;
    }
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    @Basic
    @Column(name = "shipAddress")
    public String getShipAddress() {
        return shipAddress;
    }
    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    @Basic
    @Column(name = "shipCity")
    public String getShipCity() {
        return shipCity;
    }
    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    @Basic
    @Column(name = "shipRegion")
    public String getShipRegion() {
        return shipRegion;
    }
    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    @Basic
    @Column(name = "shipPostalCode")
    public String getShipPostalCode() {
        return shipPostalCode;
    }
    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    @Basic
    @Column(name = "shipCountry")
    public String getShipCountry() {
        return shipCountry;
    }
    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }
}

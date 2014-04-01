package pl.edu.agh.domain;

import javax.persistence.*;

/**
 * Created by Krzysiu on 2014-04-02.
 */
@Entity
@IdClass(OrderdetailsPK.class)
public class Orderdetails {
    private int orderid;
    private int productid;
    private float unitprice;
    private int quantity;
    private float discount;
    private Orders ordersByOrderid;
    private Products productsByProductid;

    @Id
    @Column(name = "orderid")
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Id
    @Column(name = "productid")
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    @Basic
    @Column(name = "unitprice")
    public float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(float unitprice) {
        this.unitprice = unitprice;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "discount")
    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderdetails that = (Orderdetails) o;

        if (Float.compare(that.discount, discount) != 0) return false;
        if (orderid != that.orderid) return false;
        if (productid != that.productid) return false;
        if (quantity != that.quantity) return false;
        if (Float.compare(that.unitprice, unitprice) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderid;
        result = 31 * result + productid;
        result = 31 * result + (unitprice != +0.0f ? Float.floatToIntBits(unitprice) : 0);
        result = 31 * result + quantity;
        result = 31 * result + (discount != +0.0f ? Float.floatToIntBits(discount) : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "orderid", referencedColumnName = "orderid", nullable = false)
    public Orders getOrdersByOrderid() {
        return ordersByOrderid;
    }

    public void setOrdersByOrderid(Orders ordersByOrderid) {
        this.ordersByOrderid = ordersByOrderid;
    }

    @ManyToOne
    @JoinColumn(name = "productid", referencedColumnName = "productid", nullable = false)
    public Products getProductsByProductid() {
        return productsByProductid;
    }

    public void setProductsByProductid(Products productsByProductid) {
        this.productsByProductid = productsByProductid;
    }
}

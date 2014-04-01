package pl.edu.agh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Krzysiu on 2014-04-02.
 */
public class OrderdetailsPK implements Serializable {
    private int orderid;
    private int productid;

    @Column(name = "orderid")
    @Id
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Column(name = "productid")
    @Id
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderdetailsPK that = (OrderdetailsPK) o;

        if (orderid != that.orderid) return false;
        if (productid != that.productid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderid;
        result = 31 * result + productid;
        return result;
    }
}

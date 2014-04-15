package pl.edu.agh.domain;

import javax.persistence.*;

/**
 * Created by Krzysiu on 2014-04-15.
 */
@Entity
@Table(name = "OrderDetails")
public class OrderDetail {

    private Long id;

    private Order order;
    private Product product;

    private float unitPrice;
    private int quantity;
    private float discount;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderDetails_PK_Sequence")
    @SequenceGenerator(name = "OrderDetails_PK_Sequence", sequenceName = "OrderDetails_PK_Sequence")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    @Basic
    @Column(name = "unitPrice", nullable = false)
    public float getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "discount", nullable = false)
    public float getDiscount() {
        return discount;
    }
    public void setDiscount(float discount) {
        this.discount = discount;
    }
}

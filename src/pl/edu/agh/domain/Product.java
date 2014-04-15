package pl.edu.agh.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Krzysiu on 2014-04-15.
 */
@Entity
@Table(name = "Products")
public class Product {

    private Long id;

    private Category category;
    private Supplier supplier;

    private String productName;
    private String quantityPerUnit;
    private float unitPrice;
    private int unitsInStock;
    private int unitsOnOrder;
    private int reorderLevel;
    private boolean discontinued;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Product_PK_Sequence")
    @SequenceGenerator(name = "Product_PK_Sequence", sequenceName = "Product_PK_Sequence")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "supplierId", nullable = false)
    public Supplier getSupplier() {
        return supplier;
    }
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Basic
    @Column(name = "productName", nullable = false)
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "quantityPerUnit")
    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }
    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    @Basic
    @Column(name = "unitPrice")
    public float getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "unitsInStock")
    public int getUnitsInStock() {
        return unitsInStock;
    }
    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    @Basic
    @Column(name = "unitsOnOrder")
    public int getUnitsOnOrder() {
        return unitsOnOrder;
    }
    public void setUnitsOnOrder(int unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    @Basic
    @Column(name = "reorderLevel")
    public int getReorderLevel() {
        return reorderLevel;
    }
    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    @Basic
    @Column(name = "discontinued")
    public boolean isDiscontinued() {
        return discontinued;
    }
    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }
}

package pl.edu.agh.tutorial.domain;

import javax.persistence.*;

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
    private boolean discontinued;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Product_PK_Sequence")
    @SequenceGenerator(name = "Product_PK_Sequence", sequenceName = "Product_PK_Sequence", initialValue = 1, allocationSize = 1)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne//(fetch = FetchType.LAZY)
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
    @Column(name = "discontinued")
    public boolean isDiscontinued() {
        return discontinued;
    }
    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Product Informations: ").append("\n");
        builder.append("\t").append("id = ").append(id).append("\n")
                .append("\t").append("productName = ").append(productName).append("\n")
                .append("\t").append("quantityPerUnit = ").append(quantityPerUnit).append("\n")
                .append("\t").append("unitPrice = ").append(unitPrice).append("\n")
                .append("\t").append("unitsInStock = ").append(unitsInStock).append("\n")
                .append("\t").append("discontinued = ").append(discontinued).append("\n");
        return builder.toString();
    }
}

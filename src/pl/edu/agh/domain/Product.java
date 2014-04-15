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

    /*    @Id
    @Column(name = "productid")
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    @Basic
    @Column(name = "productname")
    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    @Basic
    @Column(name = "quantityperunit")
    public String getQuantityperunit() {
        return quantityperunit;
    }

    public void setQuantityperunit(String quantityperunit) {
        this.quantityperunit = quantityperunit;
    }

    @Basic
    @Column(name = "unitprice")
    public Float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Float unitprice) {
        this.unitprice = unitprice;
    }

    @Basic
    @Column(name = "unitsinstock")
    public Integer getUnitsinstock() {
        return unitsinstock;
    }

    public void setUnitsinstock(Integer unitsinstock) {
        this.unitsinstock = unitsinstock;
    }

    @Basic
    @Column(name = "unitsonorder")
    public Integer getUnitsonorder() {
        return unitsonorder;
    }

    public void setUnitsonorder(Integer unitsonorder) {
        this.unitsonorder = unitsonorder;
    }

    @Basic
    @Column(name = "reorderlevel")
    public Integer getReorderlevel() {
        return reorderlevel;
    }

    public void setReorderlevel(Integer reorderlevel) {
        this.reorderlevel = reorderlevel;
    }

    @Basic
    @Column(name = "discontinued")
    public int getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(int discontinued) {
        this.discontinued = discontinued;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (discontinued != products.discontinued) return false;
        if (productid != products.productid) return false;
        if (productname != null ? !productname.equals(products.productname) : products.productname != null)
            return false;
        if (quantityperunit != null ? !quantityperunit.equals(products.quantityperunit) : products.quantityperunit != null)
            return false;
        if (reorderlevel != null ? !reorderlevel.equals(products.reorderlevel) : products.reorderlevel != null)
            return false;
        if (unitprice != null ? !unitprice.equals(products.unitprice) : products.unitprice != null) return false;
        if (unitsinstock != null ? !unitsinstock.equals(products.unitsinstock) : products.unitsinstock != null)
            return false;
        if (unitsonorder != null ? !unitsonorder.equals(products.unitsonorder) : products.unitsonorder != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productid;
        result = 31 * result + (productname != null ? productname.hashCode() : 0);
        result = 31 * result + (quantityperunit != null ? quantityperunit.hashCode() : 0);
        result = 31 * result + (unitprice != null ? unitprice.hashCode() : 0);
        result = 31 * result + (unitsinstock != null ? unitsinstock.hashCode() : 0);
        result = 31 * result + (unitsonorder != null ? unitsonorder.hashCode() : 0);
        result = 31 * result + (reorderlevel != null ? reorderlevel.hashCode() : 0);
        result = 31 * result + discontinued;
        return result;
    }

    @OneToMany(mappedBy = "productsByProductid")
    public Collection<Orderdetails> getOrderdetailsesByProductid() {
        return orderdetailsesByProductid;
    }

    public void setOrderdetailsesByProductid(Collection<Orderdetails> orderdetailsesByProductid) {
        this.orderdetailsesByProductid = orderdetailsesByProductid;
    }

    @ManyToOne
    @JoinColumn(name = "categoryid", referencedColumnName = "categoryid")
    public Categories getCategoriesByCategoryid() {
        return categoriesByCategoryid;
    }

    public void setCategoriesByCategoryid(Categories categoriesByCategoryid) {
        this.categoriesByCategoryid = categoriesByCategoryid;
    }

    @ManyToOne
    @JoinColumn(name = "supplierid", referencedColumnName = "supplierid")
    public Suppliers getSuppliersBySupplierid() {
        return suppliersBySupplierid;
    }

    public void setSuppliersBySupplierid(Suppliers suppliersBySupplierid) {
        this.suppliersBySupplierid = suppliersBySupplierid;
    }*/
}

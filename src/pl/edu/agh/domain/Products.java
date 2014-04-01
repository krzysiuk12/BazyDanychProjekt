package pl.edu.agh.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Krzysiu on 2014-04-02.
 */
@Entity
public class Products {
    private int productid;
    private String productname;
    private String quantityperunit;
    private Float unitprice;
    private Integer unitsinstock;
    private Integer unitsonorder;
    private Integer reorderlevel;
    private int discontinued;
    private Collection<Orderdetails> orderdetailsesByProductid;
    private Categories categoriesByCategoryid;
    private Suppliers suppliersBySupplierid;

    @Id
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
    }
}

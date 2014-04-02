package pl.edu.agh.domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Krzysiu on 2014-04-02.
 */
@Entity
public class Categories {
    private int categoryid;
    private String categoryname;
    private String description;
    private byte[] picture;
    private Collection<Products> productsesByCategoryid;

    @Id
    @Column(name = "categoryid")
    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    @Basic
    @Column(name = "categoryname")
    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "picture")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categories that = (Categories) o;

        if (categoryid != that.categoryid) return false;
        if (categoryname != null ? !categoryname.equals(that.categoryname) : that.categoryname != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (!Arrays.equals(picture, that.picture)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryid;
        result = 31 * result + (categoryname != null ? categoryname.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (picture != null ? Arrays.hashCode(picture) : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoriesByCategoryid")
    public Collection<Products> getProductsesByCategoryid() {
        return productsesByCategoryid;
    }

    public void setProductsesByCategoryid(Collection<Products> productsesByCategoryid) {
        this.productsesByCategoryid = productsesByCategoryid;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "description='" + description + '\'' +
                ", categoryname='" + categoryname + '\'' +
                ", categoryid=" + categoryid +
                '}';
    }
}

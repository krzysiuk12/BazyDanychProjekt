package pl.edu.agh.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Krzysiu on 2014-04-15.
 */
@Entity
@Table(name = "Categories")
public class Category {

    private Long id;

    private Set<Product> categoryProducts;

    private String categoryName;
    private String description;
    private byte[] picture;

    public Category() {
    }

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "Category_PK_Sequence")
    @SequenceGenerator(name = "Category_PK_Sequence", sequenceName = "Category_PK_Sequence", initialValue = 1, allocationSize = 1)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @NotNull
    @Column(name = "categoryName", unique = true)
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Lob
    @Column(name = "picture")
    public byte[] getPicture() {
        return picture;
    }
    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
    public Set<Product> getCategoryProducts() {
        return categoryProducts;
    }
    public void setCategoryProducts(Set<Product> categoryProducts) {
        this.categoryProducts = categoryProducts;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Category Informations:\n");
        builder.append("\t").append("id = ").append(id).append("\n")
               .append("\t").append("categoryName = ").append(categoryName).append("\n")
               .append("\t").append("description = ").append(description).append("\n");
        return builder.toString();
    }
}

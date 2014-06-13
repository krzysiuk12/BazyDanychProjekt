package pl.edu.agh.tutorial.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Krzysiu on 2014-04-15.
 */
@Entity
@Table(name = "Suppliers")
public class Supplier {

    private Long id;

    private Address address;
    private Set<Product> suppliedProducts;

    private String companyName;
    private String phone;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Supplier_PK_Sequence")
    @SequenceGenerator(name = "Supplier_PK_Sequence", sequenceName = "Supplier_PK_Sequence", initialValue = 1, allocationSize = 1)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId", nullable = false)
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    @Basic
    @NotNull
    @Column(name = "companyName")
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier", fetch = FetchType.LAZY)
    public Set<Product> getSuppliedProducts() {
        return suppliedProducts;
    }
    public void setSuppliedProducts(Set<Product> suppliedProducts) {
        this.suppliedProducts = suppliedProducts;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Supplier Informations: ").append("\n");
        builder.append("\t").append("id = ").append(id).append("\n")
                .append("\t").append("companyName = ").append(companyName).append("\n")
                .append("\t").append("address = ").append(address).append("\n")
                .append("\t").append("phone = ").append(phone).append("\n");

        return builder.toString();

    }
}

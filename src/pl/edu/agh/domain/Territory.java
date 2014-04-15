package pl.edu.agh.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Krzysiu on 2014-04-15.
 */
@Entity
@Table(name = "Territories")
public class Territory {

    private Long id;

    private Region region;
    private Set<EmployeeTerritory> employeeTerritories;

    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Territory_PK_Sequence")
    @SequenceGenerator(name = "Territory_PK_Sequence", sequenceName = "Territory_PK_Sequence")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name = "regionId", nullable = false)
    public Region getRegion() {
        return region;
    }
    public void setRegion(Region region) {
        this.region = region;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "territory", fetch = FetchType.LAZY)
    public Set<EmployeeTerritory> getEmployeeTerritories() {
        return employeeTerritories;
    }
    public void setEmployeeTerritories(Set<EmployeeTerritory> employeeTerritories) {
        this.employeeTerritories = employeeTerritories;
    }
}

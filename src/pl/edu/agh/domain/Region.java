package pl.edu.agh.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Krzysiu on 2014-04-15.
 */
@Entity
@Table(name = "Region")
public class Region {

    private Long id;
    private String description;
    private Set<Territory> territories;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Region_PK_Sequence")
    @SequenceGenerator(name = "Region_PK_Sequence", sequenceName = "Region_PK_Sequence")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "regionDescription")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "region", fetch = FetchType.LAZY)
    public Set<Territory> getTerritories() {
        return territories;
    }
    public void setTerritories(Set<Territory> territories) {
        this.territories = territories;
    }
}

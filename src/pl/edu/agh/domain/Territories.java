package pl.edu.agh.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Krzysiu on 2014-04-02.
 */
@Entity
public class Territories {
    private String territoryid;
    private String territorydescription;
    private Collection<Employeeterritories> employeeterritoriesesByTerritoryid;
    private Region regionByRegionid;

    @Id
    @Column(name = "territoryid")
    public String getTerritoryid() {
        return territoryid;
    }

    public void setTerritoryid(String territoryid) {
        this.territoryid = territoryid;
    }

    @Basic
    @Column(name = "territorydescription")
    public String getTerritorydescription() {
        return territorydescription;
    }

    public void setTerritorydescription(String territorydescription) {
        this.territorydescription = territorydescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Territories that = (Territories) o;

        if (territorydescription != null ? !territorydescription.equals(that.territorydescription) : that.territorydescription != null)
            return false;
        if (territoryid != null ? !territoryid.equals(that.territoryid) : that.territoryid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = territoryid != null ? territoryid.hashCode() : 0;
        result = 31 * result + (territorydescription != null ? territorydescription.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "territoriesByTerritoryid")
    public Collection<Employeeterritories> getEmployeeterritoriesesByTerritoryid() {
        return employeeterritoriesesByTerritoryid;
    }

    public void setEmployeeterritoriesesByTerritoryid(Collection<Employeeterritories> employeeterritoriesesByTerritoryid) {
        this.employeeterritoriesesByTerritoryid = employeeterritoriesesByTerritoryid;
    }

    @ManyToOne
    @JoinColumn(name = "regionid", referencedColumnName = "regionid", nullable = false)
    public Region getRegionByRegionid() {
        return regionByRegionid;
    }

    public void setRegionByRegionid(Region regionByRegionid) {
        this.regionByRegionid = regionByRegionid;
    }
}

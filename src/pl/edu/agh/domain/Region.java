package pl.edu.agh.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Krzysiu on 2014-04-02.
 */
@Entity
public class Region {
    private int regionid;
    private String regiondescription;
    private Collection<Territories> territoriesesByRegionid;

    @Id
    @Column(name = "regionid")
    public int getRegionid() {
        return regionid;
    }

    public void setRegionid(int regionid) {
        this.regionid = regionid;
    }

    @Basic
    @Column(name = "regiondescription")
    public String getRegiondescription() {
        return regiondescription;
    }

    public void setRegiondescription(String regiondescription) {
        this.regiondescription = regiondescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Region region = (Region) o;

        if (regionid != region.regionid) return false;
        if (regiondescription != null ? !regiondescription.equals(region.regiondescription) : region.regiondescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = regionid;
        result = 31 * result + (regiondescription != null ? regiondescription.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "regionByRegionid")
    public Collection<Territories> getTerritoriesesByRegionid() {
        return territoriesesByRegionid;
    }

    public void setTerritoriesesByRegionid(Collection<Territories> territoriesesByRegionid) {
        this.territoriesesByRegionid = territoriesesByRegionid;
    }
}

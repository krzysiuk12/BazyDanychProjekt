package pl.edu.agh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Krzysiu on 2014-04-02.
 */
public class EmployeeterritoriesPK implements Serializable {
    private int employeeid;
    private String territoryid;

    @Column(name = "employeeid")
    @Id
    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    @Column(name = "territoryid")
    @Id
    public String getTerritoryid() {
        return territoryid;
    }

    public void setTerritoryid(String territoryid) {
        this.territoryid = territoryid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeterritoriesPK that = (EmployeeterritoriesPK) o;

        if (employeeid != that.employeeid) return false;
        if (territoryid != null ? !territoryid.equals(that.territoryid) : that.territoryid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeid;
        result = 31 * result + (territoryid != null ? territoryid.hashCode() : 0);
        return result;
    }
}

package pl.edu.agh.domain;

import javax.persistence.*;

/**
 * Created by Krzysiu on 2014-04-02.
 */
@Entity
@IdClass(EmployeeterritoriesPK.class)
public class Employeeterritories {
    private int employeeid;
    private String territoryid;
    private Employees employeesByEmployeeid;
    private Territories territoriesByTerritoryid;

    @Id
    @Column(name = "employeeid")
    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    @Id
    @Column(name = "territoryid")
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

        Employeeterritories that = (Employeeterritories) o;

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

    @ManyToOne
    @JoinColumn(name = "employeeid", referencedColumnName = "employeeid", nullable = false)
    public Employees getEmployeesByEmployeeid() {
        return employeesByEmployeeid;
    }

    public void setEmployeesByEmployeeid(Employees employeesByEmployeeid) {
        this.employeesByEmployeeid = employeesByEmployeeid;
    }

    @ManyToOne
    @JoinColumn(name = "territoryid", referencedColumnName = "territoryid", nullable = false)
    public Territories getTerritoriesByTerritoryid() {
        return territoriesByTerritoryid;
    }

    public void setTerritoriesByTerritoryid(Territories territoriesByTerritoryid) {
        this.territoriesByTerritoryid = territoriesByTerritoryid;
    }
}

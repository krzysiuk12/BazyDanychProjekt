package pl.edu.agh.domain;

import javax.persistence.*;

/**
 * Created by Krzysiu on 2014-04-15.
 */
@Entity
@Table(name = "EmployeeTerritories")
public class EmployeeTerritory {

    private Long id;
    private Territory territory;
    private Employee employee;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EmployeeTerritory_PK_Sequence")
    @SequenceGenerator(name = "EmployeeTerritory_PK_Sequence", sequenceName = "EmployeeTerritory_PK_Sequence")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "territoryId", nullable = false)
    public Territory getTerritory() {
        return territory;
    }
    public void setTerritory(Territory territory) {
        this.territory = territory;
    }

    @ManyToOne
    @JoinColumn(name = "employeeId", nullable = false)
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
